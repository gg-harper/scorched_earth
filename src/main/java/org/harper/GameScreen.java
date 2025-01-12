package org.harper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class GameScreen implements Screen {

    final Main game;
    Texture dropImage;
    Texture bucketImage;
    Texture tankImage;
    Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
//    Rectangle bucket;
    Rectangle tank;
    Rectangle gun;
//    Array<Rectangle> rainDrops;
    long lastDropTime;
    int dropsGathered;

    public GameScreen(final Main game) {
        this.game = game;
        // load the images for the droplet and the bucket, 64x64 pixels each
        dropImage = new Texture(Gdx.files.internal("drop.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
        tankImage = new Texture(Gdx.files.internal("tank1_64.png"));
//        Animation<TextureAtlas.AtlasRegion> dropAnimation = new Animation<TextureAtlas.AtlasRegion>(0.1f, dropImage,

        // load the drop sound effect and the rain background "music"
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // create a Rectangle to logically represent the bucket
 /*       bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above
        // the bottom screen edge
        bucket.width = 64;
        bucket.height = 64;*/

        tank = new Rectangle();
        tank.x = 800 / 2 - 64 / 2; // center the tank horizontally
        tank.y = 480 / 2 - 64 / 2;
        tank.width = 64;
        tank.height = 64;


        // create the raindrops array and spawn the first raindrop
        /*rainDrops = new Array<>();
        spawnRaindrop();*/
    }
/*
    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800 - 64);
        raindrop.y = 480;
        raindrop.width = 64;
        raindrop.height = 64;
        rainDrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }*/

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 2, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
//        game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
        game.batch.draw(tankImage, tank.x, tank.y, tank.width, tank.height);
     /*   for (Rectangle raindrop : rainDrops) {
            game.batch.draw(dropImage, raindrop.x, raindrop.y);
        }*/
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPosition = new Vector3();
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPosition);
//            bucket.x = touchPosition.x - 64 / 2;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tank.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tank.x += 200 * Gdx.graphics.getDeltaTime();
        }
      /*  if (bucket.x < 0) {
            bucket.x = 0;
        }
        if (bucket.x > 800 - 64) {
            bucket.x = 800 - 64;
        }
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) {
            spawnRaindrop();
        }
        Iterator<Rectangle> iterator = rainDrops.iterator();
        while (iterator.hasNext()) {
            Rectangle rainDrop = iterator.next();
            rainDrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (rainDrop.y + 64 < 0)
                iterator.remove();
            if (rainDrop.overlaps(bucket)) {
                dropsGathered++;
                dropSound.play(0.2f);
                iterator.remove();
            }

        }*/

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
