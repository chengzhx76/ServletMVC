package com.cheng.cache;



import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Desc:
 * Author: chengzhx76@qq.com
 * Date: 2017/8/10
 */
public class GuavaCacheTest {
    public static void main(String[] args) {
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().
                concurrencyLevel(4).//设置容器并发级别
                /**
                 *expireAfterAccess: 当缓存项最后操作（读/写）时间与当前时间超过2s则失效
                 *expireAfterWrite：当缓存项最后更新操作时间与当前时间超过2s则失效
                 *refreshAfterWrite：当缓存项上一次更新操作之后的多久会被刷新。
                 *expireAfterAccess和expireAfterWrite：在缓存加载的时候会进行加锁处理，保证只有一个线程去加载数据，其他线程进行等待判断时候加载完成，
                 *保证所有线程获取的数据是最新的，
                 *refreshAfterWrite：保证只有一个线程去刷新缓存数据，而其他查询先返回旧值，这样有效地可以减少等待和锁争用，所以refreshAfterWrite会比
                 *expireAfterWrite性能好。但是它也有一个缺点，因为到达指定时间后，它不能严格保证所有的查询都获取到新值。
                 *可以两种策略结合使用如下：超过2s进行刷新，超过10s进行失效保证获取数据最新的。
                 */
                refreshAfterWrite(2, TimeUnit.SECONDS).
                expireAfterAccess(10, TimeUnit.SECONDS).
                initialCapacity(100).//设置初始化容量
                maximumSize(100).//设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                recordStats().///设置要统计缓存的命中率
                build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println("回溯数据源模拟从数据库中取出数据");
                //当缓存没有命中的时候从其他数据源查询，例如数据库，查到后会更新缓存
                return "value111111";
            }
        });

        try {
            //cache.put("1", "a");手动添加缓存,如果有值就进行更新操作
            cache.put("1", "a");
            String v = cache.get("1");
            System.out.println(v);
            Thread.sleep(1000);
            Thread.sleep(1000);
            String v1 = cache.get("1");
            System.out.println(v1);
            System.out.println(cache.stats());//查看缓存命中状态
            Thread.sleep(1000);
            //cache.invalidate(key");指定缓存记录失效
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}