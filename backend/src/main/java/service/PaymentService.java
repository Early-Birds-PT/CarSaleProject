package service;

import data.model.embeddable.PaymentId;
import data.model.entity.Customer;
import data.model.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment createPayment(Payment payment);
    Payment readPayment(PaymentId paymentId);
    Payment updatePayment(Payment payment);
    boolean deletePayment(PaymentId paymentId);
    List<Payment> findAllPaymentsByCustomer(Customer customer);
}
