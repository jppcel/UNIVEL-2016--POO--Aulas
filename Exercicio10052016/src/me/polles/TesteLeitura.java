package me.polles;

import java.io.File;

public class TesteLeitura {
	public static void main(String[] args){
		SerializadorCliente<Cliente> SC = new SerializadorCliente<Cliente>();
		
		Cliente c;
		
		File file = new File("cliente.dat");
		
		try {
			c =  SC.ler(file);
			System.out.println(c.getId());
			System.out.println(c.getNome());
		} catch (SerializadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
