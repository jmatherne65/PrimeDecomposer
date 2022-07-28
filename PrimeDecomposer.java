/**
 * A program to profile the prime decomposition and 
 * integer kernalization algorithms with respect to 
 * time.
 * @author Duncan, James Matherne
 * @see PrimeUtil - contains implementations for these 
 * algorithms and an auxiliary method.
 * <pre>
 * Date: 06/02/2022
 * Course: CSC 3102 Section 1
 * Instructor: Dr. Duncan
 * Project: 0
 * </pre>
 */
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrimeDecomposer
{
	public static void main(String[] args) 
	{	List <Integer> list = new ArrayList <Integer> ();
		ArrayList < Long > arrList2 = new ArrayList < Long > ();
		ArrayList < Long > arrList3 = new ArrayList < Long > ();
		ArrayList <String> arrList4 = new ArrayList <String> ();
		ArrayList < Long > arrList5 = new ArrayList < Long > ();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		long n = scan.nextLong();
		System.out.println("isPrime(" + n + ") = " + PrimeUtil.isPrime(n));
		System.out.println("rho(" + n + ") = " + PrimeUtil.radical(n));
		System.out.println(n + " = " + PrimeUtil.decompose(n));
		long generatedLong = new Random().nextLong();
		generatedLong = Math.abs(generatedLong);
		long startTime = System.nanoTime();
		PrimeUtil.radical(generatedLong);
		long endTime = System.nanoTime();
		long elapsedTimeRadical = endTime - startTime;
		System.out.println("rho(" + generatedLong + ") = " + PrimeUtil.radical(generatedLong));
		System.out.println("Kernelization Time: " + elapsedTimeRadical + " ns");
		startTime = System.nanoTime();
		PrimeUtil.decompose(generatedLong);
		endTime = System.nanoTime();
		long elapsedTimeDecompose = endTime - startTime;
		System.out.println(generatedLong + " = " + PrimeUtil.decompose(generatedLong));
		System.out.println("Decomposition Time: " + elapsedTimeDecompose + " ns");
		int[] myArr = {90, 97, 793, 797, 4719, 9533, 16731, 96517, 598950, 797161, 6410779, 9413779, 77437517, 87297210};
		for (int i = 0; i < myArr.length; i++){
			startTime = System.nanoTime();
			PrimeUtil.radical(myArr[i]);
			endTime = System.nanoTime();
			elapsedTimeRadical = endTime - startTime;
			startTime = System.nanoTime();
			PrimeUtil.decompose(myArr[i]);
			endTime = System.nanoTime();
			elapsedTimeDecompose = endTime - startTime;
			list.add(myArr[i]);
			arrList2.add(PrimeUtil.radical(myArr[i]));
			arrList3.add(elapsedTimeRadical);
			arrList4.add(PrimeUtil.decompose(myArr[i]));
			arrList5.add(elapsedTimeDecompose);
		}
		System.out.printf("%s %25s %20s %69s %16s",
				"n", "rho(n)", "Time(ns)", "Prime Decomposition", "Time(ns)");
		System.out.println();
		for (int j = 0; j < list.size(); j++ ) {
			System.out.format("%-20s %-20s %-20s %50s %20s",
					list.get(j), arrList2.get(j), arrList3.get(j), arrList4.get(j), arrList5.get(j));
			System.out.println();
		}
	}
}
