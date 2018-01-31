package study.io; 

import java.io.*;

class CopyFolderDemo {
	public static void main(String[] args) throws Exception{
		//数据源,复制这个文件夹
		File file = new File("e:\\JavaTest");

		//目的地,复制到这个地方去
		File copyFile = new File("e:\\JavaTestCopy");

		//复制方法
		copyFolder(file,copyFile);

	}

	/**
	*	复制文件夹的方法，传入源文件夹的文件对象与目的地的文件对象即可
	*
	*	异常应该用try...catch处理，这里为了方便直接抛出
	*/
	private static void copyFolder(File file, File copyFile) throws Exception{
		//判断是否存在这个文件夹，不存在就创建，防止FileNotFoundException
		if(!copyFile.exists()){
			copyFile.mkdirs();
		}

		//获取当前目录所有文件的对象
		File[] files = file.listFiles();

		//防止有些文件无法访问报空指针异常
		if(files == null){
			return;
		}


		for(File f : files){
			if(f.isFile()){
				cFile(f,new File(copyFile,f.getName()));
			}else{
				copyFolder(f,new File(copyFile,f.getName()));
			}
		}
	}

	private static void cFile(File oldFile, File newFile) throws Exception{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(oldFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));

		byte[] b = new byte[1024];
		int len = 0;
		while((len = bis.read(b)) != -1){
			bos.write(b,0,len);
			bos.flush();
		}

		bis.close();
		bos.close();

	}
}

