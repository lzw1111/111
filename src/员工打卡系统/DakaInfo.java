package 员工打卡系统;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DakaInfo implements Serializable{
	//HashMap<String, Employee> Dakainfo;
	private int ID;
	private Date dao;
	private Date tui;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getDao() {
		return dao;
	}
	public Date getTui() {
		return tui;
	}
	public  void Qiandao() {
		dao = new Date();
	}
	
	public  void Qiantui() {
		tui = new Date();
	}
}
