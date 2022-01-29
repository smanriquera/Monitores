
public class MonitorTrafico{
 private boolean busy = false;
 public synchronized void entrarN() {
	 while (busy)
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 busy = true;
 }
 
 public synchronized void entrarS() {
	 while (busy)
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 busy = true;
 }
 
 public synchronized void saleN() {
	 busy = false;
	 notifyAll();
 }
 public synchronized void saleS() {
	 busy = false;
	 notifyAll();
 }
}
