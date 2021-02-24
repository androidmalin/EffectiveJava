package com.example.objectpool.common;

import java.util.Vector;

/**
 * 对象池
 */
public class ObjectPool {
    private final int step = 10;   //当对象不够用的时候，每次扩容的数量
    private final int minCount;
    private final int maxCount;
    private final Vector<IPooledObject> not_lent;   //保存未借出的对象
    private final Vector<IPooledObject> has_been_lent; //保存已被借出的对象

    /**
     * 初始化对象池
     */
    public ObjectPool(int mini, int max) {
        has_been_lent = new Vector<>();
        not_lent = new Vector<>();
        minCount = mini;
        maxCount = max;
        refresh(minCount);
    }

    /**
     * 因为内部状态具备不变性，因此作为缓存的键
     */
    public IPooledObject borrowObject() {
        IPooledObject next;
        if (not_lent.size() > 0) {
            for (IPooledObject returned : not_lent) {
                next = returned;
                not_lent.remove(next);
                has_been_lent.add(next);
                return next;
            }
        } else {
            //计算出剩余可创建的对象数
            int count = (maxCount - minCount);
            //剩余可创建的数量大于单次固定创建的对象数
            //则再初始化一批固定数量的对象
            refresh(Math.min(count, step));
        }
        return null;
    }

    /**
     * 不需要使用的对象归还重复利用
     */
    public void returnObject(IPooledObject pooledObject) {
        not_lent.add(pooledObject);
        has_been_lent.remove(pooledObject);
    }

    private void refresh(int count) {
        for (int i = 0; i < count; i++) {
            not_lent.add(new ConcretePoolObject());
        }
    }
}