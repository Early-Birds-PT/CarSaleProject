package repository.repository_impl;


import data.EntityManagerProvider;
import data.model.entity.Customer;
import repository.EmployeeRepository;
import data.model.entity.Employee;


import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public Employee createEmployee(Employee employee) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        employee = entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Employee is created");

        return employee;

    }

    @Override
    public Employee readEmployee(int employeeNumber) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class,employeeNumber);
        entityManager.getTransaction().commit();
        entityManager.close();

        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        employee = entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Employee is updated");

        return employee;
    }

    @Override
    public boolean deleteEmployee(int employeeNumber) {
        return false;

    }
}
