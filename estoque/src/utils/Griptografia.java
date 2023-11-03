package utils;
import java.util.Base64;

public class Griptografia {

	
	public String griptografar(String texto) {
		
		String encod = Base64.getEncoder().encodeToString(texto.getBytes());
		
		return encod;
		
	}
	
	public String deserializa(String texto) {
		
		String encod = new String(Base64.getDecoder().decode(texto));
		return encod;
	}
}
