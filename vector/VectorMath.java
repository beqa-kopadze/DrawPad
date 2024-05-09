package vector;

/**
 * This class provides static methods for performing various vector math operations
 * on Vector2D instances.
 */
public final class VectorMath {
    // Private constructor to prevent instantiation
    private VectorMath() {}

    /**
     * Rotates a vector by a given angle in radians.
     *
     * @param v     the vector to be rotated
     * @param angle the angle of rotation in radians
     * @return the rotated vector
     */
    public static Vector2D rotate(Vector2D v, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Vector2D(v.x * cos - v.y * sin, v.x * sin + v.y * cos);
    }

    /**
     * Projects one vector onto another vector.
     *
     * @param v1 the vector to be projected
     * @param v2 the vector to project onto
     * @return the projected vector
     */
    public static Vector2D project(Vector2D v1, Vector2D v2) {
        double dot = Vector2DOperations.dotProduct(v1, v2);
        double mag2 = v2.magnitude() * v2.magnitude();
        return Vector2DOperations.scalarMultiply(v2, dot / mag2);
    }

    /**
     * Performs linear interpolation between two vectors.
     *
     * @param v1 the first vector
     * @param v2 the second vector
     * @param t  the interpolation factor (between 0 and 1)
     * @return the interpolated vector
     */
    public static Vector2D lerp(Vector2D v1, Vector2D v2, double t) {
        return Vector2DOperations.add(
                Vector2DOperations.scalarMultiply(v1, 1 - t),
                Vector2DOperations.scalarMultiply(v2, t)
        );
    }

    /**
     * Clamps the magnitude of a vector between a minimum and maximum value.
     *
     * @param v   the vector to be clamped
     * @param min the minimum magnitude
     * @param max the maximum magnitude
     * @return the clamped vector
     */
    public static Vector2D clamp(Vector2D v, double min, double max) {
        double mag = v.magnitude();
        if (mag > max) {
            return Vector2DOperations.scalarMultiply(v.normalize(), max);
        } else if (mag < min) {
            return Vector2DOperations.scalarMultiply(v.normalize(), min);
        } else {
            return v;
        }
    }
}