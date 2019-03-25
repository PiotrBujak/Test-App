package akademiakodu.quiz.model;

import akademiakodu.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    public Test(String name) {
        this.name = name;
    }

    public Test() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question question) {
        question.setTest(this);
        questionList.add(question);
    }

    public void removeQuestion(Question question) {
        question.setTest(this);
        questionList.remove(question);
    }
}