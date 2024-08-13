package org.harper;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int x;
    private int y;

    public void add(Vector2 velocity) {
       x += velocity.x;
       y += velocity.y;
    }
}
