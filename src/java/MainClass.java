package java;

public class MainClass {

    public static void main(String[] args) {

        HabrExceptions exceptions = new HabrExceptions();
        exceptions.area(-1, 2);
        exceptions.excRecursion(null);
        exceptions.hang(5.6);

        double res = exceptions.hangOrThrow(5.6);
        System.out.println(res);

        System.err.println(exceptions.juggling());


    }

}
