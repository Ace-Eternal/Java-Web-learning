import dao.impl.CourseDao;
import entity.Course;
import entity.Student;
import org.junit.Test;

public class CourseDaoTest {
    CourseDao courseDao=new CourseDao();
    @Test
    public void save(){
        Course s1=new Course();
        s1.setCourseName("java");
        s1.setCredit(1.5);
        courseDao.save(s1);
    }
}
