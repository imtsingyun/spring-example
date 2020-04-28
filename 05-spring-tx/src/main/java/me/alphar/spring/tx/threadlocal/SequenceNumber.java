package me.alphar.spring.tx.threadlocal;

/**
 * ThreadLocal 的简单使用
 */
public class SequenceNumber {
    // 匿名内部类覆盖 ThreadLocal 的 initialValue() 方法
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        TestClient tc1 = new TestClient(sn);
        TestClient tc2 = new TestClient(sn);
        TestClient tc3 = new TestClient(sn);

        tc1.start();
        tc2.start();
        tc3.start();

        System.out.println(sn);
    }

    private static class TestClient extends Thread {
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i= 0; i<3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] sn [" + sn.getNextNum() + "]");
            }
        }
    }
}
