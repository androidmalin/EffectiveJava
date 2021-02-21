package com.example.command.common;

/**
 * 抽象命令接口
 * 2.命令角色(ICommand)：定义需要执行的所有命令行为。
 * <p>
 * <p>
 * 从命令模式的UML类图中，其实可以很清晰地看出：ICommand的出现就是
 * 作为Receiver和Invoker的中间件，解耦了彼此。
 * <p>
 * 而之所以引入ICommand中间件，是以下两方面原因。
 * (1)解耦请求与实现：即解耦了Invoker和Receiver，
 * <p>
 * 因为在UML类图中，Invoker是一个具体的实现，等待接收客户端传入的命令
 * （即Invoker与客户端耦合），Invoker处于业务逻辑区域，应当是一个稳定的结构。
 * <p>
 * 而Receiver属于业务功能模块，是经常变动的；
 * <p>
 * 如果没有ICommand，则Invoker紧耦合Receiver，
 * 一个稳定的结构依赖了一个不稳定的结构，就会导致整个结构都不稳定。
 * <p>
 * 这就是引入ICommand的原因：不仅仅是解耦请求与实现，同时稳定(Invoker)依赖稳定
 * (Command），结构还是稳定的。
 * <p>
 * （2）增强扩展性：扩展性又体现在以下两个方面。
 * Receiver属于底层细节，可以通过更换不同的Receiver达到不同的细节实
 * <p>
 * ICommand 接口本身就是抽象的，具备扩展性；
 * 而且由于命令对象本身具备抽象性，如果结合装饰器模式，
 * 则功能扩展简直如鱼得水。
 */
public interface ICommand {
    void execute();
}
