import java.io.*;

class InputStreamDemo {
	public static void main(String[] args) throws Exception{
		//通过IO流读取键盘数据，打印到控制台上

		//首先获取标准输入输出流
		InputStream is = System.in;
		OutputStream os = System.out;

		//包装
		/*	
		错误示例:
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);
		分析:
			BufferedWriter BufferedReader类才有readLine方法 qwq
		*/
		
		//包装
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

		//读输入流数据，打印
		String line = null;
		while((line = br.readLine()) != null){
			/*
				错题本:
					if(line == "exit"){
						break;
					}
				分析:
					==比较的是地址值!!!
			*/
			if(line.equals("exit")){
				break;
			}

			bw.write(line);
			bw.newLine();
			bw.flush();
		}

		br.close();
		bw.close();


	}
}

