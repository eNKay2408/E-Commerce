-- The database and tables will be created automatically by Hibernate when the application starts.
-- So you don't need to create the tables manually in the database.
-- After application starts, you only need run this script to insert some sample data into the tables.

-- Encrypt the password using BCrypt. Here is a default admin user:
-- Email: admin@enkay.live
-- Password: password

USE ecommerce;

INSERT INTO category(category_id, name) VALUES
(1, 'Laptops'),
(2, 'Smartphones'),
(3, 'Tablets'),
(4, 'Accessories'),
(5, 'Software');

INSERT INTO product(id, name, category_id, price, weight, description, image_name) VALUES
(1, 'MacBook Pro 16-inch', 1, 2500, 2.0, 'High-performance laptop with Apple M1 Pro chip, designed for professionals in creative fields.', 'macbook-pro.png'),
(2, 'Dell XPS 13', 1, 1400, 1.2, 'Ultraportable laptop with 13-inch display, Intel Core i7, and a sleek design, perfect for business and travel.', 'dell-xps.png'),
(3, 'iPhone 11 Pro', 2, 999, 0.19, 'It features a stunning Super Retina XDR display, a powerful A13 Bionic chip, and a triple-camera system that takes your photos and videos to the next level.', 'iphone-11.png'),
(4, 'Samsung Galaxy S23 Ultra', 2, 1300, 0.22, 'Premium Android smartphone with a 6.8-inch AMOLED display, Snapdragon 8 Gen 2, and a 200MP camera.', 'samsung-S23.png'),
(5, 'iPad Pro 12.9-inch', 3, 1099, 0.68, 'The most powerful and advanced iPad Pro yet, with the M1 chip, 12.9-inch Liquid Retina XDR display, and 5G connectivity.', 'ipad-pro.png'),
(6, 'Samsung Galaxy Tab S8', 3, 899, 0.57, 'Android tablet with a 14.6-inch Super AMOLED display, Snapdragon 8 Gen 2, and S Pen support.', 'samsung-tab.png'),
(7, 'Apple AirPods Pro', 4, 249, 0.05, 'Wireless earbuds with active noise cancellation, transparency mode, and customizable fit for all-day comfort.', 'airpods-pro.png'),
(8, 'Logitech MX Master 3', 4, 99, 0.14, 'Advanced wireless mouse with a precision scroll wheel, customizable buttons, and ergonomic design for productivity.', 'logitech-mx.png'),
(9, 'Microsoft Office 365', 5, 69, 0.0, 'Subscription-based productivity suite with Word, Excel, PowerPoint, Outlook, and OneDrive.', 'microsoft-office.png'),
(10, 'Adobe Creative Cloud', 5, 52, 0.0, 'Subscription-based creative suite with Photoshop, Illustrator, InDesign, Premiere Pro, and After Effects.', 'adobe-creative.png');