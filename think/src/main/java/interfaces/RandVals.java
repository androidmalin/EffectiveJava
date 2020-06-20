package interfaces;

import java.util.Random;

/**
 * 这些值存储在接口的静态存储区域
 */
// Initializing interface fields with non-constant initializers.
public interface RandVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextLong() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
