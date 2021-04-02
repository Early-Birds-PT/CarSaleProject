package repository.repository_impl;


import data.EntityManagerProvider;
import data.model.entity.Employee;
import repository.EmployeeRepository;
import data.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

        return employee;
    }

    @Override
    public boolean deleteEmployee(int employeeNumber) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, employeeNumber);


        if(employee == null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }
        List<Employee> employees =findAllEmployeesByRefersTo(employee);

        employees.forEach(e -> {
            e.setEmployee(null);
            updateEmployee(e);
        });

        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List<Employee> findAllEmployeesByRefersTo(Employee employee) {
        String query = "SELECT e FROM Employee e WHERE e.employee = :employee";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<Employee> typedQuery = em.createQuery(query, Employee.class);
        typedQuery.setParameter("employee", employee);
        List<Employee> employees = typedQuery.getResultList();

        em.getTransaction().commit();

        em.close();
        return employees;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT e FROM Employee e";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<Employee> typedQuery = em.createQuery(query, Employee.class);
        List<Employee> employees = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        return employees;
    }
}
