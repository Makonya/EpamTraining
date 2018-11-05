package com.epam.flat.room;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private RoomType type;
    List<Wall> walls = new ArrayList<>(4);
    List<Door> doors = new ArrayList<>();
    List<Window> windows = new ArrayList<>();

    public Room() {
    }

    public Room(RoomType type, List<Wall> walls, List<Door> doors, List<Window> windows) {
        this.type = type;
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public float getRoomSquare() {
        float roomSquare;
        roomSquare = this.walls.get(0).getWidth() * this.walls.get(1).getWidth();
        return roomSquare;
    }

    public float getRoomPerimeter() {
        float roomPerimeter = 0;
        for (Wall wall : this.walls) {
            roomPerimeter += wall.getWidth();
        }
        return roomPerimeter;
    }
}
