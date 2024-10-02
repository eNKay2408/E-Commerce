-- The database and tables will be created automatically by Hibernate when the application starts.
-- So you don't need to create the tables manually in the database.
-- After application starts, you only need run this script to insert some sample data into the tables.

-- Encrypt the password using BCrypt. Here is a default admin user:
-- Email: admin@enkay.live
-- Password: password

USE ecommerce;

INSERT INTO category(name) VALUES
('Laptops'),
('Smartphones'),
('Tablets'),
('Accessories'),
('Software');

INSERT INTO product(name, category_id, price, weight, description, image_name) VALUES
('MacBook Pro 16-inch', 13, 2500, 2.0, 'High-performance laptop with Apple M1 Pro chip, designed for professionals in creative fields.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329426/ECommerce/macbook-pro.png'),
('Dell XPS 13', 13, 1400, 1.2, 'Ultraportable laptop with 13-inch display, Intel Core i7, and a sleek design, perfect for business and travel.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329427/ECommerce/dell-xps.png'),
('iPhone 11 Pro', 14, 999, 0.19, 'It features a stunning Super Retina XDR display, a powerful A13 Bionic chip, and a triple-camera system that takes your photos and videos to the next level.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329424/ECommerce/iphone-11.png'),
('Samsung Galaxy S23 Ultra', 14, 1300, 0.22, 'Premium Android smartphone with a 6.8-inch AMOLED display, Snapdragon 8 Gen 2, and a 200MP camera.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329425/ECommerce/samsung-S23.png'),
('iPad Pro 12.9-inch', 15, 1099, 0.68, 'The most powerful and advanced iPad Pro yet, with the M1 chip, 12.9-inch Liquid Retina XDR display, and 5G connectivity.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329426/ECommerce/ipad-pro.png'),
('Samsung Galaxy Tab S8', 15, 899, 0.57, 'Android tablet with a 14.6-inch Super AMOLED display, Snapdragon 8 Gen 2, and S Pen support.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329368/ECommerce/samsung-tab.png'),
('Apple AirPods Pro', 16, 249, 0.05, 'Wireless earbuds with active noise cancellation, transparency mode, and customizable fit for all-day comfort.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329394/ECommerce/airpods-pro.png'),
('Logitech MX Master 3', 16, 99, 0.14, 'Advanced wireless mouse with a precision scroll wheel, customizable buttons, and ergonomic design for productivity.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329424/ECommerce/logitech-mx.png'),
('Microsoft Office 365', 17, 69, 0.0, 'Subscription-based productivity suite with Word, Excel, PowerPoint, Outlook, and OneDrive.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329425/ECommerce/microsoft-office.png'),
('Adobe Creative Cloud', 17, 52, 0.0, 'Subscription-based creative suite with Photoshop, Illustrator, InDesign, Premiere Pro, and After Effects.', 'https://res.cloudinary.com/dvzhmi7a9/image/upload/v1727329423/ECommerce/adobe-creative.png');