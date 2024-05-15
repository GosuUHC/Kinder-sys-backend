package backend.infrastructure.in.rest.path;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.RecommendationRequest;
import backend.infrastructure.util.requestMapper.RecommendationRequestMapper;
import backend.service.recommendation.interfaces.in.IRecommendationService;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/recommendations")
public class Recommendations {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IRecommendationService recommendationService;

    @Inject
    private RecommendationRequestMapper recommendationRequestMapper;

    private Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    // Получение рекомендаций
    public Response getRecommendations() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            return Response.ok(recommendationService.findAllRecommendations()).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{categoryId}")
    // Получение рекомендаций по id категории
    public Response getRecommendationsByCategoryId(@PathParam("categoryId") Long categoryId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            return Response.ok(recommendationService.findRecommendationsByCategoryId(categoryId)).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/groups/{groupId}")
    // Получение рекомендаций для группы по id группы
    // получить список diagnosticsResult для группы,
    // для каждой категории и подкатегории, которые есть в этом списке найти
    // рекомендацию
    public Response getRecommendationsByGroupId(@PathParam("groupId") Long groupId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            return Response.ok(recommendationService.findRecommendationsByChildGroupId(groupId)).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    // Добавление рекомендации
    public Response postRecommendation(String requestBody) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            RecommendationRequest recommendationRequest = jsonb.fromJson(requestBody, RecommendationRequest.class);

            recommendationService.saveRecommendation(recommendationRequestMapper.toDTO(recommendationRequest));

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @DELETE
    @TokenRequired
    @Path("/{recommendationId}")
    // Удаление рекомендации
    public Response deleteCategory(@PathParam("recommendationId") Long recommendationId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        try {

            recommendationService.deleteRecommendation(recommendationService.findRecommendationById(recommendationId));

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    // @PUT
    // @Consumes(MediaType.APPLICATION_JSON)
    // @TokenRequired
    // // Изменение рекомендации
    // public Response updateRecommendation(String requestBody) {
    // String error = requestContext.getProperty("checkToken").toString();
    // if (error.equals("false")) {
    // return Response.status(Response.Status.UNAUTHORIZED).build();
    // }

    // return Response.status(Response.Status.OK).build();
    // }
}
