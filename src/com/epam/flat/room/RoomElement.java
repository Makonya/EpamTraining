package com.epam.flat.room;

public abstract class RoomElement {
    private float width;
    private static float height;
    private int id;

    public RoomElement(int id, float width) {
        this.id = id;
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public static float getHeight() {
        return height;
    }

    public static void setHeight(float height) {
        RoomElement.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
