package repository.repository_impl;


import data.EntityManagerProvider;
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


        return employee;
    }

    @Override
    public Employee readEmployee(int employeeNumber) {
        return null;
    }

    @Override
    public Employee readEmployee(String employeeName) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }
}
