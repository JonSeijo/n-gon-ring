package com.jashlaviu.ngon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class TrigonTablero {

    private int tam, spacing;
    private int initialX, initialY;
    private ArrayList<Pos> positions;

    public TrigonTablero(int tam, int spacing) {
        this.tam = tam;
        this.spacing = spacing;
        this.initialX = 0;
        this.initialY = 0;
        this.fillEmptyPositions();
        this.expandPositions(this.spacing);
    }

    private void fillEmptyPositions() {
        this.positions = new ArrayList<Pos>(this.tam * 2);
        for (int i = 0; i < this.tam*2; i++) {
            this.positions.add(i, new Pos(0, 0));
        }
    }

    public void render(SpriteBatch batch, ArrayList<Nodo> nodos) {
        for (int i = 0; i < nodos.size(); i++) {
            nodos.get(i).render(batch, this.positions.get(i));
        }
    }

    public void draw(ShapeRenderer shaper) {
        Pos p0 = this.positions.get(0);
        Pos p1 = this.positions.get(1);
        Pos p2 = this.positions.get(2);
        Pos p3 = this.positions.get(3);
        Pos p4 = this.positions.get(4);
        Pos p5 = this.positions.get(5);

        Vector2 v0 = new Vector2((float)p0.x, (float)p0.y);
        Vector2 v1 = new Vector2((float)p1.x, (float)p1.y);
        Vector2 v2 = new Vector2((float)p2.x, (float)p2.y);
        Vector2 v3 = new Vector2((float)p3.x, (float)p3.y);
        Vector2 v4 = new Vector2((float)p4.x, (float)p4.y);
        Vector2 v5 = new Vector2((float)p5.x, (float)p5.y);

        shaper.line(v0, v1);
        shaper.line(v1, v3);
        shaper.line(v2, v3);
        shaper.line(v3, v5);
        shaper.line(v4, v5);
        shaper.line(v5, v1);
    }

    public void expandPositions(int new_spacing) {
        this.spacing = new_spacing;

        int ix = this.initialX;
        int iy = this.initialY;

        double d = this.spacing;
        double h = (int)(Math.sqrt(d*d - d*d/4));
        double d_prima = (int)(Math.sqrt(d*d - h*h));

        // Las coordenadas estan calculadas a mano en mi cuaderno. Pitagoras FTW
        Pos p0 = new Pos(-d/2 + ix, 3*h/2 + iy);
        Pos p1 = new Pos(0 + ix, h/2 + iy);
        Pos p2 = new Pos(3*d/2 + ix, -h/2 + iy);
        Pos p3 = new Pos(d/2 + ix, -h/2 + iy);
        Pos p4 = new Pos(-(d/2 + d_prima) + ix, -3*h/2 + iy);
        Pos p5 = new Pos(-d/2 + ix, -h/2 + iy);

        this.positions.set(0, p0);
        this.positions.set(1, p1);
        this.positions.set(2, p2);
        this.positions.set(3, p3);
        this.positions.set(4, p4);
        this.positions.set(5, p5);
    }

    public void rotatePositions(double tita) {
        double cos = Math.cos(tita);
        double sen = Math.sin(tita);

        for (int i = 0; i < this.positions.size(); i++) {
            double x_old = this.positions.get(i).x;
            double y_old = this.positions.get(i).y;

            double x_old_trans = x_old - this.initialX;
            double y_old_trans = y_old - this.initialY;

            double x_new = ((x_old_trans*cos) - (y_old_trans*sen));
            double y_new = ((x_old_trans*sen) + (y_old_trans*cos));

            this.positions.set(i, new Pos(x_new + this.initialX, y_new + this.initialY));
        }
    }

    public int getSpacing() {
        return this.spacing;
    }

    public void dispose() {

    }

}
