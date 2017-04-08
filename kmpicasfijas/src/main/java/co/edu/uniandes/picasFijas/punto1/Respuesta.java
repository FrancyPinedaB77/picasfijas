package co.edu.uniandes.picasFijas.punto1;

import java.util.HashMap;
import java.util.Map;

public class Respuesta {

	private Map<TipoRespuesta, Integer> aciertos;
	
	public Respuesta() {
		aciertos = new HashMap<>();
	}
	
	public void agregarAciertos(TipoRespuesta tipo, Integer cantidad){
		aciertos.put(tipo, cantidad);
	}
	
	public Map<TipoRespuesta, Integer> getAciertos(){
		return aciertos;
	}
}