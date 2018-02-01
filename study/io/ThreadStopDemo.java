import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class ThreadStopDemo {
	public static void main(String[] args) throws Exception {
		/*
			中断线程，Stop已过时
			interrupt();清除线程状态，并抛出异常

		*/

		MyThread mt = new MyThread();
		mt.start();

		// 等三秒，把等10秒的线程的睡眠状态清了，并抛出异常让他处理
		try {
			Thread.sleep(3000);
			mt.interrupt();
		} finally {}

	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println(getName() + "  :  开始执行+ " + "time: " + new Date());
		//睡眠一秒
		try {
			Thread.sleep(10000);
		} catch (Exception e) {	
			System.out.println("Exception!");
		}
	}

}