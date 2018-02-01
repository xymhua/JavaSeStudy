import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class ThreadRunnableDemo {
	public static void main(String[] args) throws Exception {
		/*
			Runnable实现线程启动
		*/

		//创建Runnable对象
		MyRunnable myRunnable = new MyRunnable();
		MyRunnable myRunnable2 = new MyRunnable();

		//创建Thread对象
		Thread td = new Thread(myRunnable, "线程1");
		Thread td2 = new Thread(myRunnable2, "线程2");

		td.start();
		td2.start();

	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
	}
}

