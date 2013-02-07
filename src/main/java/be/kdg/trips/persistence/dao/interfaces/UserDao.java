package be.kdg.trips.persistence.dao.interfaces;

import be.kdg.trips.model.user.User;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public interface UserDao {
    public User getUser(String email);
    public void addUser(User user);
}
