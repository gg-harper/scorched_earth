package org.harper;

import com.badlogic.gdx.math.Vector2;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tank {
    private String name;
    private Vector2 position;
    private Vector2 angle;
}
