package repository.repository_impl;

import data.EntityManagerProvider;
import data.model.embeddable.PaymentId;
import data.model.entity.Customer;
import data.model.entity.Employee;
import data.model.entity.Order;
import data.model.entity.Payment;
import repository.PaymentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository {

    @Override
    public Payment createPayment(Payment payment) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        payment = entityManager.merge(payment);

        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Payment is created");

        return payment;
    }

    @Override
    public Payment readPayment(PaymentId paymentId) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Payment payment = entityManager.find(Payment.class,paymentId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return payment;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        payment = entityManager.merge(payment);

        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Payment is updated");

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

    @Override
    public boolean deletePayment(PaymentId paymentId) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        boolean isDeleted;

        entityManager.getTransaction().begin();
        Payment payment = entityManager.find(Payment.class, paymentId);


        if(payment == null){
            entityManager.getTransaction().rollback();
            entityManager.close();

            isDeleted = false;
            return isDeleted;
        }

        entityManager.remove(payment);
        entityManager.getTransaction().commit();
        entityManager.close();

        isDeleted = true;
        return isDeleted;
    }
}
