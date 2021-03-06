package site.metacoding.managerpage.domain.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT * FROM question WHERE userId =:userId", nativeQuery = true)
    List<Question> findByUserId(@Param("userId") Integer userId);
}