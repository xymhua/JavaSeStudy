import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class HideInnerClassDemo {
	public static void main(String[] args) throws Exception {
		new Thread() {
			// 这里重写run方法
		}.start();

		new Thread(new Runnable() {
			// 这里重写run方法
		}) {}.start();
	}

}
