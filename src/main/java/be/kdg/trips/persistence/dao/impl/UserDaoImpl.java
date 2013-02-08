package be.kdg.trips.persistence.dao.impl;

import be.kdg.trips.model.user.NullUser;
import be.kdg.trips.model.user.User;
import be.kdg.trips.persistence.dao.interfaces.UserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Subversion id
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public class UserDaoImpl implements UserDao {
    private Map<String, User> users = new HashMap<String, User>();

    @Override
    public User getUser(String email) {
        User user;

        try{
            user = users.get(email);

            //dit is even tijdelijk een extra if want zonder databank wordt er geen exception gethrowed
            //normaal zou er geen controle moeten zijn want als databank die user niet vindt wordt er (hopelijk?) hibernate error gethrowd
            if(user.equals(null)){
                user = NullUser.getInstance();
            }


        }catch(Exception ex){
            user = NullUser.getInstance();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        users.put(user.getEmail(),user);
    }
}
