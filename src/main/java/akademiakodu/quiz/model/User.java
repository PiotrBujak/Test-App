package akademiakodu.quiz.model;

public class User {
    private Integer numberOfPoints;

    public User(){
        numberOfPoints = 0;
    }

    public void addPoint(){
        numberOfPoints++;
    }

    public Integer getNumberOfPoints(){
        return numberOfPoints;
    }
}
