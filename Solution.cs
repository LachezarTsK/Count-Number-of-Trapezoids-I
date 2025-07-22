
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly int MODULO_VALUE = (int)Math.Pow(10, 9) + 7;

    public int CountTrapezoids(int[][] points)
    {
        Dictionary<int, int> yCoordinatesToFrequency = new Dictionary<int, int>(points.Length);

        long totalNumberOfPairs = 0;
        foreach (int[] point in points)
        {
            int y = point[1];
            yCoordinatesToFrequency.TryAdd(y, 0);
            int previousFrequency = yCoordinatesToFrequency[y];
            totalNumberOfPairs += previousFrequency;
            ++yCoordinatesToFrequency[y];
        }

        long totalNumberOfTrapezoids = 0;
        foreach (int y in yCoordinatesToFrequency.Keys)
        {
            long frequency = yCoordinatesToFrequency[y];
            long currentNumberOfPairs = frequency * (frequency - 1) / 2;
            totalNumberOfPairs -= currentNumberOfPairs;
            totalNumberOfTrapezoids += totalNumberOfPairs * currentNumberOfPairs;
        }

        return (int)(totalNumberOfTrapezoids % MODULO_VALUE);
    }
}
