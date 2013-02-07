package be.kdg.trips;

import be.kdg.trips.facade.TripManager;
import be.kdg.trips.model.user.exception.UserException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public class TestUser {
    private static TripManager tripManager;

    @BeforeClass
    public static void createTripManager(){
        tripManager = TripManager.getInstance();
    }

    @Test
    public void registerUnexistingUser() throws UserException {
        tripManager.registerUser("gijs.muys", "password");
        assertNotNull(tripManager.getUser("gijs.muys"));
    }

    @Test(expected=UserException.class)
    public void registerExistingUser() throws UserException {
        tripManager.registerUser("gijs.muys", "password");
        tripManager.registerUser("gijs.muys", "password");
    }

}