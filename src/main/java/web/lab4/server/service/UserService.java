package web.lab4.server.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.lab4.server.model.User;

@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean createUser(User user) {
        if (isUsernameOccupied(user.getUsername())) {
            return false;
        }

        updateUser(user);

        return true;
    }

    public void updateUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    public boolean isUserWithPasswordExist(String username, String password) {
        int userCount = entityManager.createQuery("SELECT user FROM User user WHERE user.username = :username AND user.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList().size();

        return userCount > 0;
    }

    public boolean isUsernameOccupied(String username) {
        int userCount = entityManager.createQuery("SELECT user FROM User user WHERE user.username = :username", User.class)
            .setParameter("username", username)
            .getResultList().size();

        return userCount > 0;
    }
}
