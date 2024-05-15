package backend.infrastructure.in.rest.path;

import java.util.ArrayList;
import java.util.List;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.DiagnosticsRequest;
import backend.infrastructure.util.requestMapper.DiagnosticRequestMapper;
import backend.service.diagnosticResult.interfaces.in.IDiagnosticResultService;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/diagnostics")
public class Diagnostics {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IDiagnosticResultService diagnosticResultService;

    @Inject
    private DiagnosticRequestMapper diagnosticRequestMapper;

    private Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    @Path("/{groupId}")
    // Получение диагностических данных по id группы
    public Response getDiagonsticsByGroupId(@PathParam("groupId") Long groupId) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            return Response.ok(diagnosticResultService.findDiagnosticResultByChildGroupId(groupId)).build();
        } catch (JsonbException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenRequired
    // занесение диагностических данных
    public Response postDiagnostics(String requestBody) {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        try {
            List<DiagnosticsRequest> diagnosticsRequests = jsonb.fromJson(requestBody,
                    new ArrayList<DiagnosticsRequest>() {
                    }.getClass().getGenericSuperclass());

            for (DiagnosticsRequest diagnosticsRequest : diagnosticsRequests) {
                diagnosticResultService.saveDiagnosticResult(diagnosticRequestMapper.toDTO(diagnosticsRequest));
            }

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
    // // изменение диагностических данных
    // public Response updateDiagnosticsData(String requestBody) {
    // String error = requestContext.getProperty("checkToken").toString();
    // if (error.equals("false")) {
    // return Response.status(Response.Status.UNAUTHORIZED).build();
    // }

    // return Response.status(Response.Status.OK).build();
    // }
}
