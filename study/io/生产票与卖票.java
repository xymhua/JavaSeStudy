import java.io.*;
import java.util.*;

class 生产票与卖票 {
	public static void main(String[] args) throws Exception {
		// 存票的仓库对象!
		TicketRepo tr = new TicketRepo();

		// 生产票和卖票的对象
		AddTicket at = new AddTicket(tr);
		SellTicket st = new SellTicket(tr);

		// 创建生产票和卖票的线程
		Thread add1 = new Thread(at, "生产者1");
		Thread add2 = new Thread(at, "生产者2");
		Thread add3 = new Thread(at, "生产者3");

		Thread sell1 = new Thread(st, "消费者1");
		Thread sell2 = new Thread(st, "消费者2");
		Thread sell3 = new Thread(st, "消费者3");

		// 开始造票卖票
		add1.start();
		add2.start();
		add3.start();

		sell1.start();
		sell2.start();
		sell3.start();		
	}

}

// 票仓库
class TicketRepo {
	// 创建一个集合，用来存储票，用linkedList增删快
	private LinkedList<Ticket> linkedTicket = new LinkedList<>();

	// 添加票进仓库的方法，name是票名，id是票的id号码
	public synchronized void addTicketToRepo(String name, int id) {

		// 如果库存大于50张就先不生产
		if (linkedTicket.size() <= 50) {
			// 造一张票
			Ticket newTicket = new Ticket(name, id);

			// 把票加进仓库
			linkedTicket.add(newTicket);

			// 唤醒卖票方法，告诉他有票了
			this.notify();
		}
	}

	// 卖票的方法，删除最早造的一张票并返回票的ID号码
	public synchronized int sellTicketFromRepo() {
		// 默认-1，返回-1说明卖票失败
		int sellId = -1;

		// 如果库存小于1张，就先等待造票
		if(linkedTicket.size() < 1) {
			try {
				this.wait();
			}catch(Exception E){}
		}

		// 如果库存大于0张，就卖一张票，返回票的ID
		if (linkedTicket.size() > 0) {
			// 删除一张票
			Ticket t = linkedTicket.removeFirst();
			sellId = t.getId();
		}

		return sellId;
	}
}

class Ticket {
	// 票的名字
	private String name;
	// 票的ID号码
	private int id;

	public Ticket(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

// 卖票线程类
class SellTicket implements Runnable {
	private TicketRepo t;

	// 把仓库对象传进来操作
	public SellTicket(TicketRepo t) {
		this.t = t;
	}


	@Override
	public void run() {
		while (true) {
			// 调用仓库对象的卖票方法
			int id = t.sellTicketFromRepo();

			// 打印哪个消费者买了哪张票
			System.out.println(Thread.currentThread().getName() + "购买了一张票, + ID: " + id);
		}
	}
}

class AddTicket implements Runnable {
	// 三个生产者共享一个ID
	private int id = 0;

	private TicketRepo t;

	public AddTicket(TicketRepo t) {
		this.t = t;
	}

	@Override
	public void run() {
		while (true) {
			// ID只能有一个生产者改，所以加锁
			synchronized (this) {
				// 调用仓库对象的生产票方法
				t.addTicketToRepo("Java教程大电影", id);

				// id加1
				id++;

				// 打印哪个生产者生成了哪张票
				System.out.println(Thread.currentThread().getName() + " 生产了一张票！ ID： " + id);
			}
		}
	}
}
