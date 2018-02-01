import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class MyThreadSleepAndJoinDemo {
	public static void main(String[] args) throws Exception {
		/*
			多线程的睡眠与加入
			Thread.yield();  线程礼让，暂停当前正在执行的线程对象，并执行其他线程.
							 让多个线程更和谐，但不能保证一人一次！
							 		所以感觉没啥用~

		*/

		// create object
		MyThread mt = new MyThread();
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();

		// 设置守护线程，当只剩下守护线程时停止所有守护线程
		mt.setDaemon(true);
		mt1.setDaemon(true);
		mt2.setDaemon(true);

		// join方法，等待该线程执行完毕
		mt.start();
		try {
			mt.join();
		} catch (Exception e) {}

		// start thread
		mt1.start();
		mt2.start();

		// main print
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}

	}

}

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "  :  " + i + "time: " + new Date());

			//睡眠一秒
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Exception!");
			}
		}
	}
}