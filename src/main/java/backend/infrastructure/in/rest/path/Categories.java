package backend.infrastructure.in.rest.path;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.CategoryRequest;
import backend.infrastructure.util.requestMapper.CategoryRequestMapper;
import backend.service.category.interfaces.in.ICategoryService;
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

@Path("/categories")
public class Categories {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private ICategoryService categoryService;

    @Inject
    private CategoryRequestMapper categoryRequestMapper;

    private Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    // Получение списка категорий
    public Response getCategories() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            return Response.ok(categoryService.findAllCategories()).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    // Создание новой категории
    public Response postCategory(String requestBody) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            CategoryRequest categoryRequest = jsonb.fromJson(requestBody, CategoryRequest.class);

            categoryService.saveCategory(categoryRequestMapper.toDTO(categoryRequest));

            return Response.ok().build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @DELETE
    @TokenRequired
    @Path("/{categoryId}")
    // Удаление категории
    public Response deleteCategory(@PathParam("categoryId") Long categoryId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {

            categoryService.deleteCategory(categoryService.findCategoryById(categoryId));

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
    // // Редактирование категории
    // public Response updateCategory(String requestBody) {
    // String error = requestContext.getProperty("checkToken").toString();
    // if (error.equals("false")) {
    // return Response.status(Response.Status.UNAUTHORIZED).build();
    // }

    // try {
    // CategoryRequest categoryRequest = jsonb.fromJson(requestBody,
    // CategoryRequest.class);

    // categoryService.deleteCategory(categoryService.findCategoryById(categoryRequest.));

    // categoryService.(categoryRequestMapper.toDTO(categoryRequest));

    // return Response.ok().build();
    // } catch (JsonbException | IllegalArgumentException e) {
    // return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
    // } catch (Exception e) {
    // return
    // Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
    // }

    // }

}
