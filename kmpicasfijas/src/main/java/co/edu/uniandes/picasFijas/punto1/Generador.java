package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Generador {

	private List<Integer> numerosDisponibles;
	
	private final Integer numerosAGenerar;
	
	private final Integer[] auxiliar={10,10,10,10};
	
	private static Generador instance = null;
	
	private Generador(Integer numerosAGenerar){
		numerosDisponibles = IntStream.range(0, 10).boxed().collect(Collectors.toList());
		this.numerosAGenerar = numerosAGenerar;
	}
	
	public static Generador getInstance(Integer numeroAGenerar){
		if(instance == null){
			instance = new Generador(numeroAGenerar);
		}
		return instance;
	}
	
	public boolean quitarNumeroLista(Integer numero){
		return numerosDisponibles.remove(numero);
	}
	
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
	

	public Integer[] getauxiliar(){ //ponerlo como metodo
		Integer[] auxiliar= new Integer[4];// PENDIENTE CAMBIAR EL NUMERO
		 for (int j = auxiliar.length - 1; j > 0; j--) {
		        int temp = auxiliar[j];
		        auxiliar[j] = auxiliar[j - 1];
		        auxiliar[j - 1] = temp;
		        }
		return auxiliar;
	}
	
	
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