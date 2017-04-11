
package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;

/**
* Permite llevar registro de las jugadas,
* almacenando los numeros generados por el programa
* y las respuestas del usuario en cada una de ellas
*
* @author  Francy Pineda, Harry Wong, David MEra
* @version 1.0
* @since   2017-04-01 
*/
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
	
	/**
	 * <p>
	 * Permite verificar si el programa no ha excedido
	 * la restriccion de intentos disponibles para adivinar
	 * el numero del usuario
	 * </p>
	 * @return Verdadero si aun es posible generar un nuevo numero sin exceder la restriccion de intentos, de lo contrario, false
	 */
	private boolean tengoIntentosDisponibles(){
		return intentosDisponibles >= numerosGenerados.size();
	}
	
	/**
	 * Verifica si el numero generado ya fue utilizado en una jugada anterior
	 * @param numero2 numero generado para el intento
	 * @return Verdadero si el numero no fue utilizado antes, de lo contrario false
	 */
	private boolean yaGenereEsteNumero(Integer[] numero2){
		return numerosGenerados.stream().filter(numero -> numero[0] == numero2[0]
				&& numero[1] == numero2[1] 
				&& numero[2] == numero2[2]
				&& numero[3] == numero2[3]).findFirst().isPresent();
	}	
}