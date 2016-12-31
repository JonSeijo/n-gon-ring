package com.jashlaviu.ngon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Trigon {

    private Tablero tablero;

    public Trigon(int spacing) {
        this.tablero = new Tablero(3, spacing);
    }

    public void render(SpriteBatch batch) {
        this.tablero.render(batch);
    }

    public void draw(ShapeRenderer shaper) {
        this.tablero.draw(shaper);
    }

    public void rotatePositions(float rotationAngle) {
        this.tablero.rotatePositions(rotationAngle);
    }

    public void expandPositions(int new_spacing) {
        this.tablero.expandPositions(new_spacing);
    }

    public int getSpacing() {
        return this.tablero.getSpacing();
    }

    public void dispose() {
        this.tablero.dispose();
    }

}
