import java.util.Random;

public class CocheN  extends Thread{
	
	private enum STATE{CRUZARN,CRUZANDON, ESPERANDON};
	private STATE state;
	private String nombre;
	private MonitorTrafico monitor;
	private int vecesCruzado = 0;
	
	public CocheN(String n, MonitorTrafico m) {
		nombre = n;
		state = STATE.ESPERANDON;
		monitor = m;
		start();
	}
	
	private void esperaN() {
		System.out.println(nombre+" espera en la entrada Norte.");
		
		Random rnd = new Random();
		int waitingTime = rnd.nextInt(250 - 50 + 1) +50;
		
		try {
			sleep(waitingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre+"  deja de esperar.");
		
		state = STATE.CRUZARN;
		
	}

	
	private void cruzarN() {
		System.out.println(nombre + " quiere cruzar y va al puente Norte a ver si hay sitio.");
		monitor.entrarN();
		
		//el coche tiene el puente libre y puede empezar a cruzar
		state= STATE.CRUZANDON;
		
	}


	private void cruzandoN() {
		System.out.println(nombre +" Empieza a cruzar de Norte a Sur. ");
		
		Random rnd = new Random();
		int crossTime = rnd.nextInt(250 -50 +1) + 50;
		
		try {
			sleep(crossTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vecesCruzado++;
		System.out.println(nombre+" termina de cruzar de Norte a Sur. Veces Cruzado:" +vecesCruzado);
		monitor.saleN();
		state = STATE.ESPERANDON;		
	}

	
	
	@Override
	public void run() {
		while(true) {
			switch(state) {
			case ESPERANDON:
				esperaN();
				break;
		
			case CRUZARN:
				cruzarN();
				break;
				
			
			case CRUZANDON:
				cruzandoN();
				break;
				
			}
		}
	}
}
