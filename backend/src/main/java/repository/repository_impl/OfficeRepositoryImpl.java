package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Employee;
import data.model.entity.Office;
import repository.OfficeRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
    public void updateOffice(Office office) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(office);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Office is updated");

    }

    @Override
    public void deleteOffice(String officeCode) {

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Office office1 = entityManager.find(Office.class,officeCode);
        entityManager.getTransaction().begin();
        entityManager.remove(office1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Office is deleted");

    }
}
