package com.epam.flat.room;

public abstract class OpeningConstruction extends RoomElement {
    private boolean isOpen;

    public OpeningConstruction(int id, float width) {
        super(id, width);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}
