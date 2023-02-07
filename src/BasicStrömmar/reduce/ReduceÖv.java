package BasicStrömmar.reduce;

import java.util.List;

public class ReduceÖv {

    List<Integer> betyg = List.of(10, 15, 20, 10, 15, 20);
    List<String> titel = List.of("hej", "hur", "mår", "du");

    public double averageValueOfBetyg(){
        int sumOfBetyg = betyg.stream().reduce(0, (sum, elem) -> sum + elem);
        double average = sumOfBetyg / betyg.size();
        return average;
    }

    public String SumOfTitel(){
        return titel.stream().reduce("", (sum, elem) -> sum +" " + elem);
    }

    public static void main(String[] args) {
        ReduceÖv r = new ReduceÖv();
        System.out.println(r.averageValueOfBetyg());
        System.out.println(r.SumOfTitel());
    }
}

