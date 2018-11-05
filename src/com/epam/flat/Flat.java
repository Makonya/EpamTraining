package com.epam.flat;

import com.epam.flat.room.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flat {
    List<Room> rooms = new ArrayList<>();

    public float getFlatSquare() {
        float flatSquare = 0;
        for (Room room : this.rooms) {
            flatSquare += room.getRoomSquare();
        }
        return flatSquare;
    }

    public int countWalls() {
        //int wallCounter = 0;
        List<Integer> wallsIds = new ArrayList<>();
        for (Room room : rooms) {
            for (int j = 0; j < room.getWalls().size(); j++) {
                wallsIds.add(room.getWalls().get(j).getId());
            }
        }
        List<Integer> uniqueWallsIds = new ArrayList<>();
        for (int i = 0; i < wallsIds.size(); i++) {
            if (i == 0) {
                uniqueWallsIds.add(wallsIds.get(i));
            } else {
                boolean flag = true;
                for (int j = 0; j < uniqueWallsIds.size(); j++) {
                    if(!uniqueWallsIds.get(j).equals(wallsIds.get(i))){

                    } else {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    uniqueWallsIds.add(wallsIds.get(i));
                }
            }
        }

        return uniqueWallsIds.size();
    }

    public static void main(String[] args) {
        Window.setHeight(1f);
        Window bedRoomWindow = new Window(1, 1.2f);
        List<Window> bedRoomWindows = new ArrayList<>();
        bedRoomWindows.add(bedRoomWindow);

        Window livingRoomWindow = new Window(2, 1.3f);
        List<Window> livingRoomWindows = new ArrayList<>();
        livingRoomWindows.add(livingRoomWindow);

        Door.setHeight(2f);
        Door enteranceDoor = new Door(3, 0.8f);
        List<Door> hallDoors = new ArrayList<>();
        hallDoors.add(enteranceDoor);

        Door bedRoomDoor = new Door(4, 0.7f);
        List<Door> bedRoomDoors = new ArrayList<>();
        bedRoomDoors.add(bedRoomDoor);
        hallDoors.add(bedRoomDoor);

        Door livingRoomDoor = new Door(5, 0.7f);
        List<Door> livingRoomDoors = new ArrayList<>();
        livingRoomDoors.add(livingRoomDoor);
        hallDoors.add(livingRoomDoor);

        Wall.setHeight(2.55f);
        Wall bedRoomWallA = new Wall(6, 4);
        Wall bedRoomWallB = new Wall(7, 2);
        Wall bedRoomWallC = new Wall(8, 4);
        Wall bedRoomWallD = new Wall(9, 2);
        List<Wall> bedRoomWalls = new ArrayList<>(Arrays.asList(bedRoomWallA, bedRoomWallB, bedRoomWallC, bedRoomWallD));

        Wall hallWallA = new Wall(8, 4);
        Wall hallWallB = new Wall(10, 1);
        Wall hallWallC = new Wall(11, 4);
        Wall hallWallD = new Wall(12, 1);
        List<Wall> hallWalls = new ArrayList<>(Arrays.asList(hallWallA, hallWallB, hallWallC, hallWallD));

        Wall livingRoomWallA = new Wall(11, 4);
        Wall livingRoomWallB = new Wall(13, 3);
        Wall livingRoomWallC = new Wall(14, 4);
        Wall livingRoomWallD = new Wall(15, 3);
        List<Wall> livingRoomWalls = new ArrayList<>(Arrays.asList(livingRoomWallA, livingRoomWallB, livingRoomWallC, livingRoomWallD));

        Room livingRoom = new Room(RoomType.LIVING_ROOM, livingRoomWalls, livingRoomDoors, livingRoomWindows);
        Room bedRoom = new Room(RoomType.BED_ROOM, bedRoomWalls, bedRoomDoors, bedRoomWindows);
        Room hall = new Room(RoomType.HALL, hallWalls, hallDoors, null);

        Flat myFlat = new Flat();
        myFlat.rooms.addAll(Arrays.asList(livingRoom, bedRoom, hall));
        System.out.println(myFlat.countWalls());
        System.out.println(myFlat.getFlatSquare());
    }
}
