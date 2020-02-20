package lk.cmb.ucsc.drivingschool.controller.Admin.Payments;

import lk.cmb.ucsc.drivingschool.model.Payment;
import lk.cmb.ucsc.drivingschool.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin/payments/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("add")
    public String showPayments(Model model) {
        List<Payment> paymentList = new ArrayList<>();
        paymentList = paymentService.findAll();
        model.addAttribute("paymentList",paymentList);
        model.addAttribute("payment", new Payment());
        return "admin/payment/payment2";
    }

    @PostMapping("/add")
    public String addPayment(@ModelAttribute Payment payment){
        paymentService.addPayment(payment);
        return "admin/payment/payment2";
    }


}
