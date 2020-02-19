package lk.cmb.ucsc.drivingschool.controller.Admin;


import lk.cmb.ucsc.drivingschool.model.Email;
import lk.cmb.ucsc.drivingschool.model.User;
import lk.cmb.ucsc.drivingschool.repo.UserRepo;
import lk.cmb.ucsc.drivingschool.service.MailSenderService;
import lk.cmb.ucsc.drivingschool.service.UserService;
import lk.cmb.ucsc.drivingschool.utility.GenarateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin/")
public class  AdminController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSenderService senderService;

    @Autowired
    private UserService userService;
    @Autowired
    private GenarateId genarateId;

    @GetMapping
    public String admin(){
        return "admin/admin";
    }

    @GetMapping("signup/student")
    public String signupStudent(Model model){
        model.addAttribute("user",new User());
        return "admin/signupStudent";
    }

    @GetMapping("signup/teacher")
    public String signupTeacher(Model model) {
        model.addAttribute("user",new User());
        return "admin/signupTeacher";
    }

   @PostMapping("signup/student")
    public String signinStudent (@ModelAttribute User user, Model model){
        String id=genarateId.genarateID();
        user.setId(id);
        user.setPassword("ucsc@123");
        user.setUsername("user"+id);
        user.setRoles("USER");
        userService.createUser(user);
        return "admin/admin";
    }

    @PostMapping("signup/teacher")
    public String signinTeacher (@ModelAttribute User user, Model model){
        String id=genarateId.genarateID();
        user.setId(id);
        user.setPassword("ucsc@123");
        user.setUsername("teacher"+id);
        user.setRoles("TEACHER");
        userService.createUser(user);
        return "admin/admin";
    }

    @GetMapping("student/crud")
    public String studentCrud(Model model)
    {
        List<User> student=new ArrayList<>();
        student=userRepo.findAll();
        model.addAttribute("student",student);
        return "admin/studentsList";
    }

    @GetMapping("teacher/crud")
    public String teachercrud(Model model){
        List<User> teacher=new ArrayList<>();
        teacher=userRepo.findAll();
        model.addAttribute("teacher",teacher);
        return "admin/teacherCrud";
    }

    @GetMapping("showStudents")
    public String showStudents(){
        return "admin/showStudents";
    }

    @GetMapping("email")
    public String emailSend() throws Exception {
        Email email=new Email("newkavindu@gmail.com","nothing","testing dor email");
        senderService.sendSimpleMail(email);
        return "admin/admin";
    }



}
