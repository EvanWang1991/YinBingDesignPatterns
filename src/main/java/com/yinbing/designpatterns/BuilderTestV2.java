package com.yinbing.designpatterns;

/**
 * @Auther: Jixiang.Wang
 * 峥嵘岁月 何惧风流
 */
public class BuilderTestV2 {

    public static void main(String[] args) {
        UserV2.Builder builder = new UserV2.Builder();

        UserV2 userV2 = builder.withName("test").withAge(11).withPart1("p1").withPart2("p2").withPart3("p3").withPart4("p4").build();

        System.out.println(userV2);
    }
}

class UserV2{

    static class Builder{
        private String name;
        private int age;
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withPart1(String part1){
            this.part1 = part1;
            return this;
        }
        public Builder withPart2(String part2){
            this.part2 = part2;
            return this;
        }
        public Builder withPart3(String part3){
            this.part3 = part3;
            return this;
        }
        public Builder withPart4(String part4){
            this.part4 = part4;
            return this;
        }

        public Builder withAge(int age){
            this.age = age;
            return this;
        }

        public UserV2 build(){
            return new UserV2(name, age, part1, part2, part3, part4);
        }
    }
    private String name;
    private int age;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public UserV2(String name, int age, String part1, String part2, String part3, String part4) {
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
