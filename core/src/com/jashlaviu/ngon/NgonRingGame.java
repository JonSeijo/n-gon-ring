package com.jashlaviu.ngon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class NgonRingGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Viewport viewport;
	private OrthographicCamera camera;

	private Tablero tablero;

	@Override
	public void create () {
		this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(400, 600, this.camera);
        this.camera.position.set(50, 0, 0);
        this.camera.zoom -= 0.20f;
        this.tablero = new Tablero(3, 65);
	}

	@Override
	public void render () {

        this.camera.update();
        this.batch.setProjectionMatrix(this.camera.combined);

		Gdx.gl.glClearColor(0, 0.3f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		this.tablero.render(batch);
		batch.end();
	}

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
	
	@Override
	public void dispose () {
		this.batch.dispose();
	    this.tablero.dispose();
	}
}
