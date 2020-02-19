package lk.cmb.ucsc.drivingschool.controller.Admin.Quiz;

import lk.cmb.ucsc.drivingschool.model.Attendence;
import lk.cmb.ucsc.drivingschool.model.Quiz;
import lk.cmb.ucsc.drivingschool.service.AttendenceService;
import lk.cmb.ucsc.drivingschool.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/admin/quiz/")
public class QuizController {

    @Autowired
    private QuizService quizService;



    @GetMapping("add")
    public String showQuiz(Model model){
        List<Quiz> quizList=new ArrayList<>();
        quizList=quizService.findAll();
        model.addAttribute("quizList",quizList);
        model.addAttribute("quiz", new Quiz());
        return "admin/Quiz/quiz";
    }

    @PostMapping("add")
    public String addQuiz(@ModelAttribute Quiz quiz){
        quizService.addQuiz(quiz);
        return "admin/Quiz/quiz";
    }
}
