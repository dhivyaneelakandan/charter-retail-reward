CREATE TABLE customer_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    mobile VARCHAR(20) NOT NULL,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price BIGINT NOT NULL,
    description TEXT
);

CREATE TABLE transaction (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount BIGINT NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer_info(id)
);
CREATE TABLE transaction_item (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    transaction_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price_at_purchase DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES transaction(id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);
CREATE TABLE reward (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    points INT NOT NULL,
    transaction_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (transaction_id) REFERENCES transaction(id)
);

INSERT INTO customer_info (id, email, mobile, name) VALUES 
(1, 'alice@example.com', '9876543210', 'Alice Johnson'),
(2, 'bob@example.com', '9123456780', 'Bob Smith'),
(3, 'charlie@example.com', '9567891234', 'Charlie Brown');

INSERT INTO item (id, name, price, description) VALUES 
(1, 'Smartphone', 15000, 'Android phone with 128GB storage'),
(2, 'Tablet', 25000, '10-inch tablet with stylus support'),
(3, 'Headphones', 10000, 'Noise-canceling wireless headphones');

INSERT INTO transaction (id, amount, transaction_date, customer_id) VALUES 
(1, 15000, '2025-05-09 10:00:00', 1),
(2, 25000, '2025-05-09 10:30:00', 2),
(3, 10000, '2025-05-09 11:00:00', 3);

INSERT INTO transaction_item (id, transaction_id, item_id, quantity, price_at_purchase, subtotal) 
VALUES (1, 1, 1, 1, 50000, 50000);
INSERT INTO reward (id, points, transaction_id) VALUES (1, 100, 1);

INSERT INTO reward (id, points, transaction_id) VALUES 
(1, 75, 1),
(2, 125, 2),
(3, 50, 3);

