package lk.cmb.ucsc.drivingschool.model;


import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Shedules {

    private String date;
    private String time;
    private String student;
    private String teacher;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }





    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
