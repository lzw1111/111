package Ա����ϵͳ;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		Employee e1 = new Employee(111, "lzw");
		Employee e2 = new Employee(222, "cyc");
		Employee e3 = new Employee(333, "wy");
		Employee e4 = new Employee(444, "jhr");
		Company com = new Company();
		com.add(e1);
		com.add(e2);
		com.add(e3);
		com.add(e4);
		while(true) {
		System.out.println("----------Ա����ϵͳ----------");
		System.out.println("���� 0--------�˳�\r\n" + 
				"���� 1--------ǩ��\r\n" + 
				"���� 2--------ǩ��\r\n" + 
				"���� 3--------�鿴ǩ��ǩ����Ϣ");
		System.out.println("��������ִ�еĲ�����");
		int cmd = new Scanner(System.in).nextInt();
		switch(cmd) {
		case 0:
			return;
		case 1:
			com.Qiandao();
			com.Shuchu();
			break;
		case 2:
			com.Qiantui();
			com.Shuchu();
			break;
		case 3:
			try {
				com.Chakan();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		}
	}
}
