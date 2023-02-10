package kolinÖv.RekursionÖv

import java.lang.Math.pow
import java.util.DoubleSummaryStatistics


fun main() {
    fun räknaRänta(belopp: Double, antalÅr: Int, ränta: Double): Double{
        var räntaIDecimal = ränta +1
        if(antalÅr == 0) return belopp
        return räknaRänta(belopp + belopp * ränta, antalÅr-1, ränta )

    }

    fun räknaRänta2(belopp: Double, antalÅr: Int, ränta: Double) : Double{

        fun räknaRäntaInnerAcc(belopp: Double, antalÅr: Int, ränta: Double, acc: Double): Double{
            if (antalÅr == 0) return acc
            else return räknaRäntaInnerAcc(belopp, antalÅr-1, ränta, acc+(acc *ränta))
        }
        return räknaRäntaInnerAcc(belopp, antalÅr, ränta, belopp)
    }
    println(räknaRänta(100.0, 2, 0.1))
    println(räknaRänta2(100.0, 5, 0.1))//110 + (110*0.1) = 121, 121+(121*0.1)
}