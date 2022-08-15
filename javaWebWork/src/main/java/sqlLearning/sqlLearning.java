package sqlLearning;

import java.sql.*;

public class sqlLearning {
    public static void main(String[] args) {
        try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","123456");
        Statement statement=connection.createStatement();)
        {
//            statement.addBatch("insert into study.student values(130,'wuwangaba','woman');");
//            statement.addBatch("insert into study.student values(131,'liuwangaba','woman');");
//            statement.addBatch("insert into study.student values(132,'qiwangaba','man');");
//            statement.executeBatch();
//            //批量处理sql语句，先用addBatch（）存储，再提交，减少io流交互，提高效率
              ResultSet set=statement.executeQuery("select * from study.student;");
              while(set.next()){
                  Student student=new Student(set.getInt(1),set.getString(2), set.getString(3));
                  student.say();
              }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
