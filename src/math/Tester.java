package math;

import math.arithmetic.Arithmetic;

public class Tester {


    public static void main(String[] args) {
        Arithmetic.launchCompleteLinearPropagationForGCD(60, 35);
    }

    private static void testEuclidAlgorithm(){
        Arithmetic.launchCompleteLinearPropagationForGCD(16, 25);
        Arithmetic.launchCompleteLinearPropagationForGCD(16, 16);
        Arithmetic.launchCompleteLinearPropagationForGCD(50, 25);
        Arithmetic.launchCompleteLinearPropagationForGCD(30, 65);
        Arithmetic.launchCompleteLinearPropagationForGCD(100, 6);
        Arithmetic.launchCompleteLinearPropagationForGCD(1_587_645,6_755);
    }

    private static void testAll(){
        System.out.println(Arithmetic.sum(1,2,3,4,5,6,7,8,9,10));
        System.out.println(Arithmetic.product(4,5,6,7,8));
        System.out.println(Arithmetic.isDivisible(35, 5));
        System.out.println(Arithmetic.isEven(9_990));
        System.out.println(Arithmetic.isOdd(45));
        System.out.println(Arithmetic.isPrime(2_017));
        System.out.println(Arithmetic.isComposite(212));
        System.out.println(Arithmetic.generatePrimes(1,25));
        System.out.println(Arithmetic.factorialOf(10));
        System.out.println(Arithmetic.sumOfTerms(1,10));
        System.out.println(Arithmetic.sumOfTerms(1,100,5));
        System.out.println(Arithmetic.firstNTerms(20));
        System.out.println(Arithmetic.allFactorsOf(100));
        System.out.println(Arithmetic.primeFactorsOf(100));
        System.out.println(Arithmetic.lcmOf(30, 40));
        System.out.println(Arithmetic.gcdOf(1_587_645, 6_755));
        System.out.println(Arithmetic.areCoPrimes(25, 37));
        System.out.println(Arithmetic.linearCombinationOf(100, 33));
        Arithmetic.launchEuclidAlgorithmForGCD(1_587_645,6_755);
        System.out.println(Arithmetic.eulerPhiOf(2_016));

        final int[] a = {3, 65, Arithmetic.eulerPhiOf(10), 21, 88, 100, 67, 110};
        System.out.println(Arithmetic.maxOf(a));
        System.out.println(Arithmetic.minOf(a));
        System.out.println(Arithmetic.generatePrimes(0,100));
        System.out.println(Arithmetic.eulerPhiOf(100));
    }

}
