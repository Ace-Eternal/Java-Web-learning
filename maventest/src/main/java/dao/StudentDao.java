package dao;
import javax.persistence.*;
import entity.Student;
import util.JPAUtil;

import java.util.List;
import java.util.Queue;

public class StudentDao {
    //保存
    public void save(Student student){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//开启事务，要么同时生效或不生效，hibernate的标准
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    //更新
    public void update(Student student){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//修改数据的话必须开启事务，要么同时生效或不生效，hibernate的标准
        entityManager.merge(student);//合并
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    //按学号删除
    public void deleteById(Long id){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//开启事务，要么同时生效或不生效，hibernate的标准
        Student student=entityManager.find(Student.class, id);//找到这条
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void delete(Student student){
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//开启事务，要么同时生效或不生效，hibernate的标准
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Student getStudentById(Long id){
        EntityManager entityManager=JPAUtil.getEntityManager();
        //不需要原子性，不需要事务
        Student stduent=entityManager.find(Student.class,id);
        entityManager.close();
        return stduent;
    }
    public List<Student>getAll(){
        EntityManager entityManager=JPAUtil.getEntityManager();
        String hql="select p from entity.Student p";//hql写法 orm 做复杂操作的，因为hibernate是自动映射的
        //主键，外键，连接表等
        Query query=entityManager.createQuery(hql);
        List<Student>list=query.getResultList();
        entityManager.close();
        return list;
    }
}
