package akademiakodu.quiz.repository;

import akademiakodu.quiz.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query("SELECT t FROM Test t ORDER BY t.id")
    List<Test> findAllSortById();
}
