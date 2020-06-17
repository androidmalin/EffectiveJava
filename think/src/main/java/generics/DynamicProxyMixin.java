package generics;

import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Tuple.tuple;


class MixinProxy implements InvocationHandler {
    private Map<String, Object> delegatesByMethod;

    @SafeVarargs
    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                // The first interface in the map implements the method.
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SafeVarargs
    public static Object newInstance(TwoTuple<Object, Class<?>>... pairs) {
        Class<?>[] interfaces = new Class<?>[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}

/**
 * 可以使用动态代理来创建一种比装饰器更贴近混型模型的机制（查看第14章中关于Java的动态代理如何工作的解释）。
 * 通过使用动态代理，所产生的类的动态类型将会是已经混入的组合类型。
 * 由于动态代理的限制，每个被混入的类都必须是某个接囗的实现：
 * <p>
 * <p>
 * 因为只有动态类型而不是非静态类型才包含所有的混入类型，因此这仍旧不
 * 如C++的方式好，因为可以在具有这些类型的对象上调用方法之前，你被强制要
 * 求必须先将这些对象向下转型到恰当的类型。但是，它明显地更接近于真正的混型。
 * <p>
 * 为了让Java支持混型，人们已经做了大量的工作朝着这个目标努力，
 * 包括创建了至少一种附加语言(Jam语言），它是专门用来支持混型的。
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {

        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class)
        );

        Basic basic = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        basic.set("Hello");

        System.out.println(basic.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
    }
}
