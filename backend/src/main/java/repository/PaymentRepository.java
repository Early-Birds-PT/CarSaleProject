package repository;

import data.model.entity.Customer;
import data.model.entity.Order;
import data.model.entity.Payment;

import java.util.List;

public interface PaymentRepository {
    Payment createPayment(Payment payment);
    Payment readPayment(String checkNumber);
    List<Payment> findAllPaymentsByCustomer(Customer customer);
}
