package be.kdg.trips.model.user.exception;

import org.springframework.stereotype.Component;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
@Component
public class UserException extends Exception {
    public UserException(String message){
        super(message);
    }
}
