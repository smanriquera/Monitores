

public class Sistema {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonitorTrafico monitor = new MonitorTrafico();
		
		
		//Coches
		new CocheN("Coche Rojo",monitor);
		new CocheN("Coche Verde",monitor);
		new CocheN("Coche Azul",monitor);
		new CocheS("Coche Amarillo",monitor);
		new CocheS("Coche Negro",monitor);
		new CocheS("Coche Blanco",monitor);
	}

}
