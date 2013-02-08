package be.kdg.trips;

import be.kdg.trips.model.user.exception.UserException;
import be.kdg.trips.services.UserServiceImpl;
import be.kdg.trips.services.UserService;
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
    private UserService userService;

    @Before
    public  void createTripManager(){
        userService = new UserServiceImpl();
    }

    @Test
    public void registerUnexistingUser() throws UserException {
        userService.addUser("gijs.muys", "password");
        assertNotNull(userService.getUser("gijs.muys"));
    }

    @Test(expected = UserException.class)
    public void registerExistingUser() throws UserException {
        userService.addUser("keke", "password");
        userService.addUser("keke", "password");
    }

    @Test
    public void getExistingUser() throws UserException {
        userService.addUser("robin", "password");
        assertNotNull(userService.getUser("robin"));
    }

    @Test(expected = UserException.class)
    public void getUnexistingUser() throws UserException {
        userService.getUser("mathias");
    }

    @Test
    public void succesfulLogin() throws UserException {
        userService.addUser("joris", "password");
        assertTrue(userService.checkLogin("joris", "password"));
    }

    @Test
    public void failLogin() throws UserException {
        userService.addUser("joel", "password");
        assertFalse(userService.checkLogin("joel", "joel"));
    }
}
