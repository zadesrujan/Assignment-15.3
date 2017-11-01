package lock;

public class ClassB {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//Creating object of thread 
		  Thread t1 = new Thread(new Runnable() {
			  //run method
		    public void run() {
		    	//Invoking the run() method from main thread, the run() method goes 
		    	//onto the current call stack rather than at the beginning of a new call stack.
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
          //Creating object of Thread
		  Thread t2 = new Thread(new Runnable() {
		    public void run() {
		      synchronized (String.class) {
		        System.out.println("Aquired lock on String.class object: Thread2 ");
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Sleep for 5 seconds
		        synchronized (Integer.class) {
		          System.out.println("Aquired lock on Integer.class object:Thread2");
		        }
		      }
		    }
		  });

		  t1.start();
		  t2.start();
	}

	}

