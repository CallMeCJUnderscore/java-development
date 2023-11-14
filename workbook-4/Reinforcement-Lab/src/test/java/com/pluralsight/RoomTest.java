package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void If_BookRoomIsOccupied_ThenPreventBookingAgain() {
        /*-------------ARRANGE-------------*/
        Room room = new Room(1, "Suite");
        Guest guest1 = new Guest("Hannah", 25);
        room.bookRoom(guest1);
        Guest guest2 = new Guest("Jacob", 40);

        /*---------------ACT---------------*/
        boolean toCheck = room.bookRoom(guest2);

        /*-------------ASSERT--------------*/
        assertFalse(toCheck, "Room should not be bookable if occupied");
    }

}