package co.edu.uniandes.picasFijas.punto1;

/**
 * Representa la interaccion de la maquina
 * o del jugador. Cada turno es analizado por
 * el motor de inferencia para determinar que regla
 * activar o si el juego ha finalizado
 * @author David Mera, Francy Pineda, Harry Wong
 *
 */
public class Turno {

	private TipoTurno turno; 
	
	public Turno(){ }

	public Turno(TipoTurno turno) {
		this.turno = turno;
	}

	public TipoTurno getTurno() {
		return turno;
	}

	public void setTurno(TipoTurno turno) {
		this.turno = turno;
	}	
}