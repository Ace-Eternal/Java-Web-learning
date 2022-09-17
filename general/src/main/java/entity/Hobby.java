package entity;

import javax.persistence.*;

import entity.Student;

@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    @ManyToOne(cascade = CascadeType.ALL)
    //全部级联,数据库一起
    @JoinColumn(name = "stu_id")
    private Student Stu;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Student getStu() {
        return Stu;
    }

    public void setStu(Student stu) {
        Stu = stu;
    }
}
