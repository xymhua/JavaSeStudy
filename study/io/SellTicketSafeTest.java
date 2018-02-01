import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class SellTicketSafeTest {
	public static void main(String[] args) throws Exception {
		/*
			卖票 Runnable实现 ，并使用了同步代码块来保证线程安全

			只要锁是同一个对象，就只能进去一个线程

			同步方法的锁是this
			同步静态方法的锁是.class文件，也就是SellTicket.class;
		*/

		SellTicket st = new SellTicket();

		Thread t1 = new Thread(st, "窗口1");
		Thread t2 = new Thread(st, "窗口2");
		Thread t3 = new Thread(st, "窗口3");

		t1.start();
		t2.start();
		t3.start();
	}

	// 这里用了同步方法，同步方法的锁是this!
	private synchronized static void synMethod(){
		// 代码内容
	}
}

class SellTicket implements Runnable {

	// 定义100张票
	private int ticket = 100;

	// 同步锁，必须多个线程用同一把锁，这个锁可以用任意对象，随便创建一个空的类创对象都行
	private Object ojb = new Object();

	@Override
	public void run() {

		// 不停的卖票直到卖完
		while (true) {

			// 使用同步代码块锁住
			synchronized (ojb) {
				// 0张票不准再卖 
				if(ticket > 0) {

					// 网络售票有传输延迟! 100ms
					try {
						Thread.sleep(100);
					} catch (Exception e){}

					// 开始卖票
					System.out.println(Thread.currentThread().getName() + " 正在卖第 " + (ticket--) + " 张票");
				} else {
					// 卖完了，退出循环
					break;
				}
			}
		}
	}
}

