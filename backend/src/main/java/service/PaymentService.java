package service;

import data.model.entity.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment readPayment(String checkNumber);
}
