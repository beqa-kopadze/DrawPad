package drawpad.math;

/**
 * This class provides static methods for performing common vector operations
 * on Vector2D instances.
 */
public final class Vector2DOperations {
    // Private constructor to prevent instantiation
    private Vector2DOperations() {}

    /**
     * Adds two vectors and returns the result as a new Vector2D instance.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the sum of the two vectors
     */
    public static Vector2D add(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x + v2.x, v1.y + v2.y);
    }

    /**
     * Subtracts the second vector from the first vector and returns the result
     * as a new Vector2D instance.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the difference between the two vectors
     */
    public static Vector2D subtract(Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.x - v2.x, v1.y - v2.y);
    }

    /**
     * Multiplies a vector by a scalar value and returns the result as a new
     * Vector2D instance.
     *
     * @param v      the vector to be scaled
     * @param scalar the scalar value
     * @return the scaled vector
     */
    public static Vector2D scalarMultiply(Vector2D v, double scalar) {
        return new Vector2D(v.x * scalar, v.y * scalar);
    }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the dot product of the two vectors
     */
    public static double dotProduct(Vector2D v1, Vector2D v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }

    /**
     * Calculates the cross product of two 2D vectors, which results in a scalar value.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @return the cross product of the two vectors
     */
    public static double crossProduct(Vector2D v1, Vector2D v2) {
        return v1.x * v2.y - v1.y * v2.x;
    }
}