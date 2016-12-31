package com.jashlaviu.ngon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nodo {
    private Texture texture;
    private int value;
    private BitmapFont font;

    public Nodo(int value) {
        this.texture = new Texture(Gdx.files.internal("cell_blue.png"));
        this.value = value;
        this.font = new BitmapFont();
    }

    public void render(SpriteBatch batch, Pos pos) {
        batch.draw(this.texture, pos.x, pos.y);
        this.font.draw(batch, String.valueOf(this.value), pos.x + 12, pos.y + 22);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void dispose() {
        this.texture.dispose();
        this.font.dispose();
    }

}
