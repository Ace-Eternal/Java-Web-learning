package dao.impl;
import dao.IStudentDao;
import entity.Student;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentDao extends BaseDao<Student>implements IStudentDao {
    @Override
    public boolean login(String name, String pwd) {
        EntityManager manager= JPAUtil.getEntityManager();
        String hql="select p from Student p where p.StudentName=:name and p.StudentPwd=:pwd";
        Query query=manager.createQuery(hql);
        query.setParameter("name",name);
        query.setParameter("pwd",pwd);
        List list=query.getResultList();
        manager.close();
        return list.size()>=1;
    }
}
