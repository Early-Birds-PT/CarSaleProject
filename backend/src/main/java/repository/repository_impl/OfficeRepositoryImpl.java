package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Employee;
import data.model.entity.Office;
import repository.EmployeeRepository;
import repository.OfficeRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class OfficeRepositoryImpl implements OfficeRepository {

    @Override
    public Office createOffice(Office office) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(office);

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("Office is created");

        return office;
    }

    @Override
    public Office readOffice(String officeCode) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Office office = entityManager.find(Office.class, officeCode);
        entityManager.getTransaction().commit();
        entityManager.close();

        return office;
    }

    @Override
    public Office updateOffice(Office office) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        office = entityManager.merge(office);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Office is updated");

        return office;
    }

    @Override
    public boolean deleteOffice(String officeCode) {
        // all related employee should be transferred  to other office before delete operation

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        Office office = entityManager.find(Office.class, officeCode);


        if(office == null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }
/*
        if(setOfficeCodeToNull(entityManager)){
            entityManager.remove(office);
        } else {
            System.out.println("Can not set to null");
            return false;
        }

 */

        entityManager.remove(office);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;

    }

    public boolean setOfficeCodeToNull(EntityManager entityManager){
        String query = "UPDATE employees e SET e.officeCode = null WHERE e.officeCode = :officeCode";
        TypedQuery<String> typedQuery = entityManager.createQuery(query, String.class);
        if(typedQuery == null) return false;
        return true;

        /*try {
            entityManager.createNamedQuery("Employee.setOfficeCodeToNull", Employee.class);
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }*/
    }
}
