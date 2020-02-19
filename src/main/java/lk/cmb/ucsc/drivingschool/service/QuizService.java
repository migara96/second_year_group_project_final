package lk.cmb.ucsc.drivingschool.service;

import lk.cmb.ucsc.drivingschool.model.Quiz;
import lk.cmb.ucsc.drivingschool.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    public void addQuiz(Quiz quiz) {
        quizRepo.save(quiz);
    }
    public List<Quiz> findAll(){
        return quizRepo.findAll();
    }
}
