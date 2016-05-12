package me.polles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Teste {
	public static void main(String[] args){
		Cliente clOriginal = new Cliente();
		clOriginal.setId(1);
		clOriginal.setNome("Hugo");
		
		File file = new File("arquivo.dat");
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(clOriginal);
			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Foi!");
		
	}
}
