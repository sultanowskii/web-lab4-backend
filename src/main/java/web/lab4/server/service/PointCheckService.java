package web.lab4.server.service;

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

    public boolean createPointCheckForUser(double x, double y, double r, User user) {
        // TODO: лоигка создания
        // TODO: логика проверки на успех
        // TODO: мб изменить сигнатуру?
        boolean isHit = PointChecker.isPointIsnideArea(x, y, r);
        return true;
    }

    public List<PointCheck> getPreviousChecks(User user) {
        return entityManager.createQuery("SELECT pc FROM PointCheck pc WHERE pc.user = :user", PointCheck.class)
                .setParameter("user", user)
                .getResultList();
    }
}
