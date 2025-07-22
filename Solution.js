
/**
 * @param {number[][]} points
 * @return {number}
 */
var countTrapezoids = function (points) {
    const MODULO_VALUE = BigInt(Math.pow(10, 9) + 7);
    const yCoordinatesToFrequency = new Map();

    let totalNumberOfPairs = BigInt(0);
    for (let point of points) {
        const y = point[1];
        const previousFrequency = yCoordinatesToFrequency.has(y) ? yCoordinatesToFrequency.get(y) : 0;
        totalNumberOfPairs += BigInt(previousFrequency);
        yCoordinatesToFrequency.set(y, 1 + previousFrequency);
    }

    let totalNumberOfTrapezoids = BigInt(0);
    for (let y of yCoordinatesToFrequency.keys()) {
        const frequency = yCoordinatesToFrequency.get(y);
        const currentNumberOfPairs = BigInt(Math.floor(frequency * (frequency - 1) / 2));
        totalNumberOfPairs -= currentNumberOfPairs;
        totalNumberOfTrapezoids += BigInt(totalNumberOfPairs) * currentNumberOfPairs;
    }

    return Number(totalNumberOfTrapezoids % MODULO_VALUE);
};
