package akademiakodu.quiz.repository;

import akademiakodu.quiz.model.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test, Integer> {

    //@Query("SELECT q FROM quiz q ORDER BY q.correct ")
    //List<Test> findCorrect();
}
