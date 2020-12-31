package math.numerical;

public class Functions {


    public static void main(String[] args) {
        func1Of(-2);
        func1Of(-0.5);
        func1Of(0);
        func1Of(1);
        func1Of(2);
        func1Of(2.5);
        func1Of(4);
        System.out.println(Error.trueError(1_100, 5_280));
        System.out.println(Error.trueError(1_100, 2_634));
        System.out.println(Error.trueError(1_100, 1_516.875));
        System.out.println(Error.trueError(1_100, 1_752));
        System.out.println(Error.trueError(1_100, 11_136));
    }


    private static double func1(double x){
        return 1 - x - 4*Math.pow(x, 3) + 2*Math.pow(x, 5);
    }

    private static void func1Of(double x){
        System.out.println("f("+x+") = "+func1(x));
    }

}
