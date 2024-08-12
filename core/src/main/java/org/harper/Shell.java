package org.harper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector4;
import com.badlogic.gdx.utils.Pool;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class Shell implements Pool.Poolable {

    private static final Vector2 ACCELERATION = new Vector2(0, -10);

    private int caliber;
    private String name; // name of the shell
    private int maxVelocity;
    private int damage;
    private int blastRadius;
    private Vector2 position;
    private Vector2 velocity;
Vector4 color;
    private boolean alive;

    private Tank tank;

    Shell(Vector2 position) {
        alive = false;
        this.position = position;
    }

    public boolean fire() {
        alive = true;
        velocity = tank.getAngle();
        return true;
    }

    public void update(Vector2 acceleration) {
        position.add(velocity);
        velocity.add(acceleration);
        checkPosition();
    }

    private void checkPosition() {
        if (velocity.x <= 0 || position.y <= 0) {
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
