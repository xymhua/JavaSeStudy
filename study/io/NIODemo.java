import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

class NIODemo {
	public static void main(String[] args) throws Exception{
		/*
			JDK7新特性:
				Path:	与平台无关的路径
				Paths:	包含了返回Path的静态方法
							public static Path get(URI uri); 根据URI来确定文件路径

				Files:	操作文件的工具类，提供大量方法
							public static long copy(Path source, OutputStream out) : 复制文件
							public static Path write(Path path, Iterable<? extends CharSequence> lines,
													 Charset cs,OpenOption...op)
													:把集合数据写到文件
		*/

		//复制文件
		 Files.copy(Paths.get("a.txt"), new FileOutputStream("b.txt"));

		//将集合内容写入文件
		 ArrayList<String> al = new ArrayList<>();
		 al.add("111");
		 al.add(String.valueOf(234));

		 Files.write(Paths.get("array.txt"), al, Charset.forName("UTF-8"));
	}
}
