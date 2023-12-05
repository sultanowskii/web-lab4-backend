package web.lab4.server.web.pointCheck;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import web.lab4.server.model.PointCheck;
import web.lab4.server.model.User;
import web.lab4.server.service.PointCheckService;

import java.util.List;

@Stateless
@Path("/api/checks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PointCheckResource {

    @EJB
    private PointCheckService pointCheckService;

    // TODO: проверка на авторизацию
    @POST
    @Path("/check")
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
    public List<PointCheck> getPreviousChecks() {
        // TODO: получить пользователя из сессии
        User user = null;
        return pointCheckService.getPreviousChecks(null);
    }

    @GET
    @Path("/hello")
    public String hello() {
        return "{\"hello\": 123}";
    }
}
