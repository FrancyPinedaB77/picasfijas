/**
* Historial lleva cuenta de las respuestas del jugador.
* En este contexto el jugador es el humano.
*
* @author  Grupo X
* @version 1.0
* @since   2017-04-01 
*/
package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;

public class Historial {

	private final int intentosDisponibles;
	private List<Integer[]> numerosGenerados;
	private List<Respuesta> respuestasHumano; 
	
	public Historial(int intentosDisponibles){
		this.intentosDisponibles = intentosDisponibles;
		this.numerosGenerados = new ArrayList<>();
		this.respuestasHumano = new ArrayList<>();
	}
	
	public int getIntentosDisponibles(){
		return intentosDisponibles;
	}
	
	public List<Integer[]> getNumerosGenerados() {
		return numerosGenerados;
	}

	public List<Respuesta> getRespuestasHumano() {
		return respuestasHumano;
	}

	public Historial(int intentosDisponibles, List<Integer[]> intentos, List<Respuesta> respuestas){
		this.intentosDisponibles = intentosDisponibles;
		this.respuestasHumano = respuestas;
		this.numerosGenerados = intentos;
	}
	
	public boolean agregarNumero(Integer[] intento){
		if(tengoIntentosDisponibles() && !yaGenereEsteNumero(intento)){
			return numerosGenerados.add(intento);
		}
		return false;
	}
	
	public void agregarRespuestaHumano(Respuesta ultimaRespuesta){
		respuestasHumano.add(ultimaRespuesta);
	}
	
	private boolean tengoIntentosDisponibles(){
		return intentosDisponibles >= numerosGenerados.size();
	}
	
	private boolean yaGenereEsteNumero(Integer[] numero2){
		return numerosGenerados.stream().filter(numero -> numero[0] == numero2[0]
				&& numero[1] == numero2[1] 
				&& numero[2] == numero2[2]
				&& numero[3] == numero2[3]).findFirst().isPresent();
	}	
}