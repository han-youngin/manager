package site.metacoding.managerpage.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.question.Question;
import site.metacoding.managerpage.service.QuestionService;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    // 질문게시판 목록
    @GetMapping("/s/question/list")
    public String questionList(Model model) {
        List<Question> questions = questionService.질문목록가져오기();
        model.addAttribute("questions", questions);
        return "question/list";
    }

    // 질문게시판 상세보기
    @GetMapping("/s/question/{id}")
    public String questionDetailForm(@PathVariable Integer id, Model model) {
        Question question = questionService.질문가져오기(id);
        model.addAttribute("question", question);
        return "question/detail";
    }

    // 질문게시판 이미지보기
    @GetMapping("/s/question/checkImg/{id}")
    public String questioncheckImg(@PathVariable Integer id, Model model) {
        Question question = questionService.질문가져오기(id);
        model.addAttribute("question", question);
        return "question/img";
    }

}
