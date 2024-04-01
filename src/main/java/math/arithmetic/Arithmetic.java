package math.arithmetic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This class and the operations defined are usually on Integers only
 */
public class Arithmetic {

    public static void main(String[] args) {
        launchEuclidAlgorithmForGCD(1_587_645,6_755);
    }

    public static int sum(int ... ints){
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }

        return sum;
    }

    public static int product(int ... ints){
        if (ints.length == 0) {
            return 0;
        }

        int product = 1;
        for (int i : ints) {
            product *= i;
        }

        return product;
    }

    public static boolean isDivisible(int number, int divisor){
        return number % divisor == 0;
    }

    public static boolean isEven(int n){
        return isDivisible(n, 2);
    }

    public static boolean isOdd(int n){
        return !isEven(n);
    }

    public static boolean isPrime(int p){
        if (p == 2) {
            return true;
        } else if (p == 1 || isEven(p)) {
            return false;
        }

        final int floorRoot = (int) Math.floor(Math.sqrt(p));
        for (int i = 3; i <= floorRoot; i++) {
            if (isDivisible(p, i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isComposite(int n){
        return !isPrime(n);
    }

    public static List<Integer> generatePrimes(int from, int to){
        assertPositivity(to - from, "Unacceptable / unordered interval: "+from+" to "+to);
        final List<Integer> list = new ArrayList<>();
        if (from <= 2 && to >= 2) {
            list.add(2);
        }
        for (int i = isOdd(from) ? from : from + 1; i <= to; i += 2) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private static void assertPositivity(int n, String alt){
        if (n <= 0){
            throw new IllegalArgumentException(alt);
        }
    }

    public static int factorialOf(int n){
        assertPositivity(n, "Factorial of a negative integer "+n);
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorialOf(n - 1);
    }

    public static int sumOfTerms(int from, int to, int step){
        assertPositivity(to - from, "Illegal summation interval: from "+from+" to "+to);
        int sum = 0;
        for (int i = from; i <= to; i += step) {
            sum += i;
        }

        return sum;
    }

    // step-sizing is 1, by default
    public static int sumOfTerms(int from, int to){
        return (from == 0 || from == 1) ? firstNTerms(to) : sumOfTerms(from, to, 1);
    }

    public static int firstNTerms(int n){
        return n * (n + 1) / 2;
    }

    public static List<Integer> allFactorsOf(int n){
        n = Math.abs(n);
        final List<Integer> factors = new ArrayList<>();

        if (isPrime(n)) {
            factors.add(1);
            factors.add(n);
        } else {
            for (int i = 1; i <= n; i++) {
                if (isDivisible(n, i)) {
                    factors.add(i);
                }
            }
        }

        return factors;
    }

    public static List<Integer> primeFactorsOf(int n){
        assertPositivity(n, "Prime factorization on a negative integer "+n);
        final List<Integer> primeFactors = new ArrayList<>();
        if (isPrime(n)) {
            primeFactors.add(n);
            return primeFactors;
        }

        final List<Integer> possiblePrimes = generatePrimes(0,n);
        int flexing = n;
        for (int i = 0; i < possiblePrimes.size(); i++) {
            if (isDivisible(flexing, possiblePrimes.get(i))) {
                primeFactors.add(possiblePrimes.get(i));
                flexing /= possiblePrimes.get(i);
                i--;
            }
        }

        return primeFactors;
    }

    public static int lcmOf(int num1, int num2){
        if (num1 == 0 || num2 == 0) {
            throw new IllegalArgumentException("Lcm of zero and a number");
        }

        int a = Math.min(num1, num2);
        int b = Math.max(num1, num2);

        int t = b;
        while (!isDivisible(t, a)) {
            t += b;
        }

        return t;
    }

    public static int gcdOf(int n1, int n2){
        if (n1 == 0) {
            return n2;
        } else if (n2 == 0) {
            return n1;
        }

        final List<Integer> allMinimunFactors = allFactorsOf(Math.min(n1,n2));
        for (int i = allMinimunFactors.size() - 1; i >= 0; i--) {
            if (isDivisible(Math.max(n1, n2), allMinimunFactors.get(i))) {
                return allMinimunFactors.get(i);
            }
        }
        throw new UnknownError("Unexpected error occurred for determining the gcd of "+n1+" & "+n2);
    }

    public static boolean areCoPrimes(int p1, int p2){
        return gcdOf(p1, p2) == 1;
    }

    /**
     * The linear combination of 'n' with respect to 'd' as the divisor.
     * This is based on the Euclid's Division Theorem: n = d(q) + r
     */
    public static String linearCombinationOf(int n, int d){
        int q = n / d;
        int r = n - (d * q);

        return n+" = "+d+"("+q+") + "+r;
    }

    /**
     * Finds the gcd using Euclid's Algorithm
     */
    public static void launchEuclidAlgorithmForGCD(int a, int b) {
        int number = Math.max(a, b);
        int divisor = Math.min(a, b);
        int quot = number / divisor;
        int rem = number - (divisor * quot);
        while (rem != 0) {
            System.out.println(number+" = "+divisor+"("+quot+") + "+rem);
            number = divisor;
            divisor = rem;
            quot = number / divisor;
            rem = number - (divisor * quot);
        }
        System.out.println(number+" = "+divisor+"("+quot+") + "+rem);
        System.out.println(" \u2234 gcd("+a+", "+b+") = "+divisor);
    }

    /**
     * Finds the gcd using Euclid's Algorithm and continues to get the linear propagation as well
     */
    public static void launchCompleteLinearPropagationForGCD(int a, int b){
        class CombinationEquation {//n = d(q) + r
            int number, divisor, quot, rem;

            private CombinationEquation(int n, int d, int q, int r){
                number = n;
                divisor = d;
                quot = q;
                rem = r;
            }

            private String getValue(){//n - d(q)
                return number+" - "+divisor+"("+quot+")";
            }
        }

        class ExtendedCombination{//n(#) - d(#)
            int val1, arg1, val2, arg2;

            private ExtendedCombination(int v1, int a1, int v2, int a2){
                val1 = v1;
                arg1 = a1;
                val2 = v2;
                arg2 = a2;
            }

            private String rawFormat(){
                return val1+"("+arg1+")"+" - "+val2+"("+arg2+")";
            }

            private String substitutedFormat(CombinationEquation e){
                if (e.rem == val1) {
                    return "["+e.getValue()+"]"+"("+arg1+") - "+val2+"("+arg2+")";
                } else {
                    return val1+"("+arg1+")"+" - ["+e.getValue()+"]("+arg2+")";
                }
            }

            private String expandedFormat(CombinationEquation e){//To follow substitutedFormat()
                if (e.rem == val1) {
                    return e.number+"("+arg1+")"+" - "+e.divisor+"("+e.quot+" x "+arg1+") - "+val2+"("+arg2+")";
                } else {
                    return val1+"("+arg1+") - "+e.number+"("+arg2+") + "+e.divisor+"("+e.quot+" x "+arg2+")";
                }
            }

            private ExtendedCombination extend(CombinationEquation e){
                if (e.rem == val1) {
                    int v1 = e.number;
                    int a1 = arg1;
                    int v2 = val2;
                    int a2 = (e.quot * arg1) + arg2;
                    return new ExtendedCombination(v1, a1, v2, a2);
                } else {
                    int v1 = val1;
                    int a1 = (e.quot * arg2) + arg1;
                    int v2 = e.number;
                    int a2 = arg2;
                    return new ExtendedCombination(v1, a1, v2, a2);
                }
            }
        }

        System.out.println("Computing the gcd of "+a+" and "+b+" using Euclidean Algorithm.");
        int number = Math.max(a, b);
        int divisor = Math.min(a, b);
        int quot = number / divisor;
        int rem = number - (divisor * quot);
        final ArrayList<CombinationEquation> list = new ArrayList<>();
        list.add(new CombinationEquation(number, divisor, quot, rem));
        while (rem != 0) {
            System.out.println(number+" = "+divisor+"("+quot+") + "+rem);
            list.add(new CombinationEquation(number, divisor, quot, rem));
            number = divisor;
            divisor = rem;
            quot = number / divisor;
            rem = number - (divisor * quot);
        }
        System.out.println(number+" = "+divisor+"("+quot+") + "+rem);
        final int GCD = divisor;
        System.out.println(" \u2234 gcd("+a+", "+b+") = "+GCD);

        System.out.println("Now reversing to find the linear propagation of the gcd.");
        if (list.size() == 1) {
            System.out.println(GCD+" = "+number+"(1) - "+divisor+"("+(--quot)+")");
            return;
        }
        Collections.reverse(list);
        list.remove(list.size() - 1);
        Iterator<CombinationEquation> listIterator = list.iterator();
        CombinationEquation equation = listIterator.next();
        ExtendedCombination combination = new ExtendedCombination(equation.number, 1, equation.divisor, equation.quot);
        System.out.println(GCD+" = "+combination.rawFormat());
        while (listIterator.hasNext() && (combination.val1 != Math.max(a, b) || combination.val2 != Math.min(a, b))) {
            equation = listIterator.next();
            final ExtendedCombination nextCombination = combination.extend(equation);
            System.out.println(GCD+" = "+combination.substitutedFormat(equation));
            System.out.println(GCD+" = "+combination.expandedFormat(equation));
            System.out.println(GCD+" = "+nextCombination.rawFormat());
            combination = nextCombination;
        }
    }

    public static int eulerPhiOf(int n){
        if (n <= 1) {
            throw new IllegalArgumentException(n+" is not in the domain of the Euler-phi function");
        } else if (isPrime(n)) {
            return  n - 1;
        }

        int phiCount = 1;//Every n >= 2 is relatively prime to 1
        for (int i = 2; i < n; i++) {//No need to start iteration @1 since it's already counted
            if (areCoPrimes(i, n)) {//And no need to iterate to n, since no n >= 2 is relatively prime to itself
                phiCount++;
            }
        }

        return phiCount;
    }

    public static int maxOf(int[] array){
        int dMax = array[0];
        for (int t : array) {
            if (t > dMax) {
                dMax = t;
            }
        }

        return dMax;
    }

    public static int minOf(int[] array){
        int dMin = array[0];
        for (int t : array) {
            if (t < dMin) {
                dMin = t;
            }
        }

        return dMin;
    }

    public static double round(double value, int places) {
        if (places < 0){
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int convertDenaryToBinary(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        final ArrayList<Integer> list = new ArrayList<>();
        int q = n/2;
        while (q != 0) {
            int r = n - 2 * q;
            list.add(r);
            n = q;
            q /= 2;
        }
        list.add(1);
        final StringBuilder builder = new StringBuilder(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
        }
        final String string = builder.substring(0, list.size());
        return Integer.parseInt(string);
    }

}
