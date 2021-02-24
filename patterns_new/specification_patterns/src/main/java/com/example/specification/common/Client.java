package com.example.specification.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 规格模式
 * 规格模式的定义
 * 规格模式（SpecificationPattern）可以认为是组合模式的一种扩展。
 * 很多时候程序中的某些条件决定了业务逻辑，这些条件就可以抽离出来以某种关系
 * （与、或、非）进行组合，从而灵活地对业务逻辑进行定制。
 * <p>
 * 另外，在查询、过滤等应用场合中，通过预定义多个条件，
 * 然后使用这些条件的组合来处理查询或过滤，
 * 而不是使用逻辑判断语句来处理，可以简化整个实现逻辑。
 * 这里的每个条件都是一个规格，
 * <p>
 * 多个规格（条件）通过串联的方式以某种逻辑关系形成一个组合式的规格。
 * <p>
 * 规格模式属于结构型设计模式。
 * <p>
 * 规格模式的应用场景
 * 规格模式主要适用于以下应用场景。
 * （1）验证对象，检验对象本身是否满足某些业务要求或者是否已经为实现某个业务目标做好了准备。
 * （2）从集合中选择符合特定业务规则的对象或对象子集。
 * （3）指定在创建新对象的时候必须要满足某种业务要求。
 */
public class Client {
    public static void main(String[] args) {
        //待分析的对象
        List<ISpecification> list = new ArrayList<>();
        //定义两个业务规格书
        ISpecification spec1 = new BizSpecification("11");
        ISpecification spec2 = new BizSpecification("22");

        list.add(spec1);
        list.add(spec2);
        //规格调用
        for (ISpecification specification : list) {
            if (spec1.and(spec2).isSatisfiedBy(specification)) {  //如果o满足spec1 && spec2
                System.out.println(specification);
            }
        }
    }
}
