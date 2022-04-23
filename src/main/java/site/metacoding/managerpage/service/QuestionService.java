package site.metacoding.managerpage.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.comment.Comment;
import site.metacoding.managerpage.domain.comment.CommentRepository;
import site.metacoding.managerpage.domain.question.Question;
import site.metacoding.managerpage.domain.question.QuestionRepository;

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

    @Transactional
    public void 답변하기(Comment comment, Integer questionId) {

        Optional<Question> questionOp = postRepository.findById(questionId);

        if (questionOp.isPresent()) {
            Question questionEntity = questionOp.get();
            comment.setQuestion(questionEntity);
        } else {
            throw new RuntimeException("없는 게시글에 댓글을 작성할 수 없습니다");
        }

        commentRepository.save(comment);
    }

    public Comment 답변불러오기(Integer questionId) {
        Optional<Comment> commentOp = commentRepository.findById(questionId);
        if (commentOp.isPresent()) {
            return commentOp.get();
        } else {
            throw new RuntimeException("답변을 찾을 수 없습니다.");
        }
    }
}
