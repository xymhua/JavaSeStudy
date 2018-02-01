import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class SellTicketTest {
	public static void main(String[] args) throws Exception {
		/*
			卖票
		*/

		SellTicket st1 = new SellTicket();
		SellTicket st2 = new SellTicket();
		SellTicket st3 = new SellTicket();

		st1.setName("窗口1");
		st2.setName("窗口2");
		st3.setName("窗口3");

		st1.start();
		st2.start();
		st3.start();
	}
}

class SellTicket extends Thread {

	private static int ticket = 1000;

	@Override
	public void run() {
		while (true) {
			System.out.println(getName() + " 正在卖第 " + (ticket--) + " 张票");
			
			if(ticket == 0) {
				break;
			}
		}
	}
}

