package web.lab4.server.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.lab4.server.model.User;

@Stateless
public class AuthService {

    @PersistenceContext
    private EntityManager entityManager;

    public void registerUser(User user) {
        entityManager.persist(user);
    }

    public boolean login(User user) {
        // Реализация проверки входа пользователя
        // Проверка пароля и т.д.
        return true;
    }

    public void logout() {
        // Реализация выхода из системы
    }
}
