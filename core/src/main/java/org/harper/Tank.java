package org.harper;

import com.badlogic.gdx.math.Vector2;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tank {
    private String name;
    private Position position;
    private int angle;
}
