package tesPkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Account1 acc1 = new Account1();
		FileOutputStream fos = new FileOutputStream("testFile.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(acc1);
		
		FileInputStream fis = new FileInputStream("testFile.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Account1 acc2=(Account1)ois.readObject();
		System.out.println(acc2.pwd+":::::"+acc2.username);
		
	}
	
}

class Account1 implements Serializable{
	String username="user1";
	transient String pwd="pswd1";
	
	private void writeObject(ObjectOutputStream oos)throws Exception{
		oos.defaultWriteObject();
		String epwd="145"+pwd;
		oos.writeObject(epwd);
	}

	private void readObject(ObjectInputStream ois) throws Exception{
		ois.defaultReadObject();
		String epwd=(String)ois.readObject();
		this.pwd=epwd.substring(3);
	}
}
