package co.edu.uniandes.picasFijas.punto1;

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