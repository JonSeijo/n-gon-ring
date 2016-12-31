package com.jashlaviu.ngon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Tablero {

    private int tam;
    private int spacing;
    private int initialX;
    private int initialY;
    private ArrayList<Pos> positions;
    private ArrayList<Nodo> nodos;

    public Tablero(int tam, int spacing) {
        this.tam = tam;
        this.spacing = spacing;
        this.initialX = 100;
        this.initialY = 100;
        this.positions = new ArrayList<Pos>(this.tam * 2);
        this.nodos= new ArrayList<Nodo>();
        this.fillPositions();
    }

    private void fillPositions() {
        this.positions.add(0, new Pos(this.initialX, this.initialY));
        this.positions.add(1, new Pos(this.initialX + this.spacing, this.initialY - this.spacing));
        this.positions.add(2, new Pos(this.initialX + this.spacing*2, this.initialY - this.spacing*2));
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < this.nodos.size(); i++) {
            this.nodos.get(i).render(batch, this.positions.get(i));
        }
    }

    public void agregarNodo(Nodo nodo) {
        if (this.nodos.size() >= this.tam*2) {
            System.out.println("NO podes agregar tantos nodos!!");
            return;
        }
        this.nodos.add(nodo);
    }

}
