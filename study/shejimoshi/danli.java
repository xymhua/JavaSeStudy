import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class DanLiDemo {
	public static void main(String[] args) throws Exception {
		Student s1 = Student.getStudent();
		Student s2 = Student.getStudent();

		boolean b = (s1 == s2); // true
	}
}

// 单例模式，饿汉式，一进来就先创建一个对象
class Student {
	private Student() {};

	private static Student s = new Student();

	public static Student getStudent() {
		return s;
	}
}

// 懒汉式
class Teacher {
	private Teacher(){};

	private static Teacher t = null;

	public static Teacher getTeacher() {
		if (t == null) {
			t = new Teacher();
		}
		return t;
	}
}