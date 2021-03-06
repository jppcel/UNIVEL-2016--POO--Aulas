package me.polles;

import java.io.File;

public class TesteSerializador {
	public static void main(String[] args){
		
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("José");

		File file = new File("arquivo1.dat");
		File file2 = new File("arquivo2.dat");
		SerializadorI<Cliente> s = new SerializadorI<Cliente>(){};
		try{
			s.gravar(c, file);
			
			Cliente cl = s.ler(file2);
			
			System.out.println(cl.getId());
			System.out.println(cl.getNome());
			
		}catch(SerializadorException e){
			e.printStackTrace();
		}
	}
}
