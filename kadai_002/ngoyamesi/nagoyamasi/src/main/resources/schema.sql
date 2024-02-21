CREATE TABLE IF NOT EXISTS roles (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS categories (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	role_id INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	hurigana VARCHAR(50) NOT NULL,
	age INT NOT NULL,
	post_code INT NOT NULL,
	address VARCHAR(255) NOT NULL,
	email_address VARCHAR(50),
	telephone_number INT NOT NULL,
	password VARCHAR(50) NOT NULL,
	enabled VARCHAR(50) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	update_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS verification_tokens(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	token VARCHAR(50) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reservations(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_id INT NOT NULL,
	restaurant_id INT NOT NULL,
	reservation_day INT NOT NULL,
	reservation_time INT NOT NULL,
	reservation_number_people INT NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reviews(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	restaurant_id INT NOT NULL,
	user_id INT NOT NULL,
	number_stars INT NOT NULL,
	comment VARCHAR(150),
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS restaurants(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	image_name VARCHAR(200),
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	opening_hours INT NOT NULL,
	telephone_number INT NOT NULL,
	category_id INT NOT NULL,
	regular_closing INT NOT NULL,
	description VARCHAR(255) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS company_identification(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	company_name VARCHAR(200) NOT NULL,
	representative_director VARCHAR(100) NOT NULL,
	date_establishment INT NOT NULL,
	address VARCHAR(255) NOT NULL,
	telephone_number INT NOT NULL,
	business_content VARCHAR(255) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
