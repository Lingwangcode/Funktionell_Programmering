package Funktionsgränssnitt.MathOperation;

public class MathOperationMain {
    private static int operate(int a, int b, MathOperation mathOperation) {

        return mathOperation.operation(a, b);
    }

    public static void main(String args[]) {
/*
      MathOperation addition = ???
      MathOperation subtraction =  ???
      MathOperation multiplication = ???
      MathOperation division = ???
      System.out.println("10 + 5 = " + operate(10, 5, addition));
      System.out.println("10 - 5 = " + operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + operate(10, 5, division));
		*/
        int nr1 = 10;
        int nr2 = 5;
        MathOperation addition = (a, b) -> nr1 + nr2;
        System.out.println(addition.operation(nr1,nr2));

        //bättre sätt
        MathOperation addition2 = (a1, b1)-> a1 + b1;

        MathOperation subtraction =(a, b) -> nr1 - nr2;
        System.out.println(subtraction.operation(nr1,nr2));

        MathOperation multiplication = (a, b) -> nr1 * nr2;
        System.out.println(multiplication.operation(nr1,nr2));

        MathOperation division = (a, b) -> nr1 / nr2;
        System.out.println(division.operation(nr1, nr2));

        System.out.println(multiplication.add(addition).operation(nr1, nr2));

        System.out.println(addition.doubleUp(subtraction).operation(nr1, nr2));

        System.out.println(addition2.operation(15,12));
    }
}
