package com.jashlaviu.ngon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nodo {
    private Texture texture;
    private int value;
    private BitmapFont font;

    private int width, height;

    public Nodo(int value) {
        this.texture = new Texture(Gdx.files.internal("node_blue.png"));
        this.width = this.texture.getWidth();
        this.height = this.texture.getHeight();
        this.value = value;
        this.font = new BitmapFont();
    }

    public void render(SpriteBatch batch, Pos pos) {

        int x_pos = (int)(pos.x - this.width/2);
        int y_pos = (int)(pos.y - this.height/2);

        batch.draw(this.texture, x_pos, y_pos);
        this.font.draw(batch, String.valueOf(this.value), (int)(x_pos + 12), (int)(y_pos + 22));
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
