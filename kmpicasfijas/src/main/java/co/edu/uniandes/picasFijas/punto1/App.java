package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Clase principal de la aplicacion
 * @author Harry Wong, Francy Pineda, David Mera
 *
 */
public class App {
	
	private App(){ }

	public static void main(String[] args) {
				
		// Instrucciones del juego
		System.out.println("Instrucciones: \nPiense en un numero de 4 digitos\nSin repeticiones. Incluyendo el cero (0)");
				
		KieServices kService = KieServices.Factory.get();
		KieContainer kContainer = kService.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		agregarASesion(kSession);
		kSession.fireAllRules();
		kSession.dispose();
	}

	/**
	 * Inicia la base de hechos para disparar las reglas del juego
	 * @param kSession
	 */
	private static void agregarASesion(KieSession kSession) {
		
		Integer[] primerIntento = new Integer[]{1, 2, 3, 4};
		List<Integer[]> intentos = new ArrayList<>();
		intentos.add(primerIntento);
		List<Respuesta> respuestasHumano = new ArrayList<>();
		
		Generador generador = Generador.getInstance(4);
		Historial historial = new Historial(10, intentos, respuestasHumano);
		final Turno turno = new Turno(TipoTurno.MAQUINA);
	
		kSession.insert(generador);
		kSession.insert(historial);
		kSession.insert(turno);
		
	}
}