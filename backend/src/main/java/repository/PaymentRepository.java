package repository;

import data.model.embeddable.PaymentId;
import data.model.entity.Customer;
import data.model.entity.Payment;
import java.util.List;

public interface PaymentRepository {

    Payment createPayment(Payment payment);
    Payment readPayment(PaymentId paymentId);
    Payment updatePayment(Payment payment);
    List<Payment> findAllPaymentsByCustomer(Customer customer);
    boolean deletePayment(PaymentId paymentId);
}
