// Question 7: Synchronized Method: Create a ticket booking system where multiple users (threads) attempt to book tickets simultaneously. Use synchronization to prevent overselling of tickets.

class TicketCounter {
    private int availableSeats;

    public TicketCounter(int initialSeats) {
        this.availableSeats = initialSeats;
    }

    // Synchronized method: Only one thread can execute this method at a time on this instance
    public synchronized boolean bookTicket(String passengerName, int seatsRequested) {
        System.out.println("\n[Booking Request] Passenger: " + passengerName + " | Requested: " + seatsRequested + " seats");
        System.out.println("  Available seats before booking: " + availableSeats);

        if (seatsRequested <= availableSeats) {
            // Simulate processing time
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            availableSeats -= seatsRequested;
            System.out.println("  [SUCCESS] Booking confirmed for " + passengerName + " (" + seatsRequested + " seats). Remaining: " + availableSeats);
            return true;
        } else {
            System.out.println("  [FAILED] Not enough seats for " + passengerName + "! Requested: " + seatsRequested + ", Available: " + availableSeats);
            return false;
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

class PassengerBookingTask implements Runnable {
    private final TicketCounter counter;
    private final String passengerName;
    private final int seats;

    public PassengerBookingTask(TicketCounter counter, String passengerName, int seats) {
        this.counter = counter;
        this.passengerName = passengerName;
        this.seats = seats;
    }

    @Override
    public void run() {
        counter.bookTicket(passengerName, seats);
    }
}

public class Q07_TicketBookingSyncMethod {
    public static void main(String[] args) {
        System.out.println("--- Section 2: Thread Synchronization ---");
        System.out.println("--- Q7: Ticket Booking System using Synchronized Method ---\n");

        int initialTotalSeats = 6;
        TicketCounter counter = new TicketCounter(initialTotalSeats);
        System.out.println("Initial Total Seats Available: " + initialTotalSeats);

        // Multiple passenger threads attempting concurrent booking
        Thread p1 = new Thread(new PassengerBookingTask(counter, "Mohd Ahsan", 2), "Thread-Ahsan");
        Thread p2 = new Thread(new PassengerBookingTask(counter, "Zaid Khan", 3), "Thread-Zaid");
        Thread p3 = new Thread(new PassengerBookingTask(counter, "Hamza Ali", 2), "Thread-Hamza");
        Thread p4 = new Thread(new PassengerBookingTask(counter, "Bilal Ahmed", 1), "Thread-Bilal");

        // Starting all booking threads concurrently
        p1.start();
        p2.start();
        p3.start();
        p4.start();

        // Wait for all bookings to finish
        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nFinal Available Seats at Counter: " + counter.getAvailableSeats());
        System.out.println();
        System.out.println("This program is a part of Mohd. Ahsan's assignment");
    }
}
