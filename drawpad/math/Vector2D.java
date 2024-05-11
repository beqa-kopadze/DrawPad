package drawpad.math;

import java.util.Objects;

/**
 * Represents a 2D vector with x and y components.
 * This class is immutable and thread-safe.
 */
public final class Vector2D {
    public final double x;
    public final double y;

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