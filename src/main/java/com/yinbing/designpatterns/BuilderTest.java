package com.yinbing.designpatterns;

/**
 * 将一个复杂对象的创建与他的表示分离，使得同样的构建过程可以创建
 * 不同的表示
 *
 * Spring 源码中的应用
 *
 * org.springframework.web.servlet.mvc.method.RequestMappingInfo
 * org.springframework.beans.factory.support.BeanDefinitionBuilder
 */
public class BuilderTest {

    public static void main(String[] args) {
        UserBuilder userBuilder = new DefaultConcreateUserBuilder();
        Director director = new Director(userBuilder);

        User user = director.makeUer("test", 11, "p1", "p2", "p3", "p4");

        System.out.println(user);
    }
}

class Director{

    public Director(UserBuilder builder) {
        this.builder = builder;
    }

    private UserBuilder builder;

    public User makeUer(String name, int age, String part1, String part2,String part3,String part4){
        builder.buildUserName(name);

        builder.buildUserAge(age);
        builder.buildUserPart1(part1);
        builder.buildUserPart2(part2);
        builder.buildUserPart3(part3);
        builder.buildUserPart4(part4);
        return builder.build();
    }
}

interface UserBuilder{
    void buildUserName(String name);
    void buildUserAge(int age);
    void buildUserPart1(String part1);
    void buildUserPart2(String part2);
    void buildUserPart3(String part3);
    void buildUserPart4(String part4);
    User build();
}

class DefaultConcreateUserBuilder implements UserBuilder{

    private String name;
    private int age;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void buildUserName(String name) {
        this.name = name;
    }

    @Override
    public void buildUserAge(int age) {
        this.age = age;
    }

    @Override
    public void buildUserPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void buildUserPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void buildUserPart3(String part3) {
        this.part3= part3;
    }

    @Override
    public void buildUserPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public User build() {
        return new User(name, age, part1, part2, part3, part4);
    }
}

class User{
    private String name;
    private int age;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public User(String name, int age, String part1, String part2, String part3, String part4) {
        this.name = name;
        this.age = age;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}
