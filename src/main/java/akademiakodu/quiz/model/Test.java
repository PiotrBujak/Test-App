package akademiakodu.quiz.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    // (mappedBy = "test") - nazwa klucza obcego po drugiej stronie, czyli w Klasie Question w tym przypadku
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL) //Adnotacja z bazy danych (jeden test do wielu pytań)
    private List<Question> questionList = new ArrayList<>(); //Lista Questionów

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
}