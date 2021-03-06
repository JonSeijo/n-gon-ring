package com.jashlaviu.ngon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class NgonRingGame extends ApplicationAdapter {
	private SpriteBatch batch;
    private ShapeRenderer shaper;
	private Viewport viewport;
	private OrthographicCamera camera;

	private Trigon trigon;
	private int spacingDelta;
	private float rotationAngle;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.shaper = new ShapeRenderer();
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(400, 600, this.camera);
        this.camera.position.set(50, 0, 0);
        this.camera.zoom -= 0.20f;
        this.trigon = new Trigon(65);
        this.spacingDelta = 2;
        this.rotationAngle = 0.035f;

        Gdx.input.setInputProcessor(new GameInputAdapter(this));
	}

	@Override
	public void render () {
        this.camera.update();
        this.batch.setProjectionMatrix(this.camera.combined);
        this.shaper.setProjectionMatrix(camera.combined);

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.expand();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.contract();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.trigon.rotatePositions(-this.rotationAngle);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.trigon.rotatePositions(this.rotationAngle);
        }

		Gdx.gl.glClearColor(0, 0.3f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.shaper.setAutoShapeType(true);
        this.shaper.begin();
        this.trigon.draw(this.shaper);
        this.shaper.end();

        this.batch.begin();
        this.trigon.render(this.batch);
        this.batch.end();
	}

	public void expand() {
        this.trigon.expandPositions(this.trigon.getSpacing() + this.spacingDelta);
    }

    public void contract() {
        this.trigon.expandPositions(this.trigon.getSpacing() - this.spacingDelta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
	
	@Override
	public void dispose () {
		this.batch.dispose();
		this.shaper.dispose();
	    this.trigon.dispose();
	}
}
