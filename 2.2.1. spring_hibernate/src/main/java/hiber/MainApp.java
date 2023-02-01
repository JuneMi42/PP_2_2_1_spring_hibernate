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



      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Toyota", 234);
      user1.setCar(car1);
      userService.save(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Mitsubishi", 356);
      user2.setCar(car2);
      userService.save(user2);

      List<Car> cars = carService.listCar();
      for (Car car : cars) {
         System.out.println("CarList = " + car + "\n");
      }

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + "\n");
      }
      System.out.println(userService.getUser("Toyota", 234));

      userService.dropTables();

      context.close();
   }
}
