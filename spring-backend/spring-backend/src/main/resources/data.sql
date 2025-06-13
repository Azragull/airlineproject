DELETE FROM bookings;
DELETE FROM tickets;
DELETE FROM users;
DELETE FROM flights;
DELETE FROM payments;
DELETE FROM airports;
DELETE FROM flight_status;
DELETE FROM baggage_allowance;
DELETE FROM seat_classes;
DELETE FROM passengers;

INSERT INTO users (name, email, password, role) VALUES
('Ali Yağız İnce', 'ali@example.com', '1111111', 'admin'),
('Öykü Yüksel', 'oyku@example.com', '2222222', 'customer'),
('Azra Gül', 'azra@example.com', '3333333', 'admin'),
('Belinay Öz', 'belinay@example.com', '4444444', 'customer'),
('Ece Uzal', 'ece@example.com', '5555555', 'customer');

INSERT INTO flights (flight_id, Airline, Departure, Destination, Date, Time, Price, seats_available) VALUES
(1, 'Turkish Airlines', 'Istanbul', 'Berlin', '2025-06-15', '08:30:00', 4500.00, 50),
(2, 'Pegasus', 'Ankara', 'Amsterdam', '2025-06-16', '12:00:00', 3200.00, 40),
(3, 'SunExpress', 'Izmir', 'London', '2025-06-20', '14:00:00', 1100.00, 60),
(4, 'AnadoluJet', 'Antalya', 'Paris', '2025-06-21', '09:45:00', 2400.00, 45),
(5, 'Turkish Airlines', 'Istanbul', 'New York', '2025-06-25', '23:00:00', 10500.00, 30);

INSERT INTO bookings (BookingID, UserID, FlightID, PaymentStatus, BookingDate) VALUES
(1, 2, 1, 'Paid', '2025-06-01'),
(2, 3, 2, 'Pending', '2025-06-01'),
(3, 4, 3, 'Paid', '2025-06-02'),
(4, 5, 4, 'Cancelled', '2025-06-03'),
(5, 2, 5, 'Paid', '2025-06-04');

INSERT INTO payments (PaymentID, BookingID, UserID, Amount, Status, PaymentMethod) VALUES
(1, 1, 2, 1500.00, 'Completed', 'Credit Card'),
(2, 2, 3, 1200.00, 'Pending', 'PayPal'),
(3, 3, 4, 1100.00, 'Completed', 'Bank Transfer'),
(4, 4, 5, 1300.00, 'Failed', 'Credit Card'),
(5, 5, 2, 3500.00, 'Completed', 'PayPal');

INSERT INTO airports (AirportID, Name, Location, Code) VALUES
(1, 'Istanbul Airport', 'Istanbul', 'IST'),
(2, 'Berlin Brandenburg', 'Berlin', 'BER'),
(3, 'Amsterdam Schiphol', 'Amsterdam', 'AMS'),
(4, 'London Heathrow', 'London', 'LHR'),
(5, 'John F. Kennedy Airport', 'New York', 'JFK');

INSERT INTO tickets (TicketID, BookingID, SeatNumber, class_type, Status) VALUES
(1, 1, '12A', 'Economy', 'Confirmed'),
(2, 2, '15B', 'Business', 'Reserved'),
(3, 3, '21C', 'Economy', 'Confirmed'),
(4, 4, '10D', 'First Class', 'Cancelled'),
(5, 5, '5E', 'Business', 'Confirmed');

INSERT INTO passengers (PassengerID, BookingID, Name, Age, PassportNumber) VALUES
(1, 1, 'Öykü Yüksel', 22, 'P12345678'),
(2, 2, 'Azra Gül', 21, 'P87654321'),
(3, 3, 'Belinay Öz', 30, 'P34567891'),
(4, 4, 'Ece Uzal', 28, 'P98765432'),
(5, 5, 'Ali Yağız İnce', 25, 'P19283746');

INSERT INTO flight_status (StatusID, FlightID, DepartureTime, ArrivalTime, Status) VALUES
(1, 1, '08:30:00', '11:00:00', 'On Time'),
(2, 2, '12:00:00', '14:30:00', 'Delayed'),
(3, 3, '14:00:00', '16:30:00', 'On Time'),
(4, 4, '09:45:00', '12:15:00', 'On Time'),
(5, 5, '23:00:00', '06:30:00', 'Cancelled');

INSERT INTO baggage_allowance (BaggageID, FlightID, AllowedWeight, ExtraChargePerKg) VALUES
(1, 1, 20, 15.00),
(2, 2, 15, 20.00),
(3, 3, 23, 18.00),
(4, 4, 20, 17.00),
(5, 5, 25, 25.00);

INSERT INTO seat_classes (ClassID, FlightID, ClassType, PriceMultiplier) VALUES
(1, 1, 'Economy', 1.0),
(2, 1, 'Business', 1.5),
(3, 2, 'Economy', 1.0),
(4, 2, 'First Class', 2.0),
(5, 3, 'Business', 1.8); 