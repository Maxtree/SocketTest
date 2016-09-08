package SocketTest01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {
	public static void mai(String[] args) {
		
	}
	
//	静态方法
	public static void sever() {
//		创建套接字的时候可能会抛出异常，所以要进行异常捕获
		try {
//			创建服务器端的套接字，并绑定端口
			ServerSocket ss = new ServerSocket(6000);
			
//			调用套接字ss的accept方法，调用这个方法的时候就会阻塞，
//			知道客户端有连接请求到来的时候，accept会返回一个套接字，
//			利用这个套接字和客户端进行数据通信			
			Socket s = ss.accept();
			
//			利用套接字获取输出流
			OutputStream os = s.getOutputStream();
			
//			利用套接字获取输入流
			InputStream is = s.getInputStream();
			
//			利用输出流可以向客户端发送数据,并转换成字节数组
//			利用getBytes()将字符串转化为字节数组
			os.write("Hello,welcome you to connect.".getBytes());
			
//			定义一个字节数组，利用输入流从网上读取数据，读取网上的数据，将数据存储到buf数组中
			byte[] buf = new byte[100];
			
//			利用is.read(buf)，读取网上的数据，并返回实际读取的字节数	
			int len = is.read(buf);
			
//			将读取的数据打印出来
			System.out.println(new String(buf,0,len));
 			
//			通信完成之后，输入输出流关闭、套接字关闭、服务器套接字关闭
			os.close();
			is.close();
			s.close();
			ss.close();
		}
//		捕获异常
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void client() {
//		创建客户端的套接字，指定IP地址和端口，来连接到服务器端上，在这个端口上等待连接的服务器进程 
		try {
			Socket s = new Socket(InetAddress.getByName(null), 6000);
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			byte[] buf = new byte[100];
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



















