package drawpad;

import java.util.Objects;

/**
 * Represents a 2D vector with x and y components.
 * This class is immutable and thread-safe.
 */
public final class Vector2D {
    public double x;
    public double y;

    /**
     * Constructs a new Vector2D instance with the specified x and y components.
     *
     * @param x the x component of the vector
     * @param y the y component of the vector
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new Vector2D instance with the specified magnitude and direction.
     *
     * @param magnitude the magnitude of the vector
     * @param direction the direction of the vector, represented as a unit vector
     */
    public Vector2D(double magnitude, Vector2D direction) {
        double directionMagnitude = direction.magnitude();
        if (directionMagnitude == 0) {
            this.x = 0;
            this.y = 0;
        } else {
            this.x = direction.x * magnitude / directionMagnitude;
            this.y = direction.y * magnitude / directionMagnitude;
        }
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x + other.x, y + other.y);
    }

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


    public Vector2D subtract(Vector2D other){
        return new Vector2D(x - other.x, y - other.y);
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


    public Vector2D scalarMultiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    /**
     * Returns the magnitude (length) of the vector.
     *
     * @return the magnitude of the vector
     */
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Returns the angle (in radians) of the vector.
     *
     * @return the angle of the vector in radians
     */
    public double angle() {
        return Math.atan2(y, x);
    }


    /**
     * Returns a new vector that is the normalized version of this vector.
     * The normalized vector has a magnitude of 1 and points in the same
     * direction as the original vector.
     *
     * @return the normalized vector
     */
    public Vector2D normalize() {
        double mag = magnitude();
        return new Vector2D(x / mag, y / mag);
    }

    /**
     * Rotates a vector by a given angle in radians.
     *
     * @param angle the angle of rotation in radians
     */
    public void rotate(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        this.x = this.x * cos - this.y * sin;
        this.y = this.x * sin + this.y * cos;
    }

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
     * @param v2 the vector to project onto
     */
    public void project(Vector2D v2) {
        double dot = dotProduct(new Vector2D(x, y), v2);
        double mag2 = v2.magnitude() * v2.magnitude();
        Vector2D v = scalarMultiply(v2, dot / mag2);
        this.x = v.x;
        this.y = v.y;
    }

    /**
     * Projects one vector onto another vector.
     *
     * @param v1 the vector to be projected
     * @param v2 the vector to project onto
     * @return the projected vector
     */
    public static Vector2D project(Vector2D v1, Vector2D v2) {
        double dot = dotProduct(v1, v2);
        double mag2 = v2.magnitude() * v2.magnitude();
        return scalarMultiply(v2, dot / mag2);
    }

    /**
     * Performs linear interpolation between two vectors.
     *
     * @param v2 the second vector
     * @param t  the interpolation factor (between 0 and 1)
     */
    public void lerp(Vector2D v2, double t) {
        Vector2D v = add(
                scalarMultiply(new Vector2D(x, y), 1 - t),
                scalarMultiply(v2, t)
        );
        this.x = v.x;
        this.y = v.y;
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
        return add(
                scalarMultiply(v1, 1 - t),
                scalarMultiply(v2, t)
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
            return scalarMultiply(v.normalize(), max);
        } else if (mag < min) {
            return scalarMultiply(v.normalize(), min);
        } else {
            return v;
        }
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Vector2D other)) return false;
        return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Vector2D(" + x + ", " + y + ")";
    }
}