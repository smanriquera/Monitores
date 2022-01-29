import java.util.Random;

public class CocheS  extends Thread{
	
	private enum STATE{ESPERANDOS,CRUZARS,CRUZANDOS};
	private STATE state;
	private String nombre;
	private MonitorTrafico monitor;
	private int vecesCruzado = 0;
	
	public CocheS(String n, MonitorTrafico m) {
		nombre = n;
		state = STATE.ESPERANDOS;
		monitor = m;
		start();
	}
	

	private void esperaS() {
		System.out.println(nombre+" espera en la entrada Sur.");
		
		Random rnd = new Random();
		int waitingTime = rnd.nextInt(250 - 50 + 1) +50;
		
		try {
			sleep(waitingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre+" deja de esperar.");
		
		state = STATE.CRUZARS;
		
	}
	

	private void cruzarS() {
		System.out.println(nombre + " quiere cruzar y va al puente Sur a ver si hay sitio.");
		monitor.entrarS();
		
		//el coche tiene el puente libre y puede empezar a cruzar
		state= STATE.CRUZANDOS;
		
	}


	private void cruzandoS() {
		System.out.println(nombre +" Empieza a cruzar de Sur a Norte. ");
		
		Random rnd = new Random();
		int crossTime = rnd.nextInt(250 -50 +1) + 50;
		
		try {
			sleep(crossTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vecesCruzado++;
		System.out.println(nombre+" termina de cruzar de Sur a Norte. Veces Cruzado:" +vecesCruzado);
		monitor.saleS();
		state = STATE.ESPERANDOS;		
	}
	
	
	@Override
	public void run() {
		while(true) {
			switch(state) {
			
			case ESPERANDOS:
				esperaS();
				break;
				
			
			case CRUZARS:
				cruzarS();
				break;
				
			
			case CRUZANDOS:
				cruzandoS();
				break;
				
			}
		}
	}
}
