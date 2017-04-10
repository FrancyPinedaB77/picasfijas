package co.edu.uniandes.picasFijas.punto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
public class App {
	
	private App(){ }

	public static void main(String[] args) {
				
		KieServices kService = KieServices.Factory.get();
		KieContainer kContainer = kService.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		agregarASesion(kSession);
		kSession.fireAllRules();
		kSession.dispose();
	}

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