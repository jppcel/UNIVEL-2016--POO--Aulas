package me.polles;

public class SerializadorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7077874472909313223L;

	public SerializadorException(Exception e){
		super(e);
	}
	
	public SerializadorException(String string){
		super(string);
	}
	
	
}
