package akademiakodu.quiz.repository;

import akademiakodu.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE test_id = ?1")
    List<Question> findQuestionsByTestId(int test_id);

    @Query("SELECT q FROM Question q WHERE q.id = ?1")
    Question findQuestion(int id);

}
