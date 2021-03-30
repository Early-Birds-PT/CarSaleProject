package repository;

import data.model.entity.Payment;

public interface PaymentRepository {
    Payment createPayment(Payment payment);
    Payment readPayment(String checkNumber);
}
