package com.zhliang.pzy.spring.fox.uid;

import com.zhliang.pzy.common.core.assertion.enums.ArgumentResponseEnum;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * 高效分布式ID生成算法(sequence),基于Snowflake算法优化实现64位自增ID算法。
 * 其中解决时间回拨问题的优化方案如下：
 * 1. 如果发现当前时间少于上次生成id的时间(时间回拨)，着计算回拨的时间差
 * 2. 如果时间差(offset)小于等于5ms，着等待 offset * 2 的时间再生成
 * 3. 如果offset大于5，则直接抛出异常
 *
 */
public class IdGenerator {
    private static Sequence WORKER = new Sequence();

    public static long getId() {
        return WORKER.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(WORKER.nextId());
    }

    //1 00011101000110110001101101110101010001 0000011011 000000000000
    //
    //1 00011101000111010001111100000000010111 0001000001 000000000000  1284038197596393472
    //1 00011101000111010001111100000000010111 0001000001 000000000000  1284038197596393473
    //1 00011101000111010001111100000000010111 0001000001 000000000000
    //1 00011101000111010010110000111111101111 0001100001 000000000000  1284039107961819136
    public static void main(String[] args) throws UnknownHostException {
        //for (int i = 0; i < 10; i++) {
        //    System.out.println("==>" + getId());
        //}
        //System.out.println("\n\n");
        //for (int i = 0; i < 10; i++) {
        //    long id = IdGenerateUtil.get().nextId();
        //    System.out.println("==>" + id );
        //}
        long id = IdGenerateUtil.get().nextId();
        System.out.println(Inet4Address.getLocalHost().getHostAddress());
        System.out.println(Inet4Address.getLocalHost().getHostName());
    }
}
