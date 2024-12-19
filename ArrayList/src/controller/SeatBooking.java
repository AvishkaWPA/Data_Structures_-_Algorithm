package controller;

import Model.Seat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeatBooking {
    // List to store bookings
    private List<Seat> bookedSeatsList;
    // Constructor
    public SeatBooking() {
        // Initialize the list of booked seats
        // TODO 1 : this.bookedSeatsList = ?
        bookedSeatsList = new ArrayList<>(5);
    }
    // Method to add a new seat booking
    public void addNewBooking(String seatNumber) {
        // TODO 2: check if the seat is already booked and not canceled
        // TODO 3 create a new Seat object for the booking,
        // mark the seat as booked,
        // set the current date as the booking date
        // TODO 4: add the new seat to the bookedSeatsList
        // TODO 5: confirm the booking to the user
        for(Seat seat:bookedSeatsList){
            if(seat.getSeatNumber().equals(seatNumber)){
                if(seat.isBooked()) {
                    System.out.println("Seat is already booked");
                    return;
                }else{
                    seat.setBooked(true);
                    System.out.println("Seat "+seatNumber+" has been successfully booked!");
                    return;
                }
            }
        }
        Seat newBooking = new Seat(seatNumber);
        newBooking.setBooked(true);
        newBooking.setBookingDate(new Date());
        bookedSeatsList.add(newBooking);
        System.out.println("Seat "+seatNumber+" has been successfully booked!");
    }

    // Method to cancel a booking
    public void cancelBooking(String seatNumber) {
        // TODO 6: iterate through the list of booked seats
        // TODO 7: check if the seat number matches and is not already canceled
        // mark the seat as canceled
        // mark the seat as not booked
        // confirm the cancellation to the user
        // TODO 8: inform the user if no booking was found for the seat number
        for(Seat seat:bookedSeatsList){
            if(seat.getSeatNumber().equals(seatNumber)){
                if(!seat.isCanceled()){
                    seat.setCanceled(true);
                    seat.setBooked(false);
                    System.out.println("Booking cancelled successful");
                    return;
                }
            }
        }
        System.out.println("No booking for given seat number");
    }
    // Method to update a booking seat number
    public void updateBooking(String oldSeatNumber, String newSeatNumber) {
        // TODO 9: iterate through the list of booked seats
        // TODO 10: check if the seat number matches the old seat number and is not canceled
        // TODO 11: update the seat number to the new seat number
        // confirm the update to the user
        // TODO 12: inform the user if no booking was found for the old seat number
        for(Seat seat:bookedSeatsList){
            if(seat.getSeatNumber().equals(oldSeatNumber)){
                if(!seat.isCanceled()){
                    seat.setSeatNumber(newSeatNumber);
                    System.out.println("Booking update successful");
                    return;
                }
            }
        }
        System.out.println("No booking found for old seat number");
    }

    // Method to remove a booking
    public void removeBooking(String seatNumber) {
        for (Seat seat : bookedSeatsList) {
            // TODO 5: Check if the current seat's seatNumber matches the one provided
            // TODO 6: If a match is found, remove the seat from the bookedSeatsList and print a confirmation message
            if(seat.getSeatNumber().equals(seatNumber)){
                bookedSeatsList.remove(seat);
                System.out.println("Seat " + seatNumber + " has been successfully removed!");
                return;
            }
        }
        System.out.println("No matching seat is found");
    }
    // TODO 7: If no matching seat is found, print a message indicating that the seat was not found


    // Method to display all bookings
    public void displayBookings() {
        // TODO 13: check if the bookedSeatsList is empty, inform the user that no bookings have been made yet
        // TODO 14: iterate through the list of booked seats, Check if the seat is booked and not canceled
        // TODO 15: display the seat number and booking date
        if(bookedSeatsList.isEmpty()) {
            System.out.println("No booking have been made yet");
            return;
        }

        for (Seat seat:bookedSeatsList){
            if(seat.isBooked() && !seat.isCanceled()){
                System.out.println("seat number : "+seat.getSeatNumber()+":"+seat.getBookingDate());
            }
        }

    }
}
