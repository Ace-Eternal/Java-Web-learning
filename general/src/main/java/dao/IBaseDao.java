package dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao <T>{
    //接口实现泛型编程
    //传参是类型传参
    void save(T object);
    void update(T object);
    //序列化类型
    //java对象转成字节数组，然后又还原,不用强制转换
    void delete(Serializable i);
    T getOne(Serializable i);
    List<T> getAll();
}
