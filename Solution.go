
package main
import "math"

var MODULO_VALUE = int64(math.Pow(10.0, 9.0)) + 7

func countTrapezoids(points [][]int) int {
    yCoordinatesToFrequency := map[int]int{}

    var totalNumberOfPairs int64 = 0
    for _, point := range points {
        y := point[1]
        previousFrequency := yCoordinatesToFrequency[y]
        totalNumberOfPairs += int64(previousFrequency)
        yCoordinatesToFrequency[y] = 1 + previousFrequency
    }

    var totalNumberOfTrapezoids int64 = 0
    for y := range yCoordinatesToFrequency {
        frequency := int64(yCoordinatesToFrequency[y])
        currentNumberOfPairs := frequency * (frequency - 1) / 2
        totalNumberOfPairs -= currentNumberOfPairs
        totalNumberOfTrapezoids += totalNumberOfPairs * currentNumberOfPairs
    }

    return int(totalNumberOfTrapezoids % MODULO_VALUE)
}
