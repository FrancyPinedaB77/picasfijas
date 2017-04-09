package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Generador {

	private List<Integer> numerosDisponibles;
	
	private final Integer numerosAGenerar;
	
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