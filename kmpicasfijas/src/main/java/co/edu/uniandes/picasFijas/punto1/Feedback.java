package co.edu.uniandes.picasFijas.punto1;

public class Feedback {

	private int aciertos;
	private TipoFeedback tipoFeedback;
	
	public Feedback(int aciertos, TipoFeedback feedback){
		this.aciertos = aciertos;
		this.tipoFeedback = feedback;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public TipoFeedback getTipoFeedback() {
		return tipoFeedback;
	}

	public void setTipoFeedback(TipoFeedback feedback) {
		this.tipoFeedback = feedback;
	}
}