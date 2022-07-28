import static java.lang.Math.sqrt;

/**
 * Implementation for three number theoretic methods for
 * prime number related functions
 * @author Duncan, James Matherne
 * <pre>
 * Date: 06/02/2022
 * Course: CSC 3102 Section 1
 * Instructor: Dr. Duncan
 * Project: 0
 * </pre>
 */

public class PrimeUtil {
	/**
	 * Counts the number of times one number is a factor of another
	 *
	 * @param num    a number
	 * @param factor a number whose factor count is to be determined
	 * @return the multiplicity (count) of the number of times factor
	 * is a factor of num. If factor is not a factor of num, 0 is
	 * returned.
	 */
	private static long factorCount(long num, long factor) {
		int i = 1;
		long count = 1;
		if (factor > 0 && num % factor == 0) {
			while (num % factor == 0) {
				num = (num / factor);
				count++;
				i++;
				if (num % factor != 0) {
					count--;
					break;
				}
			}
			return count;
		} else {
			return 0;
		}
	}

	/**
	 * Determine whether the specified number is prime
	 *
	 * @param num a number whose primality is to be determined
	 * @return true if the specified number is prime; otherwise,
	 * false
	 */
	public static boolean isPrime(long num) {
		boolean prime;

		if (num < 2) {
			prime = false;
		} else if (num == 2) {
			prime = true;
		} else if (num % 2 == 0) {
			prime = false;
		} else {
			prime = true;
			int i = 3;
			while (prime == true && i <= sqrt(num)) {
				if (num % i == 0) {
					prime = false;
				}
				i++;
			}
		}
		return prime;
	}

	/**
	 * Computes the radical, product of the distinct prime factors,
	 * of a number.
	 *
	 * @param num a number whose radical is to be determined.
	 * @return the radical of the specified number or 0 if the
	 * number is less than 2
	 */
	public static long radical(long num) {
		double i = 2;
		double rho1 = 1;
		double residual1 = num;
		if (residual1 < 2) {
			return 0;
		} else {
			while (i <= sqrt(residual1)) {
				if (residual1 % i == 0) {
					double j = 1;
					while (residual1 % Math.pow(i, j) == 0) {
						j++;
						if (residual1 % Math.pow(i, j) != 0) {
							j--;
							break;
						}
					}
					double primary = Math.pow(i, j);
					residual1 = residual1 / primary;
					rho1 = rho1 * i;
				}
				i++;
			}
		}
		long rho = (long) rho1;
		long residual = (long) residual1;
		return residual * rho;
	}

	/**
	 * Gives the prime decomposition of the specified number
	 *
	 * @return a string representation of the prime decomposition of
	 * the specified number or "NAN" if the specified number is less
	 * than 2
	 */
	public static String decompose(long num) {
		String factorization;
		double num1 = num;
		if (num1 < 2) {
			factorization = "NAN";
		} else {
			double i = 2;
			while (i < sqrt(num) && num % i != 0) {
				i++;
			}
			if (i > sqrt(num)) {
				factorization = String.valueOf(num);
			} else {
				double alpha = factorCount((long) num1, (long) i);
				factorization = ((int)i + "^" + (int)alpha);
				num1 = num1 / Math.pow(i, alpha);
				while (num1 > 1) {
					i++;
					while (i < sqrt(num1) && num1 % i != 0) {
						i++;
					}
					if (i > sqrt(num1)) {
						factorization = (factorization + " x " + (int)num1);
						num1 = 1;
					} else {
						alpha = factorCount((long) num1, (long) i);
						factorization = (factorization + " x " + (int)i + "^" + (int)alpha);
						num1 = (long) num1 / (long) (Math.pow(i, alpha));
					}
				}
			}
		}
		return factorization;
	}
}
