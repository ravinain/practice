public class MathTest {
	public static void main(final String[] args) {
		// This will print 11, nearest max integer
		System.out.println(Math.round(10.55));

		// This will print 10, least number
		System.out.println(Math.floor(10.99));

		double ad = 10.22;
		System.out.println("_________________");
		for (int counter = 0; counter < 5; counter++) {
			// This will print next adjacent floating point number in direction
			// of second parameter value. 10.22 will get next floating number
			// towards 10.24
			// once reached the 10.24 afterwards it won't change.
			ad = Math.nextAfter(ad, 10.24);
			System.out.println(ad);
		}
		System.out.println("_________________");
		for (int counter = 0; counter < 5; counter++) {
			// This will print next adjacent floating point number in direction
			// of second parameter value. 10.22 will get next floating number
			// towards 10.21
			// once reached the 10.21 afterwards it won't change.
			ad = Math.nextAfter(ad, 10.21);
			System.out.println(ad);
		}
		double nup = 10.22;
		for (int counter = 0; counter < 5; counter++) {
			// This is similar to Math.nextAfter, the only difference it has
			// only one direction which is positive infinity.
			nup = Math.nextUp(nup);
			System.out.println(nup);
		}

		// rint display the integer/long value of input parameter. It returns
		// the nearest integer value. If there are two nearest integer then it
		// will display even number. See first statement for example. 10.5 which
		// has two integer values 10 and 11 so it is displaying 10 and for
		// second statement it will display 12.
		System.out.println(Math.rint(10.5));
		System.out.println(Math.rint(11.5));
		System.out.println(Math.rint(11.3));

	}

}
