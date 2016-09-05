public class TailRecursion {

	public static void main(final String[] args) {
		System.out.println("Sum of A.P Series" + sumFromOneToN(5, 0));
		System.out.println("Sum of A.P Series" + sumFromOneToN(5));
	}

	public static int sumFromOneToN(final int n, final int a) {
		if (n < 1) {
			return a;
		}
		System.out.println("N : " + n + " A : " + a);
		final int ret = sumFromOneToN(n - 1, a + n);
		return ret;
	}

	public static int sumFromOneToN(int n) {
		int a = 0;
		while (n > 0) {
			a += n--;
		}
		System.out.println("N : " + n + " A : " + a);
		return a;
	}
}
