package me.polles;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class SerializadorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8158036941627626364L;

	public SerializadorException(FileNotFoundException e){
		
	}
	
	public SerializadorException(IOException e){
		
	}
	
	public SerializadorException(ClassNotFoundException e){
		
	}
	
	
}