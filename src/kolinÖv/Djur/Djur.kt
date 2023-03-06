package kolinÖv.Djur

import kotlin.math.max

class Djur(var sort : String,var antalBen: Int, var namn : String ){
    fun getDjurSort() : String = this.sort
    fun settSort(sort:String){this.sort = sort}

    fun getantalBen(): Int = this.antalBen
    fun settAntalBen(antalBen:Int){this.antalBen = antalBen}

    fun utskrift():String = "${getDjurSort()} har ${getantalBen()} ben"
    fun changeDjurSort (djur : Djur) {djur.sort = "Hund"}
}
fun djursLäte(djur: Djur) {
    when(djur.sort){
        "Hund" -> println("Voff")
        "Orm" -> println("Ssss")
        "Spindel" -> println("Klätter")
        else -> println("Ogiltig djur")

    }
}


val spindel1 = Djur("Spindel", 6, "Spin")
val orm1 = Djur("Orm", 0, "Oris")
val hund1 = Djur("Hund", 4, "Vove")



val djurList: List<Djur> = mutableListOf(hund1, orm1, spindel1)

val set1 = setOf(hund1, hund1, orm1, spindel1)
val set2 = setOf(hund1, orm1, spindel1)

val djurMap = mapOf(spindel1.namn to spindel1, orm1.namn to orm1, hund1.namn to hund1  )



fun main() {

    println( hund1.utskrift())
    println(orm1.utskrift())
    println(spindel1.utskrift())

    for (djur in djurList) println("${djur.getDjurSort()}, ${djur.getantalBen()}")
    djurList.forEach { d -> println(d.getDjurSort() + d.getantalBen()) }
    djurList.forEach { println("${it.getDjurSort()}, ${it.getantalBen()}") }

    set1.forEach { d -> println(d.utskrift()) }
    println()
    set2.forEach { d -> println(d.utskrift()) }
   println(set1.equals(set2))

    for ((key, value) in djurMap) println("$key ${value.sort}")

    djursLäte(hund1)
    djursLäte(orm1)
    djursLäte(spindel1)
    println()

    //övning 6c Sorterar bort alla spindlar i listan
    val djurListUtanSpindel = djurList.filter { !it.getDjurSort().equals("Spindel") }
    djurListUtanSpindel.forEach { println( it.utskrift()) }




    /*fun changeDjurSortToHund(list: MutableList<Djur>) : List<Djur>{
        return list.map { Djur("Hund", 4, "Hund1") }
    }
    changeDjurSortToHund(djurList).forEach{it.utskrift}

    Fungerar om Djur klassen inte är abstract
     */
    //övning 6d kollar om det finns ett visst djur i listan
    fun finnsKatt(list: List<Djur>) : Boolean{
        return list.filter { it.getDjurSort().equals("Katt") }.any()
    }
    println(finnsKatt(djurList))

    println(djurList.filter { it.getDjurSort().equals("Hund") }.any())
    println(djurList.filter { it.getDjurSort().equals("Katt") }.any())


    //övning 6e hittar max antal ben
    fun maxAntalBen(list: List<Djur>) :Int = list.maxOf { it.antalBen }

    println(maxAntalBen(djurList))

    //övning 6f metod som sumerar antal ben alla djuren har
    fun sumAntalBen(list: List<Djur>) :Int = list.sumOf { it.antalBen }
    println(sumAntalBen(djurList))

    //Öving 6g hur många insekter finns i listan (insekter har fler än 4 ben)
    fun insektList(list: List<Djur>) :Int = list.filter { it.antalBen > 4 }.count()
    println(insektList(djurList))

    //övning 6h funktion som fördubblar antalet djur i den lista den returnerar
    fun fördubblarDjur(list: List<Djur>): List<Djur>{
        return list + list
    }
    fördubblarDjur(djurList).forEach { println(it.utskrift()) }
    println()

    //övning 6b gör om alla djur till hund, obs. fungerar inte att skriva ut hundmap
    val hundMap = djurList.map { it.settSort("Hund") }
    djurList.forEach { println( it.utskrift())}



}

