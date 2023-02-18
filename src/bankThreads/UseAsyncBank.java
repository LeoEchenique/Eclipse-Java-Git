package bankThreads;


import java.util.concurrent.locks.Condition;

/////////**************** But what if we NEED to make the operations even if the account has no money AT THE MOMENT? (because this program makes infinit transfer so eventually an account will have the money to make a past transaction
							//**** we need to implement await() method

/// ****************************  I believe that this lesson can be deprecated. because even being lock, the method  throws some 199999.9999999997 or 00000000000003 bullshit

import java.util.concurrent.locks.Lock; // in order to prevent the multipleThread error changing on the bank total we need to import this packages to create a ReentrantLock Object.
import java.util.concurrent.locks.ReentrantLock; // in order to prevent the multipleThread error changing on the bank total we need to import this packages to create a ReentrantLock Object.

// because the threads are not sync the "total money" is missing some values and gives wrong information
// concurrency= all this thread can be reading the same line, at the same time!
// all threads are execuyting simultaneously.

// when two or more threads in this scenario reads the same line a thread may read a line that has already been changed by another thread that went first. so the calculations there are wrong

// to prevent this, we can use a instance of Lock object to prevent a block of code of being execute by no more than 1 thread. Sweet!!!








/// UPPPPPPDAAAAAAAAAAAAATEEE===  synchronized keyword its not the best approach given that now we need to make the transfers as soon the account has the money

//  we do need the reentrantLock instance to provide more fine-grained hanbdle of the situation, but in that case we need to lock or unlock or await based on a condition: 
public class UseAsyncBank {
	
	static int calls=0;
	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			runTransfers running = new runTransfers(new Bank(), i, 2000);
			Thread t = new Thread(running);
			t.start();
		}
	}

}

class Bank {

	private final double[] cuentas;

	public Bank() {
		cuentas = new double[100];

		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}
		canMakeTransfer= avoidColide.newCondition(); // Before waiting on the condition the lock must be held by thecurrent thread.A call to Condition.await() will atomically release the lockbefore waiting and re-acquire the lock before the wait returns. 
		
		
	}

	public /*synchronized*/ void transferMoney(int origin, int destiny, double amount) throws InterruptedException {  // anything that executes the method needs to capture the error that throws this method

		avoidColide.lock(); // ---> now the attribute of the class will lock (in this case) ALL the method,
							// forcing to be executed by one thread at the time.

		try {
			while (cuentas[origin] < amount) { 		// before was an if that only break the exection, now is a while, so if X account cannot make a transfer, that thread its gonna AWAIT() untill notify to resume and ask again base on a new change
				System.out.println("NO MONEY, SLEEP MODE UNTILL YOU HAVE SOMETHING" + Thread.currentThread().getName() + "  " + origin);
				canMakeTransfer.await();
			}
				

			cuentas[origin] -= amount;

			System.out.println(Thread.currentThread().getName());
			System.out.printf("%10.2f of the account: %d FOR the account: %d totalMoneyBank ", amount, origin, destiny);
			cuentas[destiny] += amount;
			System.out.printf(" Total bank amount: %10.2f%n ",  getAllMoney());
			
			canMakeTransfer.signalAll(); // If any threads are waiting on this condition then they are all woken up. Each thread must re-acquire the lock before it can return from await. 
			
		} // with no catch because there's now error tb handled over here..
		finally {// finally, when things get done, unlock the method to allow another thread to
					// execute this block of code
			avoidColide.unlock();   // REPLACED BY "synchronized" KEYBOARD
		}

	}

	public double getAllMoney() {
		double allMoney = 0;
		for (double acc : cuentas) {
			allMoney += acc;
		}
		return allMoney;

	}

	private Lock avoidColide = new ReentrantLock(); // a new attribute of the class Bank
	
	private Condition canMakeTransfer; // condition to await or resume the thread in order to make a requested transfer as soon the account has the money
}

class runTransfers implements Runnable {

	private Bank bank;
	private final int moneyFrom;
	private double maxMoney;

	public runTransfers(Bank b, int moneyFrom, double moneyTbTransfer) {

		this.bank = b;
		this.moneyFrom = moneyFrom;
		this.maxMoney = moneyTbTransfer;
	}

	@Override
	public void run() {

		// to make infinit transactions we can use Ramdon numbers that transfer money to
		// a ramdon index of Cuentas instance
		try {
			while (true) {
				int toAccount = (int) (100 * Math.random());
				double amountTrasnfer = maxMoney * Math.random();
				bank.transferMoney(moneyFrom, toAccount, amountTrasnfer);

				Thread.sleep(500);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
