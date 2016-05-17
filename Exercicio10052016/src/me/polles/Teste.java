package me.polles;

import java.io.File;

public class Teste {
	public static void main(String[] args){
		SerializadorI<Cliente> SC = new SerializadorI<Cliente>();
		
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("Fulano");
		
		File file = new File("cliente.dat");
		
		try {
			SC.gravar(c, file);
			System.out.println("Foi...");
		} catch (SerializadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
