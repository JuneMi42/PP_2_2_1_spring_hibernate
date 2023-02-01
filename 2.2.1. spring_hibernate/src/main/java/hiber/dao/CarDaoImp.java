package hiber.dao;


import hiber.model.Car;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Repository
public class CarDaoImp implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(Car car) {
        entityManager.persist(car);
    }

    @Override
    public List<Car> listCar() {
        return entityManager.createQuery("from Car", Car.class).getResultList();
    }
}
