package me.polles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TesteLeitura {
	
	public static void main(String[] args){
		String xml = null;
		JAXBContext context;
		try {
			FileReader fr = new FileReader("arq.xml");
			BufferedReader br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null){
				sb.append(line).append("\n");
			}
			xml = sb.toString();
			
			br.close();
			fr.close();
			
			StringReader in = new StringReader(xml);
		
			context = JAXBContext.newInstance(Cliente.class);
			Unmarshaller unmarchaller = context.createUnmarshaller();
			Cliente cli = (Cliente) unmarchaller.unmarshal(in);
			
			System.out.println(cli.getId());
			System.out.println(cli.getNome());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
