import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class MyThreadDemo {
	public static void main(String[] args) throws Exception {
		/*
			多线程的使用
		*/

		// 创建线程对象
		MyThread mt = new MyThread();
		MyThread mt1 = new MyThread();

		// 设置线程名
		mt.setName("one");
		mt1.setName("two");

		//启动线程
		mt.start();
		mt1.start();
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.println(getName() + "  :  " + i);
		}
	}
}