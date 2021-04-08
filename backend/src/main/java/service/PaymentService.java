package service;

import model.embeddable.PaymentId;
import model.entity.Customer;
import model.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment createPayment(Payment payment);
    Payment readPayment(PaymentId paymentId);
    Payment updatePayment(Payment payment);
    boolean deletePayment(PaymentId paymentId);
    List<Payment> findAllPaymentsByCustomer(Customer customer);
}
