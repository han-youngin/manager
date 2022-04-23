package site.metacoding.managerpage.web;

import javax.servlet.http.HttpSession;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.comment.Comment;
import site.metacoding.managerpage.domain.manager.Manager;
import site.metacoding.managerpage.service.QuestionService;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final QuestionService questionService;
    private final HttpSession session;

    // 매니저 답글달기.
    @PostMapping("/s/question/{id}/list/comment")
    public String questionComment(Comment comment, @PathVariable Integer id) {
        System.out.println(comment);
        Manager manager = (Manager) session.getAttribute("principal");
        comment.setManager(manager);
        questionService.답변하기(comment, id);
        return "redirect:/s/question/{id}";
    }
}
