package service;

import data.model.embeddable.PaymentId;
import data.model.entity.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment readPayment(PaymentId paymentId);
    Payment updatePayment(Payment payment);
    boolean deletePayment(PaymentId paymentId);
}
