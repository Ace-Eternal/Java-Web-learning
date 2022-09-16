import org.junit.*;
import dao.StudentDao;
import entity.Student;

import java.util.List;

public class StudentDaoTest {

    StudentDao studentDao=new StudentDao();
    @Test
    public void createStu(){
        Student s1=new Student();
        s1.setStudentName("assian");
        s1.setStudentAge(11);
        s1.setStudentSex(true);
        s1.setStudentPwd("aaa");
        studentDao.save(s1);
    }
    @Test
   public void delete(){
        studentDao.deleteById(10L);
    }
    @Test
    public void getStudentById(){
        Student student=studentDao.getStudentById(12L);
        System.out.println(student);
    }
    @Test
    public void getAllStudent(){
        List<Student>list=studentDao.getAll();
//        list.forEach(System.out::println);
        System.out.println(list);
        //META-INF下的文件名是persistence.xml，不要拼写错误了

    }
}
