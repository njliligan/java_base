package com.njganlili.juc.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @author njgan
 * @description 在原先读写锁的基础上新增了一种叫乐观读（Optimistic Reading）的模式。该模式并不会加锁，所以不会阻塞线程，会有更高的吞吐量和更高的性能
 * @date 2022/2/25 14:55
 */
//三种访问数据模式：
//
//Writing（独占写锁）：writeLock 方法会使线程阻塞等待独占访问，可类比ReentrantReadWriteLock 的写锁模式，同一时刻有且只有一个写线程获取锁资源；
//Reading（悲观读锁）：readLock方法，允许多个线程同时获取悲观读锁，悲观读锁与独占写锁互斥，与乐观读共享。
//Optimistic Reading（乐观读）：这里需要注意了，是乐观读，并没有加锁。也就是不会有 CAS 机制并且没有阻塞线程。仅当当前未处于 Writing 模式 tryOptimisticRead才会返回非 0 的邮戳（Stamp），如果在获取乐观读之后没有出现写模式线程获取锁，则在方法validate返回 true ，允许多个线程获取乐观读以及读锁。同时允许一个写线程获取写锁。
//
//支持读写锁相互转换
//ReentrantReadWriteLock 当线程获取写锁后可以降级成读锁，但是反过来则不行。
//StampedLock提供了读锁和写锁相互转换的功能，使得该类支持更多的应用场景。
//注意事项
//
//StampedLock是不可重入锁，如果当前线程已经获取了写锁，再次重复获取的话就会死锁；
//都不支持 Conditon 条件将线程等待；
//StampedLock 的写锁和悲观读锁加锁成功之后，都会返回一个 stamp；然后解锁的时候，需要传入这个 stamp。
//
//详解乐观读带来的性能提升
//那为何 StampedLock 性能比 ReentrantReadWriteLock 好？
//关键在于StampedLock 提供的乐观读，我们知道ReentrantReadWriteLock 支持多个线程同时获取读锁，但是当多个线程同时读的时候，所有的写线程都是阻塞的。
//StampedLock 的乐观读允许一个写线程获取写锁，所以不会导致所有写线程阻塞，也就是当读多写少的时候，写线程有机会获取写锁，减少了线程饥饿的问题，吞吐量大大提高。
//这里可能你就会有疑问，竟然同时允许多个乐观读和一个先线程同时进入临界资源操作，那读取的数据可能是错的怎么办？
//是的，乐观读不能保证读取到的数据是最新的，所以将数据读取到局部变量的时候需要通过 lock.validate(stamp) 校验是否被写线程修改过，若是修改过则需要上悲观读锁，再重新读取数据到局部变量。
//
public class StampedLockTest {

    public static void main(String[] args){
        StampedLock stampedLock = new StampedLock();
        stampedLock.asReadLock();
        stampedLock.asReadWriteLock();
        stampedLock.asWriteLock();
    }

}
