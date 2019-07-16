package com.sample.interview.controller;

import com.sample.interview.entities.Question;
import com.sample.interview.repositories.QuestionRepository;
import com.sample.interview.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * This class manage the users inputs and return the corresponding answers
 * define the rest api entries
 */
@Controller
@RequestMapping("/questions/")
public class InterviewerController {

    private final QuestionRepository questionRepository;

    @Autowired
    public InterviewerController(QuestionRepository questionRepository) {

        this.questionRepository = questionRepository;
    }

    /**
     * serves the sign-up page
     * @param question
     * @return
     */
    @GetMapping("signup")
    public String showSignUpForm(Question question) {
        return "add-question";
    }

    /**
     * questions list
     * @param model
     * @return
     */
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "index";
    }

    /**
     * implements the search function
     * @param candidateExperience
     * @param codingLanguage
     * @param interviewDuration
     * @param model
     * @return
     */
    @GetMapping("search")
    public String filterByCriteria(
            @RequestParam(name = "candidateExperience", required = false, defaultValue = "")  String candidateExperience,
            @RequestParam(name = "codingLanguage", required = false, defaultValue = "")  String codingLanguage,
            @RequestParam(name = "interviewDuration", required = false, defaultValue = "30")  int interviewDuration,
            Model model) {

        List<Question> resultsList = new ArrayList<>();

        if(StringUtils.isEmpty(candidateExperience) && StringUtils.isEmpty(codingLanguage)){
            return "redirect:list";
        }

        if(interviewDuration == 0){
            interviewDuration = Constants.DEFAULT_INTERVIEW_DURATION;
        }

        if(StringUtils.isEmpty(candidateExperience)){
            resultsList.addAll(questionRepository.findAllByCodingLanguage(codingLanguage));
        }else if(StringUtils.isEmpty(codingLanguage)){
            resultsList.addAll(questionRepository.findAllByCandidateExperience(candidateExperience));
        }else{
            resultsList.addAll(
                    questionRepository.findByCandidateExperienceAndCodingLanguageAndInterviewDurationLessThanEqual(
                    candidateExperience, codingLanguage, interviewDuration));
        }
        model.addAttribute("questions", resultsList);
        return "index";
    }

    /**
     * Saves the new questions entered by the user
     * @param question
     * @param result
     * @param model
     * @return
     */
    @PostMapping("add")
    public String addQuestion(@Valid Question question, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-question";
        }

        questionRepository.save(question);
        return "redirect:list";
    }
}
