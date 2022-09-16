package util;
import javax.persistence.*;


public class JPAUtil {
    public static EntityManagerFactory factory;//设计模式中的工厂模式
    static {
        factory=Persistence.createEntityManagerFactory("default");//持久化单元的名字
    }
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
