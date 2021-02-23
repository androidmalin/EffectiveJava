package com.example.chain.demo.builderchain_origin;

import com.example.chain.demo.bean.Member;

/**
 * 责任链模式和建造者模式的结合使用.
 * <p>
 * 因为责任链模式具备链式结构，而在上面代码中，
 * 负责组装链式结构的角色是MemberService。
 * <p>
 * 当链式结构较长时，MemberService的工作会非常烦琐，
 * 并且MemberService的代码相对臃肿，且后续更改处理者或消息类型时，
 * 都必须在MemberService中进行修改，不符合开闭原则。
 * <p>
 * 产生这些问题的原因就是链式结构的组装过于复杂，
 * 而对于复杂结构的创建，我们很自然地就会想到建造者模式。
 * <p>
 * 使用建造者模式，完全可以对MemberService指定的处理节点对象进行自动链式组装，
 * 客户只需指定处理节点对象，其他任何事情都不用关心，并且客户指定的处理节点对象的顺序不同，
 * 构造出来的链式结构也随之不同。
 */
public abstract class Handler {
    protected Handler next;

    private void next(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);


    public static class Builder {
        private Handler head;
        private Handler tail;

        public Builder addHandler(Handler handler) {
            if (head == null) {
                head = tail = handler;
            } else {
                tail.next(handler);
                tail = handler;
            }
            return this;
        }

        public Handler build() {
            return head;
        }
    }
}
