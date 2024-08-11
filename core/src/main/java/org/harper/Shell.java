package org.harper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class Shell implements Pool.Poolable {
    private int caliber;
    private String name; // name of the shell
    private int maxVelocity;
    private int damage;
    private int blastRadius;
    private Vector2 position;
    private Vector2 velocity = new Vector2(0, 0);
    private Vector2 acceleration = new Vector2(0, 0);
    private boolean alive;

    Shell(Vector2 position) {
        alive = false;
        this.position = position;
    }

    public boolean fire() {
        position.add(acceleration);
        alive = true;
        return true;
    }

    public void update(Vector2 acceleration) {
        position.add(velocity);
        velocity.add(acceleration);
        if (velocity.x <= 0 || position.y <= 0) {
            alive = false;
        }
    }

    @Override
    public void reset() {

    }
}
