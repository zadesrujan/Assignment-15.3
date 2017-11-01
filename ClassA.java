package lock;


//Creating a classA
public class ClassA {

  //Main method
	public static void main(String[] args) {
		
		//Creating object of thread 
		  Thread t1 = new Thread(new Runnable() {
			  //run method
		    public void run() {
//Invoking the run() method from main thread, the run() method goes 
//onto the current call stack rather than at the beginning of a new call stack
	 //declared required variables
		 // Using synchronizing block and locking String class
		      synchronized (String.class) {
		        System.out.println("Aquired lock on String.class object :Thread1");
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Calling Sleep method to sleep for 5 seconds
		     // Using synchronizing block and locking Integer class
		        synchronized (Integer.class) {
		          System.out.println("Aquired lock on Integer.class object:Thread1");
		        }
		      }
		    }
		  });

		  Thread t2 = new Thread(new Runnable() {
		    public void run() {
		      synchronized (Integer.class) {
		        System.out.println("Aquired lock on Integer.class object: Thread2 ");
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Sleep for 5 seconds
		        synchronized (String.class) {
		          System.out.println("Aquired lock on String.class objec :Thread2");
		        }
		      }
		    }
		  });

		  t1.start();//start() method causes this thread to begin execution
		  t2.start();
	}
}
//Aquired lock on String.class object :Thread1
//Aquired lock on String.class object: Thread2 and then DeadLock Happens
