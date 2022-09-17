import dao.impl.StudentDao;
import entity.Student;
import org.junit.Test;

public class StudentDaoTest {
    StudentDao studentDao=new StudentDao();
    @Test
    public void save(){
        Student s1=new Student();
        s1.setStudentName("assiana");
        s1.setStudentAge(111);
        s1.setStudentSex(true);
        s1.setStudentPwd("aaab");
        studentDao.save(s1);
    }
    @Test
    public void delete(){
        studentDao.delete(16L);
    }
    @Test
    public void getOne(){
        studentDao.getOne(13L);
    }
    @Test
    public void getAll(){
        studentDao.getAll();
    }
    @Test
    public void login(){
        System.out.println(studentDao.login("assian", "aaa"));
    }
}
