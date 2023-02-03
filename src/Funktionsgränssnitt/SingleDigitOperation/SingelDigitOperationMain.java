package Funktionsgränssnitt.SingleDigitOperation;

import org.w3c.dom.ls.LSOutput;

public class SingelDigitOperationMain {

    public static void main(String[] args) {

        SingleDigitOperation kvadrat = i -> i*i;

        SingleDigitOperation checkPositive = i -> {if (i >= 0) return 1; else return 0;};

        System.out.println(kvadrat.operate(4));
        System.out.println(checkPositive.operate(3));


    }



}
