import dao.impl.CourseDao;
import dao.impl.StudentDao;
import org.junit.Test;

public class ReflectTest {
    @Test
    public void test(){
        StudentDao studentDao=new StudentDao();
        CourseDao courseDao=new CourseDao();
    }
}
