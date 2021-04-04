package repository.repository_impl;

import repository.entity_manager.EntityManagerProvider;
import data.model.entity.Office;
import repository.OfficeRepository;
import repository.entity_manager.EntityManagerProvider;
import utils.RepositoryBeanFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

        List<Employee> employees = RepositoryBeanFactory.getEmployeeRepository().findAllEmployeesByOffice(office);

        employees.forEach(e ->
            RepositoryBeanFactory.getEmployeeRepository().deleteEmployee(e.getEmployeeNumber())
        );

        entityManager.remove(office);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
