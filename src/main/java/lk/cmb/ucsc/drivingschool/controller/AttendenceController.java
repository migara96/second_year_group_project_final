package lk.cmb.ucsc.drivingschool.controller;

import lk.cmb.ucsc.drivingschool.model.Attendence;

import lk.cmb.ucsc.drivingschool.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/teacher/attendence/")
public class AttendenceController {

    @Autowired
    private AttendenceService attendenceService;



    @GetMapping("add")
    public String showAttendence(Model model){
        List<Attendence> attendenceList=new ArrayList<>();
        attendenceList=attendenceService.findAll();
        model.addAttribute("attendenceList",attendenceList);
        model.addAttribute("attendence", new Attendence());
        return "teacher/Attendence/attendence";
    }

    @PostMapping("add")
    public String addAttendence(@ModelAttribute Attendence attendence){
        attendenceService.addAttendence(attendence);
        return "teacher/index";
    }

}
