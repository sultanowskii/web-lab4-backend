package web.lab4.server.controller;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import web.lab4.server.model.PointCheck;
import web.lab4.server.model.User;
import web.lab4.server.service.PointCheckService;

import java.util.List;

@Stateless
@Path("/api/checks")
public class PointCheckController {

    @Inject
    private PointCheckService pointCheckService;

    // TODO: проверка на авторизацию
    @POST
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean check(@QueryParam("X") double x, @QueryParam("Y") double y, @QueryParam("R") double r) {
        // TODO: получить пользователя из сессии
        User user = null;
        pointCheckService.createPointCheckForUser(x, y, r, user);
        // TODO: возвращать адекватный HTTP-статус
        return true;
    }

    // TODO: проверка на авторизацию
    @GET
    @Path("/previousChecks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PointCheck> getPreviousChecks() {
        // TODO: получить пользователя из сессии
        User user = null;
        return pointCheckService.getPreviousChecks(null);
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "{\"hello\": 123}";
    }
}
