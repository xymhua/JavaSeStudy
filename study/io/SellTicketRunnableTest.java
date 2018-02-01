import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class SellTicketRunnableTest {
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

	private int ticket = 1000;

	@Override
	public void run() {
		while (true) {
			if(ticket > 0) {
				// 网络售票有传输延迟! 100ms
				try {
					Thread.sleep(100);
				} catch (Exception e){}

				System.out.println(Thread.currentThread().getName() + " 正在卖第 " + (ticket--) + " 张票");
			}
			if(ticket == 0) {
				break;
			}
		}
	}
}

