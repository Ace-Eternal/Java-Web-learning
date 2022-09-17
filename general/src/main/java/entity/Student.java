package entity;

import javax.persistence.*;

import entity.Hobby;

import java.util.List;

@Entity
public class Student {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自增
    private Long StudentId;
    private String StudentName;
    private Boolean StudentSex;
    private Integer StudentAge;
    private String StudentPwd;
    @OneToMany(mappedBy ="Stu",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //级联
    //mappedBy=>hobbylist 由什么东西识别
    //LAZY 先加载父实体，再把子实体加载
    private List<Hobby>hobbyList;
    //识别不出来手动指定entity

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
    StudentName = studentName;
}

    public Boolean getStudentSex() {
        return StudentSex;
    }

    public void setStudentSex(Boolean studentSex) {
        StudentSex = studentSex;
    }

    public Integer getStudentAge() {
        return StudentAge;
    }

    public void setStudentAge(Integer studentAge) {
        StudentAge = studentAge;
    }

    public String getStudentPwd() {
        return StudentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        StudentPwd = studentPwd;
    }
}
