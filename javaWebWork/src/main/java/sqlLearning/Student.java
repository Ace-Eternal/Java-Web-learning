package sqlLearning;

import java.io.InputStream;

public class Student {
    Integer sid;
    String name;
    String sex;

    public Student(Integer sid, String name, String sex) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
    }

    public Student() {
    }
    public void say(){
        System.out.println("我的sid是:"+this.sid+"我的姓名是:"+name+"我的性别是:"+sex);
    }
}
