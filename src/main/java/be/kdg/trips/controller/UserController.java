package be.kdg.trips.controller;

import be.kdg.trips.model.user.User;
import be.kdg.trips.model.user.exception.UserException;
import be.kdg.trips.persistence.dao.impl.UserDaoImpl;
import be.kdg.trips.persistence.dao.interfaces.UserDao;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public class UserController {
    private UserDao userDao;

    public UserController() {
        this.userDao = new UserDaoImpl();
    }

    public void addUser(String email, String password) throws UserException {
        if(getUser(email).isNull())
        {
            userDao.addUser(new User(email, password));
        }
        else
        {
            throw new UserException("User with email '"+email+"' already exists");
        }
    }

    public User getUser(String email){
        return userDao.getUser(email);
    }
}
