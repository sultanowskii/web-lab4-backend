package web.lab4.server.service.pointCheck;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.lab4.server.model.PointCheck;
import web.lab4.server.model.User;
import web.lab4.server.util.PointChecker;

import java.util.List;

@Stateless
public class PointCheckService {

    @PersistenceContext
    private EntityManager entityManager;

    public PointCheck createPointCheckForUser(int x, double y, int r, User user) {
        boolean isHit = PointChecker.isPointIsnideArea(x, y, r);
        var pointCheck = new PointCheck(x, y, r, isHit);
        entityManager.persist(pointCheck);
        entityManager.flush();
        return pointCheck;
    }

    public List<PointCheck> getPreviousChecks(User user) {
        return entityManager.createQuery("SELECT pc FROM PointCheck pc WHERE pc.user = :user", PointCheck.class)
                .setParameter("user", user)
                .getResultList();
    }
}
