package com.jashlaviu.ngon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nodo {
    private Texture texture;
    private int value;

    public Nodo() {
        this.texture = new Texture(Gdx.files.internal("cell_blue.png"));
    }

    public void render(SpriteBatch batch, Pos pos) {
        batch.draw(this.texture, pos.x, pos.y);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
