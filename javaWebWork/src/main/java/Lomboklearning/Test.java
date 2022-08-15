package Lomboklearning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;


public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("xiaowangbadan");
        System.out.println(student.getName());
        System.out.println(student);//打印本身就是调用对象的toString（）方法
    }

}
