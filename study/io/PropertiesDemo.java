import java.io.*;
import java.util.*;

class PropertiesDemo {
	public static void main(String[] args) throws Exception{
		/*
			Properties集合,继承自Hashtable,所以是Map集合
			用于IO流与集合结合?
		*/

		//首先创建一个Properties对象
		Properties prop = new Properties();

		//添加集合元素 <String,String>
		prop.setProperty("222","111");
		prop.setProperty("3330","4444");

		//遍历集合
		Set<String> set = prop.stringPropertyNames();
		for(String s : set){
			String value = prop.getProperty(s);
			System.out.println(s + "---" + value);
		}

		/*
			与IO流的结合使用 
				Load(Reader reader)
				store(Writer w,String comm)
		*/

		// 写入
		FileWriter writer = new FileWriter("PropertiesText.txt");
		prop.store(writer, null);
		writer.close();

		//清空集合
		prop.clear();

		// 读取
		FileReader fr = new FileReader("PropertiesText.txt");
		prop.load(fr);
		fr.close();

		//看结果
		System.out.println(prop);



	}
}
