package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru",
                new Car("Rolls-Royce", 12345)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru",
                new Car("Marusia", 333)));
        userService.add(new User("UUU", "Lastname3", "user3@mail.ru",
                new Car("Marusia", 444)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru",
                new Car("Bugatti", 1000)));

        userService.listUsers().forEach(System.out::println);

        System.out.println(userService.findUserByCar("Marusia", 444));

        context.close();
    }
}
