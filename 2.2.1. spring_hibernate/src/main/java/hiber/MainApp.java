package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      User user1 = context.getBean(User.class);
      Car car1 = context.getBean(Car.class);

      user1.setFields("User1", "Lastname1", "user1@mail.ru");
      car1.setFields("Toyota", 234);
      userService.add(user1);

      user1.setFields("User2", "Lastname2", "user2@mail.ru");
      car1.setFields("Mitsubishi", 356);
      userService.add(user1);

      List<Car> cars = carService.listCar();
      System.out.println("CarList = " + cars);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUser("Toyota", 234));

      context.close();
   }
}
