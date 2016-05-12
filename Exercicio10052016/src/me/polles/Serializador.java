package me.polles;

import java.io.File;

public interface Serializador<T> {
	
	/**
	 * Verifica com reflection se t implementa serializable. Serializa o objeto
	 * no arquivo especificado.
	 * 
	 * SerializadorException deixa encapsulados os erros originais.
	 * 
	 * @param t
	 * @param file
	 */
	public void gravar(T t, File file) throws SerializadorException;
	
	/**
	 * Le o arquivo especificado e retorna o objeto de classe utilizada na
	 * instanciação do Serializador (T).
	 * 
	 * Antes de retornar verifica com reflection se a classe é correta.
	 * 
	 * @param file
	 * @return
	 */
	
	public T ler(File file) throws SerializadorException;

}
