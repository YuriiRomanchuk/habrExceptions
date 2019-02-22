package java;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HabrExceptions {


    // 1
    public int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }

    // 2
    public void catchPart() {

        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (EOFException e) {
        }

    }

    // 3
    public void catchTheUncatchable() {

        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {
                    throw new Error();
                }
                System.err.print(" 2.3");
            } catch (Throwable t) {
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) {
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }

    // 4
    public void excRecursion(NullPointerException e) {

        try {
            throw e;
        } catch (NullPointerException npe) {
            excRecursion(npe);
        }

    }

    // 5
    public void finallyRights() {
        try {
            System.err.println("try");
            if (true) {
                throw new RuntimeException();
            }
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }

    // 6
    public void hang(double e) {
        while (true) {
            System.out.println("!!!!");
        }
    }

    // 7
    public double hangOrThrow(double e) {

        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return e * e;
        } else if (time % 2 == 1) {
            while (true) ;
        } else {
            throw new RuntimeException();
        }
    }

    // 8
    public void hierarchy() {

        try {
            throw new Exception();
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }


    // 9
    public void innerEx() {

        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                if (true) {
                    throw new RuntimeException();
                }
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3");
            } finally {
                System.err.print(" 4");
            }
            System.err.print(" 5");
        } catch (Exception e) {
            System.err.print(" 6");
        } finally {
            System.err.print(" 7");
        }
        System.err.print(" 8");
    }

    // 10
    public int juggling() {

        try {
            return 0;
        } finally {
            throw new Error();
        }
    }


    // 11
    public void multipleExcept() throws EOFException, FileNotFoundException {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }

    // 12
    public void outOfCatch() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {
            System.err.print(" 2");
            if (true) {
                throw e;
            }
        }
        System.err.println(" 3");
    }

    // 13
    class Parent {
        public void f() throws IOException, InterruptedException {
        }
    }

    class Child extends Parent {
        // а потомок пугает только  IOException
        @Override
        public void f() throws FileNotFoundException {
        }
    }


    // 14
    public void tcf() {

        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (Error e) {
            System.err.print(" 2");
        } finally {
            System.err.print(" 3");
        }
        System.err.print(" 4");

    }

    // 15
    public void uncatchable() {

        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехват
            System.err.print(" 2");
            if (true) {
                throw new Error();
            } // и бросили новый Error
        } catch (Error e) { // хотя есть cath по Error ниже, но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");
    }

    // 16
    public void whatDoWeCatch() {

        try {
            Throwable t = new Exception();
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");

    }

    //17
    public void WhoCanCatchWho() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new Error();
            }
            System.err.print(" 1");
        } catch (Exception e) {
            System.err.print(" 2");
        }
        System.err.print(" 3");
    }

}
