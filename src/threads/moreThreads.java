package threads;

import EmpleadosOOP.Empleado;

public class moreThreads {

	public static void main(String[] args) {

		MultipleThreads thread1= new MultipleThreads();
		MultipleThreads thread2= new MultipleThreads();				// many instances, the execution it's arbitrary.  Depends on the OS or hardware
		MultipleThreads thread3= new MultipleThreads();
		Empleado leo= new Empleado("Leo");
		thread1.start();		// thread1 doesnt wait to finish to start running the for of thread2 or thread3, its all arbitrary
		System.out.println("hi! Im one line below thread1 start method");
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(leo.getInfo());
		System.out.println("hi! Im waiting to thread1 to finish, you will see me when it's over, cascade execution!!");
		
		//  both thread2 and thread3 will be executed in async order
		thread2.start();
		thread3.start();
		System.out.println(leo.getInfo() + "\n whoops, this went above both thread2 and thread3");
	}

}


class MultipleThreads extends Thread{
	
	public void run() {
		
		for(int i=0; i<5; i++) {
			System.out.println("Thread number: " + getName()); // name of thread
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
