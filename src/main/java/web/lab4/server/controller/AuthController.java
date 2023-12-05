package web.lab4.server.controller;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import web.lab4.server.model.User;
import web.lab4.server.service.AuthService;

@Stateless
@Path("/api/auth")
public class AuthController {

    @Inject
    private AuthService authService;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(User user) {
        authService.registerUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        if (authService.login(user)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    // TODO: проверка на авторизацию
    @POST
    @Path("/logout")
    public Response logout() {
        // TODO: получить пользователя из сессии
        authService.logout();
        return Response.status(Response.Status.OK).build();
    }
}
