package Queue;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class IArrayBlockingQueue<E> {
    private ReentrantLock lock ;
    private int count;
    private E items[];


    private int takeIndex;
    private int putIndex;

    /** Condition for waiting puts */
    private final Condition notFull ;

    /** Condition for waiting takes */
    private final Condition notEmpty ;

    public IArrayBlockingQueue(int capacity) {

        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
        items = (E[]) new Object[capacity];
    }

    public boolean add(E e) {
        if (offer(e)) return true;
        else throw new IllegalStateException("Queue full");

    }


    public boolean offer(E e) {
        Objects.requireNonNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length) {
                return false;
            } else {
                enqueue(e);
                return true;
            }
        } finally {
            lock.unlock();
        }

    }
    private void enqueue(E e) {
//        final E[] items = this.items;
        items[putIndex] = e;
        if (++putIndex == items.length) putIndex = 0;
        count++;
        notFull.signal();
    }

    private E dequeue() {

        E e = items[takeIndex];
        if (++takeIndex == items.length) takeIndex = 0;
        count--;
        //dequeue要去唤醒put
        notEmpty.signal();
        return e;
    }


    public void put(E e) throws InterruptedException {
        Objects.requireNonNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();

        try {
            while (count == items.length) {// 阻塞等待
                notFull.await();
            }
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }



    /**
     * 如果取不到数据，则return null
     * @return
     */
    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();

        try {
            return (count <= 0) ? null : dequeue();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 如果队列为空，则进入阻塞状态等待，直到队列有新的数据被加入，再及时取出新加入的数据
     * @return
     */
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();

        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }

    }
//    public void testMethod(int i) {
//        Integer[] x = new Integer[10];
//        x[0] = i;
//    }
    public static void main(String[] args) {
        Object[] i =  new Object[10];
        i[0] = 1;
    }
//


}
