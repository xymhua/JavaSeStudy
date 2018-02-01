import java.io.*;

class ObjectStreamDemo {
	public static void main(String[] args) throws Exception{
		//ObjectInputStream OjbectOutputStream是序列化与反序列化流
		//用于将对象存入文件或发送到网络另一端
		//没写序列化ID！

		//创建序列化流对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ObjectStream.txt"));

		//创建,写入对象
		//类要实现Serializable接口才能被序列化
		Person p = new Person();
		oos.writeObject(p);

		//创建反序列化对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ObjectStream.txt"));

		//读对象
		Person p1 = (Person) ois.readObject();

		//测试对象是否可用
		System.out.println(p1);

		//关闭流
		ois.close();
		oos.close();


	}
}

//注意对象要实现Serializable标记接口
class Person implements Serializable{
	private int age;
	private String name;

	public Person() {
		age = 28;
		name = "xm";
	}

	public String toString(){
		return name + age;
	}
}