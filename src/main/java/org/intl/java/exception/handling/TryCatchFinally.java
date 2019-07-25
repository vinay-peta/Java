package org.intl.java.exception.handling;

/**
 * Finally block will get executed even if we return in try/catch block
 * 
 * 
 * @author U6062618
 *
 */
public class TryCatchFinally {

	public static void main(String[] a) {
		TryCatchFinally obj = new TryCatchFinally();
		System.out.println(obj.returnInTCF());
		System.out.println("----------------------");
		System.out.println(obj.errorInCatch());
		System.out.println("----------------------");
	}

	/**
	 * what happens when return is there in try/catch/finally - returns what ever is there in finally
	 * + adding return at end of the method - unreachable if return is there in catch/finally
	 * 
	 * @return
	 */
	public int returnInTCF() {
		try {
			System.out.println(10 / 0);
			return -1;
		} catch (ArithmeticException e) {
			System.out.println(e);
			return -2;
		} finally {
			System.out.println("In finally block");
			return -3;
		}
		//return -4;
	}
	
	/**
	 * If error in catch.. it still executes finally
	 * @return
	 */
	public int errorInCatch() {
		try {
			System.out.println("In try");
			System.out.println(10 / 0);
			return -1;
		} catch (ArithmeticException e) {
			System.out.println("In catch");
			System.out.println(10/0);
			return -2;
		} finally {
			System.out.println("In finally block");
			return -3; // comment this and try
		}
	}
}