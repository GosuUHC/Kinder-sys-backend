package backend.infrastructure.in.rest.path;

import backend.infrastructure.builder.Built;
import backend.infrastructure.in.rest.interceptor.TokenRequired;
import backend.infrastructure.in.rest.request.AuthUserRequest;
import backend.infrastructure.in.rest.token.ITokenManager;
import backend.infrastructure.out.response.AuthUserResponse;
import backend.service.user.dto.UserDTO;
import backend.service.user.interfaces.in.IUserService;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class Auth {

    @Context
    private ContainerRequestContext requestContext;

    @Inject
    @Built
    private IUserService userService;

    @Inject
    private ITokenManager tokenManager;

    private Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @TokenRequired
    public Response getUsers() {
        String error = requestContext.getProperty("checkToken").toString();
        if (error.equals("false")) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        return Response.ok(userService.findAllUsers()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    // Вход пользователя
    public Response authUser(String requestBody) {
        
        AuthUserRequest authUserRequest = jsonb.fromJson(requestBody, AuthUserRequest.class);

        UserDTO user = userService.checkUser(authUserRequest.getLogin(), authUserRequest.getPassword());

        if (user != null) {
            String token = tokenManager.generateToken(user.getLogin(), user.getRole());
            return Response.ok(new AuthUserResponse(user.getLogin(), token, user.getRole())).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("reg")
    // Регистрация нового пользователя
    public Response regUser(String requestBody) {
        // String error = requestContext.getProperty("checkToken").toString();
        // if (error.equals("false")) {
        //     return Response.status(Response.Status.UNAUTHORIZED).build();
        // }
        UserDTO userDTO = jsonb.fromJson(requestBody, UserDTO.class);

        userService.saveUser(userDTO);

        return Response.status(Response.Status.OK).build();
    }
}
