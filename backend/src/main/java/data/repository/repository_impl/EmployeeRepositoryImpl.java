package data.repository.repository_impl;


import data.EntityManagerProvider;
import data.repository.EmployeeRepository;
import model.entity.Employee;


import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee createEmployee(Employee employee) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        employee = entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();


        return employee;
    }
}
