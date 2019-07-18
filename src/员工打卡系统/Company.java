package Ա����ϵͳ;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public class Company {
	private HashMap<Integer,Employee > Employees;
	private HashMap<Employee, DakaInfo> Records;
	public HashMap<Integer, Employee> getEmployees() {
		return Employees;
	}
	public HashMap<Employee, DakaInfo> getRecords() {
		return Records;
	}
	public Company() {
		Employees = new HashMap<Integer, Employee>();
		Records = new HashMap<Employee, DakaInfo>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("d:/��.txt");
			ois = new ObjectInputStream(fis);
			Object e = null;
			while((e = ois.readObject()) != null) {
				Employee e1 = (Employee)e;
				Records.put(e1, e1.getDaka());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
			e.getStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}
	public void add(Employee e) {
		Employees.put(e.getID(), e);
		System.out.println("�����Ϣ�ɹ�");
	}
	public void delete(Employee e) {
		Employees.remove(e.getID(), e);
	}
	public boolean lookfor(int ID) {
		if(Employees.containsKey(ID)) {
			return true;
		}
		return false;
	}
	public String printfor(int ID) {
		return Employees.get(ID).toString();
	}
	public void Qiandao() throws IOException {
		System.out.println("����������id��");
		int i = new Scanner(System.in).nextInt();
		if(lookfor(i)) {
			Employee e = Employees.get(i);
			//e.Qiandao();
			if(Records.size() !=0) {
				boolean flag = true;
				Collection c = Records.values();
				Iterator it = c.iterator();
				while(it.hasNext()) {
					DakaInfo daka = (DakaInfo) it.next();
					if(daka.getID() == i) {
				//if(Records.containsKey(e)) {
						System.out.println("������Ѿ�ǩ�����ˣ�");
						flag = false;;
						break;
					//Calendar dao = e.getDao();
					//da.Dakainfo.put(sdf.format(dao),e);
					/*try (FileWriter fw = new FileWriter("d:/Ա������Ϣ.txt", true);){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						fw.write("ID:"+e.getID()+"name:"+e.getName()+"ǩ��ʱ�䣺"+sdf.format(e.getDaka().getDao()));
						fw.write("\n");
					} catch (IOException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}*/
				}/*else if(Yanzheng(e.toString())) {
					System.out.println("������Ѿ�ǩ�����ˣ�");
					break;
				}*/
				}
				if(flag) {
					e.getDaka().setID(i);
					e.getDaka().Qiandao();
					Records.put(e,e.getDaka());
					System.out.println("����"+i+"ǩ���ɹ�");
				}
			}else {
				if(Records.containsKey(e)) {
					System.out.println("������Ѿ�ǩ�����ˣ�");
				}/*else if(Yanzheng(e.toString())) {
					System.out.println("������Ѿ�ǩ�����ˣ�");
				}*/else {
					e.getDaka().setID(i);
					e.getDaka().Qiandao();
					Records.put(e,e.getDaka());
					System.out.println("����"+i+"ǩ���ɹ�");
				}
			}
		}else {
			System.out.println("�޴�idԱ��");
		}
	}
	private boolean Yanzheng(String string) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader bfr = null;
		try {
			fr = new FileReader("d:/Ա������Ϣ.txt");
			bfr = new BufferedReader(fr);
			String line;
			while((line = bfr.readLine()) != null) {
				if(string.equals(line)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fr.close();
			bfr.close();
		}
		return false;
	}
	public void Qiantui() throws IOException {
		System.out.println("����������id��");
		int i = new Scanner(System.in).nextInt();
		if(lookfor(i)) {
			Employee e = Employees.get(i);
			Collection c = Records.values();
			Iterator it = c.iterator();
			boolean flag = true;
			while(it.hasNext()) {
				DakaInfo daka = (DakaInfo) it.next();
				if(daka.getID() == i) {
					daka.Qiantui();
					System.out.println("����"+i+"ǩ�˳ɹ�");
					flag=false;
					break;
				}/*else if(Yanzheng(e.toString())) {
					daka.Qiantui();
					System.out.println("����"+i+"ǩ�˳ɹ�");
					break;
				}*/
			}if(flag){
				System.out.println("����"+i+"���컹û��ǩ�����޷�ǩ��");
			}
		}else {
			System.out.println("�޴�idԱ��");
		}
	}
			//e.Qiantui();
			//Calendar tui = e.getDao();
			//Date tui = e.getDaka().getTui();
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//da.Dakainfo.put(sdf.format(tui),e);
			//if(e.getDaka().getDao() != null) {
			//if(Records.containsKey(e)) {
				//DakaInfo daka = Records.get(e);
				//daka.Qiantui();
				//System.out.println("����"+i+"ǩ�˳ɹ�");
				/*try (FileWriter fw = new FileWriter("d:/Ա������Ϣ.txt", true);){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					fw.write("ID:"+e.getID()+"name:"+e.getName()+"ǩ��ʱ�䣺"+sdf.format(e.getDaka().getTui()));
					fw.write("\n");
				} catch (IOException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}*/
			/*}else if(Yanzheng(e.toString())) {
				DakaInfo daka = Records.get(e);
				daka.Qiantui();
				System.out.println("����"+i+"ǩ�˳ɹ�");
			}else {
				System.out.println("����"+i+"���컹û��ǩ�����޷�ǩ��");
			}
		}*/
	/*public void Chakan() {
		Collection c = Records.values();
		Iterator it = c.iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while(it.hasNext()) {
			DakaInfo daka = (DakaInfo) it.next();
			System.out.print("ID��"+daka.getID());
			System.out.println("������"+Employees.get(daka.getID()).getName());
			System.out.println("ǩ��ʱ�䣺"+sdf.format(daka.getDao()));
			if(daka.getTui() != null) {
			System.out.println("ǩ��ʱ�䣺"+sdf.format(daka.getTui()));
			}else {
				System.out.println("�޼�¼");
			}
		}
	}*/
	public void Shuchu() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("d:/��.txt");
			oos = new ObjectOutputStream(fos);
			Collection C = Records.keySet();
			Iterator It = C.iterator();
			while(It.hasNext()) {
				Employee e1 = (Employee)It.next();
				oos.writeObject(e1);
			}
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
		/*FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("d:/��.txt");
			ois = new ObjectInputStream(fis);
			Object e = null;
			while((e = ois.readObject()) != null) {
				Employee e2 = (Employee)e;
				Records.put(e2, e2.getDaka());
				}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
				e.getStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		}
		Collection c = Records.values();
		Iterator it = c.iterator();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try (FileWriter fw = new FileWriter("d:/Ա������Ϣ.txt")){
			while(it.hasNext()) {
				DakaInfo daka = (DakaInfo) it.next();
				fw.write("ID:"+daka.getID());
				fw.write("����:"+Employees.get(daka.getID()).getName());
				fw.write("\n");
				fw.write("ǩ��ʱ�䣺"+sdf.format(daka.getDao()));
				fw.write("\n");
				if(daka.getTui() != null) {
					fw.write("ǩ��ʱ�䣺"+sdf.format(daka.getTui()));
					fw.write("\n");
				}else {
					fw.write("ǩ��ʱ�䣺�޼�¼");
					fw.write("\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Chakan() throws IOException {
		FileReader fr = null;
		BufferedReader bfr = null;
		System.out.println(Records.size());
		try {
			fr = new FileReader("d:/Ա������Ϣ.txt");
			bfr = new BufferedReader(fr);
			String line;
			while((line = bfr.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fr.close();
			bfr.close();
		}
	}
	
}
