package dao.impl;

import dao.IBaseDao;
import entity.Student;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> implements IBaseDao <T>{
//注意这2个T
    private Class<T>clz;

    public BaseDao() {
        //basedao    T取出来
        //反射
        ParameterizedType paramClass=(ParameterizedType)this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments=paramClass.getActualTypeArguments();//只想要<>里的内容
        clz=(Class<T>)actualTypeArguments[0];//获取T了

//
//        Class class1=getClass();//获取当前对象类型,StudentDao
//        System.out.println(class1);
//        Class superclass=class1.getSuperclass();
//        System.out.println(superclass);//父类BaseDao
//
//        Type type=class1.getGenericSuperclass();
//        System.out.println(type);//输出了<>
//
//        ParameterizedType p=(ParameterizedType)type;//就是<>里的参数
//        Type typelist[]=p.getActualTypeArguments();//<>里的取出来成数组,取出第几个？
//        clz=(Class<T>) typelist[0];
//        System.out.println(clz);
    }

    @Override
    public void save(T object) {
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//开启事务，要么同时生效或不生效，hibernate的标准
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(T object) {
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//修改数据的话必须开启事务，要么同时生效或不生效，hibernate的标准
        entityManager.merge(object);//合并
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Serializable i) {
        EntityManager entityManager=JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();//开启事务，要么同时生效或不生效，hibernate的标准
        T s=entityManager.find(clz,i);//找到这条
        entityManager.remove(s);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T getOne(Serializable i) {
        EntityManager entityManager= JPAUtil.getEntityManager();
        //T是形参，不是实参
        T s=entityManager.find(clz,i);
        entityManager.close();
        return s;
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager=JPAUtil.getEntityManager();
        String hql="select p from"+clz.getName()+" as p";
        Query query=entityManager.createQuery(hql);
        return query.getResultList();
    }
}
