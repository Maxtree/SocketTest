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
	
//	��̬����
	public static void sever() {
//		�����׽��ֵ�ʱ����ܻ��׳��쳣������Ҫ�����쳣����
		try {
//			�����������˵��׽��֣����󶨶˿�
			ServerSocket ss = new ServerSocket(6000);
			
//			�����׽���ss��accept�������������������ʱ��ͻ�������
//			֪���ͻ�����������������ʱ��accept�᷵��һ���׽��֣�
//			��������׽��ֺͿͻ��˽�������ͨ��			
			Socket s = ss.accept();
			
//			�����׽��ֻ�ȡ�����
			OutputStream os = s.getOutputStream();
			
//			�����׽��ֻ�ȡ������
			InputStream is = s.getInputStream();
			
//			���������������ͻ��˷�������,��ת�����ֽ�����
//			����getBytes()���ַ���ת��Ϊ�ֽ�����
			os.write("Hello,welcome you to connect.".getBytes());
			
//			����һ���ֽ����飬���������������϶�ȡ���ݣ���ȡ���ϵ����ݣ������ݴ洢��buf������
			byte[] buf = new byte[100];
			
//			����is.read(buf)����ȡ���ϵ����ݣ�������ʵ�ʶ�ȡ���ֽ���	
			int len = is.read(buf);
			
//			����ȡ�����ݴ�ӡ����
			System.out.println(new String(buf,0,len));
 			
//			ͨ�����֮������������رա��׽��ֹرա��������׽��ֹر�
			os.close();
			is.close();
			s.close();
			ss.close();
		}
//		�����쳣
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void client() {
//		�����ͻ��˵��׽��֣�ָ��IP��ַ�Ͷ˿ڣ������ӵ����������ϣ�������˿��ϵȴ����ӵķ��������� 
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



















