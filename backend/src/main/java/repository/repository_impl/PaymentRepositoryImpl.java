package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.entity.Customer;
import data.model.entity.Order;
import data.model.entity.Payment;
import repository.PaymentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<Payment> findAllPaymentsByCustomer(Customer customer) {
        String query = "SELECT p FROM Payment p WHERE p.customer = :customer";
        EntityManager em = EntityManagerProvider.getEntityManager();

        em.getTransaction().begin();
        TypedQuery<Payment> typedQuery = em.createQuery(query, Payment.class);
        typedQuery.setParameter("customer", customer);
        List<Payment> orderList = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        return orderList;
    }
}
