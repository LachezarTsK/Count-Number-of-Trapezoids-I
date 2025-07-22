
import kotlin.math.pow

class Solution {

    private companion object{
        val MODULO_VALUE = ((10.0).pow(9.0) + 7).toInt()
    }

    fun countTrapezoids(points: Array<IntArray>): Int {
        val yCoordinatesToFrequency = mutableMapOf<Int,Int> ()

        var totalNumberOfPairs:Long = 0
        for (point in points) {
            val y = point[1]
            val previousFrequency = yCoordinatesToFrequency.getOrDefault(y, 0)
            totalNumberOfPairs += previousFrequency;
            yCoordinatesToFrequency[y] =  1 + previousFrequency
        }

        var totalNumberOfTrapezoids:Long = 0
        for (y in yCoordinatesToFrequency.keys) {
            val frequency:Long = yCoordinatesToFrequency[y]!!.toLong()
            val currentNumberOfPairs = frequency * (frequency - 1) / 2
            totalNumberOfPairs -= currentNumberOfPairs
            totalNumberOfTrapezoids += totalNumberOfPairs * currentNumberOfPairs
        }

        return (totalNumberOfTrapezoids % MODULO_VALUE).toInt()
    }
}
