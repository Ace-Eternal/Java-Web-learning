package dao;

public interface IStudentDao {
    //特有的方法
    //为什么要有接口，依赖注入 (重要) springboot
    //针对抽象编程 而不用具体
    //运行时更新,可扩展性
    //复杂查询
    boolean login(String name,String pwd);
}
