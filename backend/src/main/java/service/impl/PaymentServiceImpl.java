package service.impl;

import data.model.embeddable.PaymentId;
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
    public Payment readPayment(PaymentId paymentId) {
        return paymentRepository.readPayment(paymentId);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.updatePayment(payment);
    }

    @Override
    public boolean deletePayment(PaymentId paymentId) {
        return paymentRepository.deletePayment(paymentId);
    }


}
