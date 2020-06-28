package com.yinbing.designpatterns;

public class BuilderTest {

    public static void main(String[] args) {

    }
}

class Director{
    private UserBuilder builder;

    public User makeUer(){
        builder.buildUserAge(11);
        builder.buildUserName("test");
        builder.buildUserPart1("Part1");
        builder.buildUserPart2("Part2");
        builder.buildUserPart3("Part3");
        builder.buildUserPart4("Part4");
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
        return null;
    }
}

class User{
    private String name;
    private int age;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
}
