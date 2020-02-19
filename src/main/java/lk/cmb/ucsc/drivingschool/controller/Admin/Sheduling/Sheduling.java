package lk.cmb.ucsc.drivingschool.controller.Admin.Sheduling;

import lk.cmb.ucsc.drivingschool.model.Email;
import lk.cmb.ucsc.drivingschool.model.Shedules;
import lk.cmb.ucsc.drivingschool.model.User;
import lk.cmb.ucsc.drivingschool.repo.SheduleRepo;
import lk.cmb.ucsc.drivingschool.repo.UserRepo;
import lk.cmb.ucsc.drivingschool.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/admin/sheduling/")
public class Sheduling {

    @Autowired
    private MailSenderService senderService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SheduleRepo sheduleRepo;

    @GetMapping("daily")
    public String getDaily(Model model){
        model.addAttribute("shedule",new Shedules());
        List<User> user=new ArrayList<>();
        List<User> users=userRepo.findAll();
        List<Shedules> shedulesList=sheduleRepo.findAll();
        model.addAttribute("user",user);
        model.addAttribute("users", users);
        model.addAttribute("sheduleList",shedulesList);
        return "admin/sheduling/daily";
    }
    @PostMapping("daily")
    public String saveShedule(@ModelAttribute Shedules shedules,Model model){
        List<User> user=new ArrayList<>();
        List<User> users=userRepo.findAll();
        List<Shedules> shedulesList=sheduleRepo.findAll();
        model.addAttribute("user",user);
        model.addAttribute("users", users);
        model.addAttribute("sheduleList",shedulesList);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        shedules.setDate(dateFormat.format(date));
        sheduleRepo.save(shedules);
        String message=shedules.getDate()+","+shedules.getTime()+","+shedules.getTeacher()+" is your shedule. Contact us for more additional details";
        Email email=new Email("examnipun@gmail.com","Sheduling of Driving Scool", message);
        senderService.sendSimpleMail(email);
        return "admin/sheduling/daily";
    }


}
