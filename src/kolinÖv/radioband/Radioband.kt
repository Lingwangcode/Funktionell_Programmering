package kolinÖv.radioband

import java.time.LocalTime
import java.util.Scanner


fun main(){
  fun kvarLängd (bandetsLängd: Double, användTid: Double) = bandetsLängd - användTid
  fun räknarProL (börjanT: Int, slutT:Int) = slutT - börjanT
  fun timTillMin(t: Int) = t * 60
  fun programmLängd (min1: Int, min2: Int) = min1 + min2

  var scan: Scanner = Scanner(System.`in`)
  println("Video bandets längd? (min)")
  val l = scan.nextDouble()
  println("Hittills använd tid? (min)")
  val användTid = scan.nextDouble()
  val kvarBandL = kvarLängd(l, användTid)

  println("När börjar TV-programmet? (Mata in tim)")
  var tim = scan.nextInt()
  println("När börjar TV-programmet? (mata in min)")
  var min = scan.nextInt()
  println("När avslutar TV-Programmet? (mata in tim)")
  var avTim = scan.nextInt()
  println("När avslutar TV-programmet? (mata in min")
  var avMin = scan.nextInt()
  val programLängdT = räknarProL(tim, avTim)
  val programLängdTToM = timTillMin(programLängdT)
  val programLängdM = räknarProL(min, avMin)
  val totalLängd = programmLängd(programLängdTToM, programLängdM)

  val result = if (totalLängd <= kvarBandL) "Programmet får plats i bandet" else "Programmet får inte plats i bandet"
  println(result)



}