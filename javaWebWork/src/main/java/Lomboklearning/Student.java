package Lomboklearning;

import lombok.*;

@Data//里面包含的是@requireConstructor,无参的，有final标记的或者@NonNull的才会生成有参的
public class Student {
    private  int sid;
    private String name;
    private String sex;

}
