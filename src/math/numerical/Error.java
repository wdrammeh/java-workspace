package math.numerical;

public class Error {

    public static double trueError(double actualVal, double estimateVal){
        final double e = Math.abs(actualVal - estimateVal) / Math.abs(actualVal);
        return e * 100;
    }

}
