package service.impl;

import data.model.entity.Payment;
import repository.PaymentRepository;
import service.PaymentService;
import utils.RepositoryBeanFactory;

public class PaymentServiceImpl implements PaymentService {

    PaymentRepository paymentRepository = RepositoryBeanFactory.getPaymentRepository();

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.createPayment(payment);
    }

    @Override
    public Payment readPayment(String checkNumber) {
        return paymentRepository.readPayment(checkNumber);
    }
}
