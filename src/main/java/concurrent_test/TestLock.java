package concurrent_test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangll
 * @create 2019-12-17 21:01
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticke = new Ticket();
        new Thread(ticke, "1号窗口").start();
        new Thread(ticke, "2号窗口").start();
        new Thread(ticke, "3号窗口").start();
    }


}

class Ticket implements Runnable {

    private int tick = 100;
    private Lock lock = new ReentrantLock();

    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tick > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --tick);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}