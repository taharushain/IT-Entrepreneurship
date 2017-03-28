package com.example.graphicsbubble;

/**
 * Created by taharushain on 3/27/17.
 */

public class Coords {
    float mX;
    float mY;

    public Coords(float x, float y) {
        mX = x;
        mY = y;
    }

    synchronized Coords move (Coords dxdy) {
        return new Coords(mX + dxdy.mX , mY + dxdy.mY);
    }

    synchronized Coords getCoords() {
        return new Coords(mX, mY);
    }

    @Override
    public String toString () {
        return "(" + mX + "," + mY + ")";
    }
}
