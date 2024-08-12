package org.harper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final Main game;
    private Battlefield battlefield;
    final Texture dropImage;
    final Texture bucketImage;
    final Texture tankImage;
    final Sound shotSound;
    final Music music;
    final OrthographicCamera camera;
    final Rectangle tank;
//    final Rectangle gun;

    public GameScreen(final Main game) {
        this.game = game;
        dropImage = new Texture(Gdx.files.internal("drop.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
        tankImage = new Texture(Gdx.files.internal("tank1_64.png"));

        // load the drop sound effect and the rain background "music"
        shotSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        tank = new Rectangle();
        tank.x = 800 / 2 - 64 / 2; // center the tank horizontally
        tank.y = 480 / 2 - 64 / 2;
        tank.width = 64;
        tank.height = 64;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 2, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(tankImage, tank.x, tank.y, tank.width, tank.height);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPosition = new Vector3();
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPosition);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tank.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tank.x += 200 * Gdx.graphics.getDeltaTime();
        }
      }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
