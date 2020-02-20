package lk.cmb.ucsc.drivingschool.service;

import lk.cmb.ucsc.drivingschool.model.Payment;
import lk.cmb.ucsc.drivingschool.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService{

    @Autowired
    private PaymentRepo paymentRepo;

    public void addPayment(Payment payment){
        paymentRepo.save(payment);
    }

    public List<Payment> findAll(){
        return paymentRepo.findAll();
    }
}
