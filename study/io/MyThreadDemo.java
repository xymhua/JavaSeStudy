import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class MyThreadDemo {
	public static void main(String[] args) throws Exception {
		/*
			多线程的启动，设置线程名，优先级设置和获取，
		*/

		// 返回当前正在执行的线程对象
		System.out.println(Thread.currentThread().getName()); // main

		// 两种设置线程名的方式
		// threadStart1();
		// threadStart2();

		// 创建线程对象
		MyThread mt = new MyThread("one");
		MyThread mt1 = new MyThread("two");

		// 获取线程优先级
		int mtPriority = mt.getPriority();
		int mt1Priority = mt1.getPriority();
		System.out.println(mtPriority + "---" + mt1Priority); //默认值为5

		// 设置线程优先级
		mt.setPriority(10);	//最大值10
		mt1.setPriority(1);	//最小值1

		// 启动线程
		mt.start();
		mt1.start();


	}

	// 通过setName()方法修改线程名
	public static void threadStart1() {
		// 创建线程对象
		MyThread mt = new MyThread();
		MyThread mt1 = new MyThread();

		// 设置线程名
		mt.setName("one");
		mt1.setName("two");

		// 启动线程
		mt.start();
		mt1.start();
	}

	// 通过构造方法修改线程名
	public static void threadStart2() {
		// 创建线程对象
		MyThread mt = new MyThread("oneoneone");
		MyThread mt1 = new MyThread("twotwotwo");

		// 启动线程
		mt.start();
		mt1.start();
	}
}

// 继承Thread类
class MyThread extends Thread {

	public MyThread() {};

	public MyThread(String name) {
		super(name);
	}

	// 重写run方法,start()会调用这里
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.println(getName() + "  :  " + i);
		}
	}
}