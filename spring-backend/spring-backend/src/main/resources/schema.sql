CREATE TABLE IF NOT EXISTS users (
    user_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS flights (
    flight_id BIGSERIAL PRIMARY KEY,
    airline VARCHAR(255) NOT NULL,
    departure VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    date VARCHAR(255) NOT NULL,
    time VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    seats_available INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS bookings (
    booking_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(user_id),
    flight_id BIGINT NOT NULL REFERENCES flights(flight_id),
    payment_status VARCHAR(255) NOT NULL,
    booking_date VARCHAR(255) NOT NULL,
    seat_number VARCHAR(255),
    class_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS payments (
    payment_id BIGSERIAL PRIMARY KEY,
    booking_id BIGINT NOT NULL REFERENCES bookings(booking_id),
    user_id BIGINT NOT NULL REFERENCES users(user_id),
    amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(255) NOT NULL,
    payment_method VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS airports (
    airport_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tickets (
    ticket_id BIGSERIAL PRIMARY KEY,
    booking_id BIGINT NOT NULL REFERENCES bookings(booking_id),
    seat_number VARCHAR(255),
    class_type VARCHAR(255),
    status VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS passengers (
    passenger_id BIGSERIAL PRIMARY KEY,
    booking_id BIGINT NOT NULL REFERENCES bookings(booking_id),
    name VARCHAR(255) NOT NULL,
    age INTEGER,
    passport_number VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS flight_status (
    status_id BIGSERIAL PRIMARY KEY,
    flight_id BIGINT NOT NULL REFERENCES flights(flight_id),
    departure_time VARCHAR(255),
    arrival_time VARCHAR(255),
    status VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS baggage_allowance (
    baggage_id BIGSERIAL PRIMARY KEY,
    flight_id BIGINT NOT NULL REFERENCES flights(flight_id),
    allowed_weight INTEGER,
    extra_charge_per_kg DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS seat_classes (
    class_id BIGSERIAL PRIMARY KEY,
    flight_id BIGINT NOT NULL REFERENCES flights(flight_id),
    class_type VARCHAR(255),
    price_multiplier DOUBLE PRECISION
); 