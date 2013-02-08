package be.kdg.trips.facade;

import be.kdg.trips.model.user.User;
import be.kdg.trips.controller.UserController;
import be.kdg.trips.model.user.exception.UserException;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public class TripManager {
    private static TripManager tripManager;
    private UserController userController;

    private TripManager() {
        userController = new UserController();
    }

    public static TripManager getInstance(){
        if(tripManager==null){
            tripManager = new TripManager();
        }
        return tripManager;
    }

    public void registerUser(String email, String password) throws UserException {
        userController.addUser(email,password);
    }

    public User getUser(String email) throws UserException {
        return userController.getUser(email);
    }

}
