package be.kdg.trips;

import be.kdg.trips.facade.TripManager;
import be.kdg.trips.model.user.exception.UserException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public class TestUser {
    private TripManager tripManager;

    @Before
    public  void createTripManager(){
        tripManager = TripManager.getInstance();
    }

    @Test
    public void registerUnexistingUser() throws UserException {
        tripManager.registerUser("gijs.muys", "password");
        assertNotNull(tripManager.getUser("gijs.muys"));
    }

    @Test(expected = UserException.class)
    public void registerExistingUser() throws UserException {
        tripManager.registerUser("keke", "password");
        tripManager.registerUser("keke", "password");
    }

   @Test
    public void getExistingUser() throws UserException {
       tripManager.registerUser("robin", "password");
        assertNotNull(tripManager.getUser("robin"));
    }

    @Test(expected = UserException.class)
    public void getUnexistingUser() throws UserException {
        tripManager.getUser("mathias");
    }

    @Test
    public void succesfulLogin() throws UserException {
        tripManager.registerUser("joris", "password");
        assertTrue(tripManager.checkLogin("joris", "password"));
    }

    @Test
    public void failLogin() throws UserException {
        tripManager.registerUser("joel", "password");
        assertFalse(tripManager.checkLogin("joel", "joel"));
    }
}
