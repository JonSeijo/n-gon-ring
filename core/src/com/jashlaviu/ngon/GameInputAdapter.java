package com.jashlaviu.ngon;

import com.badlogic.gdx.InputProcessor;

public class GameInputAdapter implements InputProcessor{
    private NgonRingGame game;

    public GameInputAdapter(NgonRingGame game) {
        this.game = game;
    }


    @Override
    public boolean scrolled(int amount) {
        if (amount > 0) {
            game.contract();
        } else {
            game.expand();
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
}
