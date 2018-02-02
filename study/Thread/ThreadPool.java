import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class ThreadPool {
	public static void main(String[] args) throws Exception {
		// 创建一个线程池对象	
		ExecutorService pool = Executors.newFixedThreadPool(2);

		// 执行线程
		pool.submit(new MyRunnable());
		Fature f = pool.submit(new MyCallable());
		f.get();

		// 结束线程池
		pool.shutdown();
	}

}

class MyRunnable implements Runnable {
	public void run() {

	}
}

class MyCallable implements Callable<String> {
	public String call() {
		return "111";
	}
}