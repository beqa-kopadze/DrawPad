package drawpad;

public class PhysicsBody {
    private Vector2D velocity;
    private Vector2D acceleration;
    private Vector2D force;
    private double mass;
    private double friction;
    private double restitution;


    public PhysicsBody(){
        velocity = new Vector2D(0,0);
        acceleration = new Vector2D(0,0);
        force = new Vector2D(0,0);
        mass =10;
        friction = 0;
        restitution = 0;
    }
    // Method to apply gravity to the circle object
    public Vector2D applyGravity(Vector2D position, Vector2D gravity) {
        // Calculate the gravitational force
        Vector2D gravitationalForce = gravity.scalarMultiply(mass).scalarMultiply(1/60f);

        // Update velocity using the gravitational force (assuming constant time step)
        velocity = velocity.add(gravitationalForce);

        // Update position using the updated velocity
        return position.add(velocity);
    }
}
