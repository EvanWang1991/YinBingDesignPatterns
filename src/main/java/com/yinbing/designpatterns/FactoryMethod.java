package com.yinbing.designpatterns;

/**
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类，Factory Method 使一个类的实例化延时到子类。
 *
 * 开闭原则（对扩展开  对修改闭）
 *
 * 单一职责
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new ConCreateProductB();
        Product product = application.getProduct();
        product.method();
    }

}


interface Product{
    public void method();
}

//简单工程并不是设计模式
class SimpleFactory{
    public static Product createProduct(String type){
        switch (type){
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return null;
        }
    }
}

abstract class Application {
    abstract Product createProduct();

    Product getProduct(){
        Product product = createProduct();
        return product;
    }
}

class ProductA implements Product {

    @Override
    public void method() {
        System.out.println("A 产品");
    }
}


class ProductB implements Product {

    @Override
    public void method() {
        System.out.println("B 产品");
    }
}

class ConCreateProductA extends Application {

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConCreateProductB extends Application {

    @Override
    Product createProduct() {
        return new ProductB();
    }
}