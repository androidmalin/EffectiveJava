# Java design patterns
### uml idea
1. [idea 类图工具栏，上下文菜单和图例](https://www.jetbrains.com/help/idea/class-diagram.html?section=macOS)


## 设计模式中使用到的Java基础知识总结
### 1. 抽象类实现接口

#### 1.1 抽象类可以选择性实现接口.

#### 1.2 抽象类可以对接口中的方法全部空实现. (接口的适配器设计模式)

### 2. 继承
#### 2.1 子类继承父类的同时实现接口, 可以将对接口中方法的实现放到父类中来实现. (类的适配器设计模式)

参考 [Java中的接口：为什么子类实现了接口，却由父类覆写接口中的方法](https://www.zhihu.com/question/60167293)

#### 2.2 父类中不声明空的构造函数,而使用有参数的构造函数,子类继承自父类时,必须复写该构造函数.

#### 2.3 创建一个匿名内部类
[can-we-instantiate-an-abstract-class](https://stackoverflow.com/questions/13670991/can-we-instantiate-an-abstract-class)
[instantiating-interfaces-in-java](https://stackoverflow.com/questions/16750772/instantiating-interfaces-in-java/35708932)


