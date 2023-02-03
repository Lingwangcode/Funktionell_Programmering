package Funktionsgränssnitt.MathOperation;

public interface MathOperation {
        int operation(int a, int b);

        default MathOperation andThen (MathOperation after){
                return (n1, n2) -> after.operation(operation(n1,n2),operation(n1,n2));
        }

        default MathOperation add(MathOperation m){
                return (n1, n2)-> m.operation(n1,n2) + operation(n1,n2);
        }

        default MathOperation doubleUp(MathOperation m){
                return (n1, n2) -> operation(m.operation(n1,n2),operation(n1, n2));
        }

}
