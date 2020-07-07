package com.yinbing.designpatterns;

/**
 *
 * 抽象工厂模式
 *
 * 模式定义:
 * 提供一个创建一系列相关或互相依赖对象的接口，而无需指定它们具体的类
 *
 * 应用场景:
 * 程序需要处理不同系列的相关产品，但是您不希望它依赖于这些产品的
 * 具体类时，
 * 可以使用抽象工厂
 * 优点:
 * 1.可以确信你从工厂得到的产品彼此是兼容的。
 * 2.可以避免具体产品和客户端代码之间的紧密耦合。
 * 3.符合单一职责原则
 * 4.符合开闭原则
 *
 * @Auther: Jixiang.Wang
 * 峥嵘岁月 何惧风流
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDataBaseUtil mysqlDataBaseUtil = new MysqlDataBaseUtil();
        mysqlDataBaseUtil.getConnection().connect();
        mysqlDataBaseUtil.getCommand().command();


        IDataBaseUtil oracleDataBaseUtil = new OracleDataBaseUtil();
        oracleDataBaseUtil.getConnection().connect();
        oracleDataBaseUtil.getCommand().command();
    }
}

interface IDataBaseUtil{
    IConnection getConnection();
    ICommand getCommand();
}

interface IConnection{
    void connect();
}

interface ICommand{
    void command();
}

class MysqlDataBaseUtil implements IDataBaseUtil{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connect");
    }
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class OracleDataBaseUtil implements IDataBaseUtil{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}

class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("oracle connect");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("oracle command");
    }
}