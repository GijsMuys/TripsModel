package be.kdg.trips;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Subversion ${Id}
 * Project Application Development
 * Karel de Grote-Hogeschool
 * 2012-2013
 */
public class Demo {

    public static void main(String[] args) {


        final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("userService");
    }
}

