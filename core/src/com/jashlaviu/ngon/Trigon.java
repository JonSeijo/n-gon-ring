package com.jashlaviu.ngon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Trigon {

    private Tablero tablero;
    private ArrayList<Nodo> nodos;
    private ArrayList<Integer> grupo1, grupo2, grupo3;

    public Trigon(int spacing) {
        this.tablero = new Tablero(3, spacing);
        this.nodos = new ArrayList<Nodo>();
        this.crearGrupos();
        this.agregarNodos();
    }

    public void render(SpriteBatch batch) {
        this.tablero.render(batch, this.nodos);
    }

    public void draw(ShapeRenderer shaper) {
        this.tablero.draw(shaper);
    }

    private void agregarNodos() {
        for (int i = 0; i < 6; i++) {
            this.nodos.add(new Nodo(i));
        }
    }

    public ArrayList<Nodo> getNodos() {
        return this.nodos;
    }

    private void crearGrupos() {
        this.grupo1 = new ArrayList<Integer>(3);
        grupo1.add(0, 0);
        grupo1.add(1, 1);
        grupo1.add(2, 3);

        this.grupo2 = new ArrayList<Integer>(3);
        grupo2.add(0, 2);
        grupo2.add(1, 3);
        grupo2.add(2, 5);

        this.grupo3 = new ArrayList<Integer>(3);
        grupo3.add(0, 4);
        grupo3.add(1, 5);
        grupo3.add(2, 1);
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
        for (int i = 0; i < this.nodos.size(); i++) {
            this.nodos.get(i).dispose();
        }
        this.tablero.dispose();
    }

}
