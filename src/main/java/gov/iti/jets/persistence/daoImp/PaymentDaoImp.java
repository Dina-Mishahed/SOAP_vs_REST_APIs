package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.PaymentDao;
import gov.iti.jets.persistence.entity.Payment;
import gov.iti.jets.service.dto.PaymentDto;
import gov.iti.jets.service.mapper.PaymentMapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public class PaymentDaoImp extends BaseDAO implements PaymentDao {
    PaymentMapper paymentMapper;
    public PaymentDaoImp(){
        paymentMapper = Mappers.getMapper(PaymentMapper.class);
    }
    @Override
    public PaymentDto getPaymentById(Short id) {
        Payment payment = (Payment) get(Payment.class,"paymentId",id);
        return paymentMapper.toDto(payment);    }

    @Override
    public List<PaymentDto> getAllPayment() {
        List<Payment> paymentList = getAll(Payment.class);
        return paymentList.stream().map((payment -> paymentMapper.toDto(payment))).toList();
    }
}
