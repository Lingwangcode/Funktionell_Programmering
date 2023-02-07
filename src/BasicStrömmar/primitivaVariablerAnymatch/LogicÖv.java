package BasicStrömmar.primitivaVariablerAnymatch;

import java.util.List;
import java.util.OptionalDouble;

public class LogicÖv {

    List<Integer> betyg = List.of(10, 15, 20, 10, 15, 20);

    public OptionalDouble averageBetyg(){
        return betyg.stream().mapToDouble(e-> e).average();
    }

    public Double averageBetyg2(){
        return betyg.stream().mapToDouble(Double::valueOf).summaryStatistics().getAverage();
    }


}
