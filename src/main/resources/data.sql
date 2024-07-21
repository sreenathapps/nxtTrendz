-- Insert data into PRODUCT table
INSERT INTO PRODUCT (PRODUCTNAME, PRICE) VALUES
('Smartphone', 599.99),
('Laptop', 1299.99),
('Gaming Console', 399.99);

-- Insert data into REVIEW table
INSERT INTO REVIEW (REVIEWCONTENT, RATING, PRODUCTID) VALUES
('Great battery life!', 5, 1),
('Lags sometimes.', 3, 1),
('Perfect for my daily tasks!', 4, 2),
('Bit pricey, but worth it.', 4, 2),
('Awesome gaming experience!', 5, 3),
('Needs more exclusive games.', 4, 3);