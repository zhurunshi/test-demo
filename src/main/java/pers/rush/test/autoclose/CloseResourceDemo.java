package pers.rush.test.autoclose;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class MyClose implements AutoCloseable {
	public MyClose() {
		System.out.println("============创建资源==============");
	}

	@Override
	public void close() throws Exception {
		System.out.println("============资源已关闭==============");
	}
	
}

public class CloseResourceDemo {
	public static void main(String[] args) throws Exception {
//		test1();
		templateTryWithResource();
	}

	private static void test1() throws Exception {
		//1.创建源和目标
		File srcFile = new File("file/src.txt");
		File destFile = new File("file/dest.txt");
		//2.创建输入输出对象
		InputStream in = new FileInputStream(srcFile);
		OutputStream out = new FileOutputStream(destFile);
		//3.读取/写入操作
		byte[] buffer = new byte[10];
		int len = -1;//如果是-1表明文件已经读取到最后
		
		while((len = in.read(buffer)) != -1) {
			// 写入
			out.write(buffer, 0, len);
		}
		//4.关闭资源
		in.close();
		out.close();
	}
	
	private static void template() {
		// 声明资源对象
		InputStream in = null;
		OutputStream out = null;
		try {
			// 可能出现异常的代码
		} catch(Exception e) {
			// 处理异常
			e.printStackTrace();
		} finally {
			// 关闭资源
		}
	}
	
	private static void test2() {
		// 声明资源对象
		InputStream in = null;
		OutputStream out = null;
		try {
			// 可能出现异常的代码
			
			//1.创建源和目标
			File srcFile = new File("file/src.txt");
			File destFile = new File("file/dest.txt");
			//2.创建输入输出对象
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			//3.读取/写入操作
			byte[] buffer = new byte[10];
			int len = -1;//如果是-1表明文件已经读取到最后
			
			while((len = in.read(buffer)) != -1) {
				// 写入
				out.write(buffer, 0, len);
			}
		} catch(Exception e) {
			// 处理异常
			e.printStackTrace();
		} finally {
			// 关闭资源

			// 4.关闭资源
			try {
				if (in != null) {
					in.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void templateTryWithResource() {
		//1.创建源和目标
		File srcFile = new File("file/src.txt");
		File destFile = new File("file/dest.txt");
		try (
				//打开资源的代码
				
				//2.创建输入输出对象
				InputStream in = new FileInputStream(srcFile);
				OutputStream out = new FileOutputStream(destFile);
				MyClose mc = new MyClose();
			) {
			//可能出现异常的代码
			
			//3.读取/写入操作
			byte[] buffer = new byte[10];
			int len = -1;//如果是-1表明文件已经读取到最后
			
			while((len = in.read(buffer)) != -1) {
				// 写入
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void test3() {
		
	}
}
