package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Payment;
import repository.PaymentRepository;

import javax.persistence.EntityManager;

public class PaymentRepositoryImpl implements PaymentRepository {
    @Override
    public Payment createPayment(Payment payment) {
        return null;
    }

    @Override
    public Payment readPayment(String checkNumber) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Payment payment = entityManager.find(Payment.class, checkNumber);
        entityManager.getTransaction().commit();
        entityManager.close();
        return payment;
    }
}
