package com.yinbing.designpatterns;

/**
 * 原型模式
 * 首先我们看下原型模式的定义，维基百科上这样解释的：原型模式是创建型模式
 * 的一种，其特点在于通过“复制”一个已经存在的实例来返回新的实例，而不是
 * 新建实例。被复制的实例就是我们所称的“原型”，这个原型是可定制的。
 *
 * 关键词：原型实例，复制，新实例
 * 通俗点说就是我们在某个需要创建实例的地方不是通过 new 关键字来创建某个
 * 类，而是通过复制某个类已有的实例来创建一个新的实例。比如有个猴子 Monkey
 * 类，对应有个孙悟空实例我们叫猴哥一号，在打不过某个妖怪 Monster 的时候
 * 拔一根猴毛吹一下，克隆一个新的 Monkey，我们叫做猴哥二号，这时有两个猴
 * 哥一起对付妖怪。这里我们原始的猴哥一号就是原型对象，猴哥二号就是克隆对
 * 象。
 *
 * 原型模式使用场景
 * 上面提到了原型模式使用场景是在需要创建新的实例的时候不通过 new 而是通
 * 过”复制“ 的方式来创建。那么我们会想为什么不通过 new 来创建呢？new 起
 * 来多方便啊，搞什么复制那么麻烦。那是因为主要有下面两点的原因：
 * 无法根据类名来 new 对象。我们知道在 new 一个类的时候是需要知道类名的，
 * 如果不知道类名叫什么，我们自然无法通过 new 来创建实例；
 * 需要大量创建相同对象的时候。有时候我们可能在一个循环中创建对象，而且这
 * 个对象创建的复杂度很高，那这种时候如果我们每次都是用 new 来创建那么性
 * 能会比较低，当然现在 JVM 已经优化的很好了，但是对于有些对性能要求特别
 * 高的场景，还是要注意的。
 *
 * @Auther: Jixiang.Wang
 * 峥嵘岁月 何惧风流
 */
public class PrototypeTest {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        monkey.setName("原始猴哥");
        monkey.setAge(0);
        monkey.setSkill(new Skill());
        System.out.println(monkey.toString());
        for (int i = 0; i < 2; i++) {
            MonkeyPrototype cloneMonkey = monkey.clone();
            cloneMonkey.setAge(i + 1);
            cloneMonkey.setName("克隆猴哥" + (i + 1) + "号");

            Skill skill = new Skill();
            skill.setName("技能" + (i + 1));

            cloneMonkey.setSkill(skill);
            System.out.println(cloneMonkey.toString());
        }
        System.out.println(monkey.toString());
    }
}

class MonkeyPrototype implements Cloneable {
    private String name;
    int age;
    Skill skill;

    @Override
    public MonkeyPrototype clone() {
        MonkeyPrototype monkeyPrototype = null;
        try {
            monkeyPrototype = (MonkeyPrototype) super.clone();
            monkeyPrototype.skill = skill.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return monkeyPrototype;
    }

    @Override
    public String toString() {
        return "MonkeyPrototype{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", skills=" + skill +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}


class Monkey extends MonkeyPrototype {

}


class Skill implements Cloneable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Skill clone() {
        Skill s = null;
        try {
            s = (Skill) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}
