import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class SellTicketSafeTest {
	public static void main(String[] args) throws Exception {
		/*
			卖票 Runnable实现
		*/

		SellTicket st = new SellTicket();

		Thread t1 = new Thread(st, "窗口1");
		Thread t2 = new Thread(st, "窗口2");
		Thread t3 = new Thread(st, "窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}

class SellTicket implements Runnable {

	// 定义100张票
	private int ticket = 100;

	// 同步锁，必须多个线程用同一把锁
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

