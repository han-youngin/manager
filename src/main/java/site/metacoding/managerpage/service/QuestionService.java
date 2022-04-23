package site.metacoding.managerpage.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.comment.Comment;
import site.metacoding.managerpage.domain.comment.CommentRepository;
import site.metacoding.managerpage.domain.question.Question;
import site.metacoding.managerpage.domain.question.QuestionRepository;
import site.metacoding.managerpage.domain.user.User;
import site.metacoding.managerpage.util.FileUpload;
import site.metacoding.managerpage.web.api.dto.QuestionWriteReqDto;

@RequiredArgsConstructor
@Service
public class QuestionService {

    @Value("${file.path}")
    private String uploadFolder;

    private final QuestionRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Question> 질문목록가져오기() {
        List<Question> questions = null;

        questions = postRepository.findAll();
        return questions;
    }

    public Question 질문가져오기(Integer id) {
        Optional<Question> questionOp = postRepository.findById(id);
        if (questionOp.isPresent()) {
            Question questionEntity = questionOp.get();
            return questionEntity;
        } else {
            throw new RuntimeException("질문을 찾을수가 없습니다.");
        }
    }

    // public void 답글달기(Comment comment, Integer id) {
    // Optional<Question> questionOp = postRepository.findById(id);
    // if (questionOp.isPresent()) {
    // Question questionEntity = questionOp.get();
    // comment.setQuestion(questionEntity);
    // commentRepository.save(comment);
    // } else {
    // throw new RuntimeException("질문을 찾을수가 없습니다.");
    // }
    // }

    @Transactional
    public void 답변하기(Comment comment) {

        commentRepository.save(comment);
    }

    public Comment 답변불러오기() {

    }
}
