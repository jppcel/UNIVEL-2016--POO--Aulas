package me.polles;

import java.io.File;

public class Teste {
	public static void main(String[] args){
		SerializadorCliente<Cliente> SC = new SerializadorCliente<Cliente>();
		
		Cliente c = new Cliente();
		c.setId(1);
		c.setNome("Fulano");
		
		File file = new File("cliente.dat");
		
		try {
			SC.gravar(c, file);
		} catch (SerializadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
