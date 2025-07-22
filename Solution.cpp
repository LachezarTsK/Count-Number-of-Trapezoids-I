
#include <cmath>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {

    inline static int MODULO_VALUE = pow(10, 9) + 7;

public:
    int countTrapezoids(const vector<vector<int>>& points) const {
        unordered_map<int, int> yCoordinatesToFrequency;

        long long totalNumberOfPairs = 0;
        for (const auto& point : points) {
            int y = point[1];
            int previousFrequency = yCoordinatesToFrequency[y];
            totalNumberOfPairs += previousFrequency;
            ++yCoordinatesToFrequency[y];
        }

        long long totalNumberOfTrapezoids = 0;
        for (const auto& yToFrequency : yCoordinatesToFrequency) {
            long long frequency = yToFrequency.second;
            long long currentNumberOfPairs = frequency * (frequency - 1) / 2;
            totalNumberOfPairs -= currentNumberOfPairs;
            totalNumberOfTrapezoids += totalNumberOfPairs * currentNumberOfPairs;
        }

        return totalNumberOfTrapezoids % MODULO_VALUE;
    }
};
