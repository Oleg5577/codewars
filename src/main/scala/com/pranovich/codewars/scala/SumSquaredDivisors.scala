package com.pranovich.codewars.scala

/**
 * https://www.codewars.com/kata/55aa075506463dac6600010d/train/scala
 *
 * Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764.
 * The sum of the squared divisors is 2500 which is 50 * 50, a square!
 *
 * Given two integers m, n (1 <= m <= n) we want to find all integers between m and n
 * whose sum of squared divisors is itself a square. 42 is such a number.
 *
 * The result will be an array of arrays or of tuples (in C an array of Pair) or a string,
 * each subarray having two elements, first the number whose squared divisors is a square and then the sum of the squared divisors.
 *
 * #Examples:
 * list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
 * list_squared(42, 250) --> [[42, 2500], [246, 84100]]
 * The form of the examples may change according to the language, see Example Tests: for more details.
 *
 */
object SumSquaredDivisors {

  def findAllDivisors(num: Long): List[Long] = {
    var listDivisors = List[Long]()
    for (i <- 1L to Math.sqrt(num).toLong) {
      if (num % i == 0) {
        val numDividedByI = num / i
        if (numDividedByI != i) {
          listDivisors = numDividedByI :: i :: listDivisors
        } else listDivisors = i :: listDivisors
      }
    }
    listDivisors
  }


  def listSquared(m: Long, n: Long): String = {
    m.to(n)
      .map(x => x -> findAllDivisors(x))
      .map(p => p._1 -> p._2.map(x => x * x).sum)
      .filter(p => Math.sqrt(p._2) % 1 == 0)
      .map(p => s"[${p._1}, ${p._2}]").mkString("[", ", ", "]")
  }
}