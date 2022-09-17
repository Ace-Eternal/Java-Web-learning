import dao.impl.StudentDao;
import entity.Hobby;
import entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JointTest {
    StudentDao studentDao=new StudentDao();
    @Test
    public void test(){
        Student s1=new Student();
        s1.setStudentName("aaaa");
        s1.setStudentAge(22);
        s1.setStudentSex(true);
        s1.setStudentPwd("123");


        List<Hobby>hobbyList=new ArrayList<>();
        Hobby hobby1=new Hobby();
        Hobby hobby2=new Hobby();
        hobby1.setName("唱");
        hobby2.setName("跳");
        hobbyList.add(hobby1);
        hobbyList.add(hobby2);
        hobby1.setStu(s1);
        hobby2.setStu(s1);

        s1.setHobbyList(hobbyList);

        studentDao.save(s1);
    }
}
