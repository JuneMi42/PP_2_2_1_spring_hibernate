package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void save(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("from User", User.class).getResultList();
   }

   @Override
   public User getUser(String model, int series) {
      return entityManager.createQuery("""
                      select
                       user from User user where user.car.model = :model and user.car.series = :series
                      """, User.class)
      .setParameter("model", model)
      .setParameter("series", series)
              .getSingleResult();
   }

   @Override
   public void dropTables() {
      entityManager.createNativeQuery("DROP TABLE IF EXISTS users, cars").executeUpdate();
   }
}
