package sqlLearning;

import java.sql.*;
import java.util.Scanner;

public class UserLoginIn {
    public static void main(String[] args) {
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","123456");
            Statement statement=connection.createStatement();
            Scanner scanner=new Scanner(System.in)){
//            String sql="select * from study.user where name='"+scanner.nextLine()+"'and pwd='"+scanner.nextLine()+"';";
//            System.out.println(sql);

//            ResultSet set=statement.executeQuery("select * from study.user where name='"+scanner.nextLine()+"'and pwd='"+scanner.nextLine()+"';");
//            while(set.next()){
//                String name=set.getString(1);
//                System.out.println("登录成功："+name);
//            }

            //prepareStatement预编译
//            PreparedStatement statement1=connection.prepareStatement("select * from study.user where name=? and pwd=?;");
//            statement1.setString(1,scanner.nextLine());
//            statement1.setString(2,scanner.nextLine());
//            System.out.println(statement1.toString());
//            ResultSet set=statement1.executeQuery();
//            while(set.next()){
//                String name=set.getString(1);student
//                System.out.println("登录成功："+name);
//            }

            //管理事务

            connection.setAutoCommit(false);
            statement.executeUpdate("insert into learn.student values('giegie') ;");
            Savepoint savepoint=connection.setSavepoint();
            statement.executeUpdate("insert into learn.student values('ikunkun') ;");
//            connection.rollback(savepoint);
            connection.commit();



        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}
