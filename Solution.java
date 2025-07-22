
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final int MODULO_VALUE = (int) Math.pow(10, 9) + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> yCoordinatesToFrequency = new HashMap<>(points.length);

        long totalNumberOfPairs = 0;
        for (int[] point : points) {
            int y = point[1];
            int previousFrequency = yCoordinatesToFrequency.getOrDefault(y, 0);
            totalNumberOfPairs += previousFrequency;
            yCoordinatesToFrequency.put(y, 1 + previousFrequency);
        }

        long totalNumberOfTrapezoids = 0;
        for (int y : yCoordinatesToFrequency.keySet()) {
            long frequency = yCoordinatesToFrequency.get(y);
            long currentNumberOfPairs = frequency * (frequency - 1) / 2;
            totalNumberOfPairs -= currentNumberOfPairs;
            totalNumberOfTrapezoids += totalNumberOfPairs * currentNumberOfPairs;
        }

        return (int) (totalNumberOfTrapezoids % MODULO_VALUE);
    }
}
