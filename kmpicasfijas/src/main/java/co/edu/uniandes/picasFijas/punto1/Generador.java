package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
* Generador crea numeros de 4-digitos compuestos
* con los digitos permitidos o disponibles.
*
* @author  Francy Pineda, Harry Wond, David Mera
* @version 1.0
* @since   2017-04-01 
*/
public final class Generador {

	private List<Integer> numerosDisponibles;
	
	private final Integer numerosAGenerar;
	
	private static Generador instance = null;
	
	private Generador(Integer numerosAGenerar){
		// Inicia la lista de digitos disponibles 0, 1, 2,.. 9
		numerosDisponibles = IntStream.range(0, 10).boxed().collect(Collectors.toList());
		this.numerosAGenerar = numerosAGenerar;
	}
	
	/**
	 * Patron singleton, solo hay un generador para todo el juego
	 * @param numerosAGenerar Cantidad total de cifras a usar para generar un numero en cada intento
	 * @return
	 */
	public static Generador getInstance(Integer numerosAGenerar){
		if(instance == null){
			instance = new Generador(numerosAGenerar);
		}
		return instance;
	}
	
	/**
	 * Permite descartar un digito de la lista de números diponibles
	 * @param numero Digito que no será tenido en cuenta para las siguientes jugadas
	 * @return
	 */
	public boolean quitarNumeroLista(Integer numero){
		return numerosDisponibles.remove(numero);
	}
	
	/**
	 * Permite generar un numero de cuatro digitos unicos 
	 * @return Arreglo con los digitos que componen el numero generado
	 */
	public Integer[] generar(){
		List<Integer> numeroGenerado = new ArrayList<>();
		for(int i = 1; i <= numerosAGenerar; ){
			int indice = new Random().nextInt(numerosDisponibles.size());
			Integer numeroAleatorio = numerosDisponibles.get(indice);
			if(!numeroGenerado.contains(numeroAleatorio)){
				numeroGenerado.add(numeroAleatorio);
				i++;
			}
		}
		return numeroGenerado.toArray(new Integer[numeroGenerado.size()]);
	}
	
//
//	public Integer[] getauxiliar(){ //ponerlo como metodo
//		Integer[] auxiliar= new Integer[4];// PENDIENTE CAMBIAR EL NUMERO
//		 for (int j = auxiliar.length - 1; j > 0; j--) {
//		        int temp = auxiliar[j];
//		        auxiliar[j] = auxiliar[j - 1];
//		        auxiliar[j - 1] = temp;
//		        }
//		return auxiliar;
//	}
//	
	
	public Integer getNumerosAGenerar(){
		return numerosAGenerar;
	}
	
	public List<Integer> getNumerosDisponibles(){
		return numerosDisponibles;
	}
	
	public void setNumerosDisponibles(List<Integer> numeros){
		this.numerosDisponibles = numeros;
	}
}