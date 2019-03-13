package akademiakodu.quiz.model;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String content;
    private boolean correct;
    @ManyToOne // Adnotacja (wiele Questionów do jednego testu)
    private Test test; // powiązanie z klasą Test

    public Question(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    public Question() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
