package 员工打卡系统;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Employee implements Serializable{
	private int ID;
	private String name;
	//private Calendar dao;
	//private Calendar tui;
	private DakaInfo daka;
	public Employee(int iD, String name) {
		super();
		ID = iD;
		this.name = name;
		this.daka =  new DakaInfo();
		/*FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("d:/打卡.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	public DakaInfo getDaka() {
		return daka;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "ID:"+this.ID+"姓名:"+this.name;
	}
	/*public  void Qiandao() {
		dao = Calendar.getInstance();
	}
	
	public  void Qiantui() {
		tui = Calendar.getInstance();
	}
	public Calendar getDao() {
		return dao;
	}
	public Calendar getTui() {
		return tui;
	}*/
}
