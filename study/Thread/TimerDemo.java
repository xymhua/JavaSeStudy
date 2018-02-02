import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class TimerDemo {
	public static void main(String[] args) throws Exception {
		Timer t = new Timer();
		// 三秒后执行任务
		t.schedule(new Boom(t), 3000);

		// 三秒后执行，之后每隔两秒一次
		t.schedule(new Boom(t), 3000, 2000);
	}

}

// 写一个定时任务类
class Boom extends TimerTask {
	private Timer t;

	public Boom(Timer t){
		this.t = t;
	}
	public void run() {
		System.out.println("BOOm!");
		t.cancel();
	}
}