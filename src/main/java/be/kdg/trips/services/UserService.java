package be.kdg.trips.services;

import be.kdg.trips.model.user.User;
import be.kdg.trips.model.user.exception.UserException;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public interface UserService {
    public void addUser(String email, String password) throws UserException;
    public User getUser(String email) throws UserException;
    public boolean checkLogin(String email, String password);

}
