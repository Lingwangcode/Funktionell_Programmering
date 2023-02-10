package kolinÖv

fun main(){
    fun jämnaTal(){
        for (i in 20 downTo 1 ) if (i % 2 == 0) println(i)
    }

    fun multiplikationstabell(x: Int, minstaTal: Int, högstaTal: Int){
        for (i in minstaTal .. högstaTal) println(x * i)
    }

    fun isPrimeNr(n: Int) : Boolean{
        for (i in 2 .. n/2){
            if (n % i == 0) return false
        }
        return true
    }
}