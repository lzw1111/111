package 员工打卡系统;

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
		System.out.println("----------员工打卡系统----------");
		System.out.println("输入 0--------退出\r\n" + 
				"输入 1--------签到\r\n" + 
				"输入 2--------签退\r\n" + 
				"输入 3--------查看签到签退信息");
		System.out.println("请输入想执行的操作：");
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
