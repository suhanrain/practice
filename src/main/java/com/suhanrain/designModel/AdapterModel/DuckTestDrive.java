package com.suhanrain.designModel.AdapterModel;

/*
* 适配器模式：将一个类的接口，转换成客户期望的另一个接口。
*   疑问：那和代理模式有什么区别呢？
* */

public class DuckTestDrive {

    public static void main(String[] args) {
        MallardDuck mallardDuck=new MallardDuck();
        WildTurkey turkey=new WildTurkey();
        Duck turkeyAdpater=new TurkeyAdapter(turkey);

        System.out.println("The Turkey says");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe duck says");
        testDuck(mallardDuck);

        System.out.print("\nThe TurkeyAdpater says");
        testDuck(turkeyAdpater);
    }

        static void testDuck(Duck duck)
        {
            duck.quack();
            duck.fly();
        }
/*1.通过testDuck接口调用适配器的方法对适配器发出请求
* 2.适配器使用被适配者接口把请求转换成被适配的一个或多个接口调用
* 3.客户收到结果，但并不察觉是适配器进行转换作用
*
* */


}

interface Duck
{
    void quack();
    void fly();

}

class MallardDuck implements Duck{

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying");
    }
}

 interface  Turkey{
    void gobble();
    void fly();
}

class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("Fly a short distance");
    }
}

 class TurkeyAdapter implements Duck
{
    //适配器实现目标接口，并持有被适配者的实例
    //火鸡适配器实现目标接口，并引用一个被适配者

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey)
    {
        this.turkey=turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}