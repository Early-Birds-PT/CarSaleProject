package service.impl;

import data.model.entity.Payment;
import repository.PaymentRepository;
import repository.repository_impl.PaymentRepositoryImpl;
import service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    PaymentRepository paymentRepository = new PaymentRepositoryImpl();
    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.createPayment(payment);
    }

    @Override
    public Payment readPayment(String checkNumber) {
        return paymentRepository.readPayment(checkNumber);
    }
}
