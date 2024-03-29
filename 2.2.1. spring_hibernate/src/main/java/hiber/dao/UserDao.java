package hiber.dao;

import hiber.model.User;
import java.util.List;

public interface UserDao {
   void save(User user);

   List<User> listUsers();

   User getUser(String model, int series);

   void dropTables();
}
