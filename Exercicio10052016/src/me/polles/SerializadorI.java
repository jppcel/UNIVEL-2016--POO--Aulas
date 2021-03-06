package me.polles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class SerializadorI<T> implements Serializador<T> {

	@Override
	public void gravar(T t, File file) throws SerializadorException {
		// TODO Auto-generated method stub
		
		// Pega todas as interfaces da classe
		Class<?>[] v = t.getClass().getInterfaces();
		
		// Passa por todas as classes e verifica se alguma foi serializada
		boolean a = false;
		for(Class<?> c : v){
			if(c.equals(Serializable.class)){
				a = true;
				break;
			}
		}
		
		// Senão tiver classe serializada, lança um SerializadorException...
		if(!a){
			throw new SerializadorException("Classe não implementa serializable.");
		}
		
		// Try fazendo o trabalho sujo... e se der Exception, manda para o SerializadorException...
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(t);
			
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SerializadorException(e);
		} 
	}

	@SuppressWarnings("unchecked")
	@Override
	public T ler(File file) throws SerializadorException {
		// TODO Auto-generated method stub
		
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Object obj = ois.readObject();
			
			Class<?> clGenType = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			
			if(!obj.getClass().equals(clGenType)){
				throw new SerializadorException("Os tipos são diferentes!");
			}
			
			return (T) obj;
			
		}catch(Exception e){
			throw new SerializadorException(e);
		}
	}

}
