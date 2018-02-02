import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class ThreadGroupDemo {
	public static void main(String[] args) throws Exception {
		/*
			
		*/
		SellTicket st = new SellTicket();
		ThreadGroup tg = new ThreadGroup("这是一个新组");
		Thread td = new Thread(tg, st, "窗口一");
		tg.setDaemon(true);
		
	}

}

class SellTicket implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}

