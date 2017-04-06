package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;

public class ContadorIntentos {

	private final int intentosDisponibles;
	private List<Integer[]> intentos;
	
	public ContadorIntentos(int intentosDisponibles){
		this.intentosDisponibles = intentosDisponibles;
		this.intentos = new ArrayList<>();
	}
	
	public ContadorIntentos(int intentosDisponibles, List<Integer[]> intentos){
		this.intentosDisponibles = intentosDisponibles;
		this.intentos = intentos;
	}
	
	public boolean agregarIntento(Integer[] intento){
		if(intentosDisponibles >= intentos.size()){
			return intentos.add(intento);
		}
		return false;
	}

	public int getIntentosDisponibles() {
		return intentosDisponibles;
	}

	public List<Integer[]> getIntentos() {
		return intentos;
	}
	
}