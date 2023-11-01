package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_MakesRoomDirtyAndOccupied_Success(){
        //ARRANGE
        Room room = new Room(2, 19.0);

        //ACT
        room.checkIn();

        //ASSERT
        assertTrue(room.isDirty());
        assertTrue(room.isOccupied());
    }
    @Test
    public void checkOut_MakesRoomUnoccupiedAndDirty_Success(){
        //ARRANGE
        Room room = new Room(2, 19.0);
        room.checkIn();

        //ACT
        room.checkOut();

        //ASSERT
        assertTrue(room.isDirty());
        assertFalse(room.isOccupied());
    }
    @Test
    public void checkIn_WhenOccupied_Error(){
        //ARRANGE
        Room room = new Room(2, 19.0);
        room.checkIn();
        room.checkOut();

        //ACT
        room.checkIn();

        //ASSERT
        assertFalse(room.isOccupied());
    }
    @Test
    public void cleanRoom_WhenOccupied_Error(){
        //ARRANGE
        Room room = new Room(2, 19.0);
        room.checkIn();

        //ACT
        room.cleanRoom();

        //ASSERT
        assertTrue(room.isDirty());
    }

    @Test
    public void cleanRoom_WhenUnoccupied_Success(){
        /*---------------ARRANGE---------------*/
        Room room = new Room(2,19);
        room.checkIn();
        room.checkOut();

        /*--------------ACT-------------*/
        room.cleanRoom();

        /*------------ASSERT------------*/
        assertFalse(room.isDirty());

    }
}