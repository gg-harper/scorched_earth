package org.harper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Shell implements Pool.Poolable {

    private static final Vector2 ACCELERATION = new Vector2(0, -10);

    private int caliber;
    private String name; // name of the shell
    private int maxVelocity;
    private int damage;
    private int blastRadius;
    private Vector2 velocity;
    private Position position;
    private boolean alive;

    private Tank tank;

    Shell(Position position, int caliber, String name, int maxVelocity, int damage, int blastRadius) {
        this.caliber = caliber;
        this.name = name;
        this.maxVelocity = maxVelocity;
        this.damage = damage;
        this.alive = false;
        this.position = position;
        this.velocity = new Vector2(0, 0);
        this.blastRadius = blastRadius;
    }

    public boolean fire() {
        alive = true;
        velocity.setAngleDeg(45 ); //= maxVelocity tank.getAngle();
        return true;
    }

    public void update(Vector2 acceleration) {
        position.move(velocity);
        velocity.add(acceleration);
        checkPosition();
    }

    private void checkPosition() {
        if (velocity.x <= 0 || position.getY() <= 0) {
            alive = false;
        }
    }

    @Override
    public void reset() {
        alive = false;
        velocity.set(0, 0);
        position = tank.getPosition();
    }
}
