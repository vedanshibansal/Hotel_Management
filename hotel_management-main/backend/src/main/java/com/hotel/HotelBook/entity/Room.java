package com.hotel.HotelBook.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data // Lombok will generate the getters, setters, toString, equals, and hashCode methods automatically.
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    // Custom setter for roomPhotoUrl
    public void setRoomPhotoUrl(String roomPhotoUrl) {
        this.roomPhotoUrl = roomPhotoUrl;
    }

    // Custom setter for roomType
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Custom setter for roomPrice
    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    // Custom setter for roomDescription
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    // Getter for bookings list
    public List<Booking> getBookings() {
        return this.bookings;
    }

    // Optionally, you can also override toString method if necessary
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", roomPrice=" + roomPrice +
                ", roomPhotoUrl='" + roomPhotoUrl + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
