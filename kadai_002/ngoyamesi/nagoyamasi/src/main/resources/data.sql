-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_GENERAL_PAID');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- categoriesテーブル
INSERT IGNORE INTO categories (id, name) VALUES (1 , '中華料理');
INSERT IGNORE INTO categories (id, name) VALUES (2 , 'パスタ');
INSERT IGNORE INTO categories (id, name) VALUES (3 , 'ピザ');
INSERT IGNORE INTO categories (id, name) VALUES (4 , 'うどん');
INSERT IGNORE INTO categories (id, name) VALUES (5 , '天ぷら');

-- usersテーブル
INSERT IGNORE INTO users (id, role_id, name, furigana, age, post_code, address, email_address, telephone_number, password, enabled) VALUES(1, 1, '高梨綾香', 'タカナシ アヤカ', 30, '123-4567', '東京都渋谷区神南1-2-3', '.com', '123-456-7890', 'password123', 'true');
INSERT IGNORE INTO users (id, role_id, name, furigana, age, post_code, address, email_address, telephone_number, password, enabled) VALUES(2, 2, '佐藤投機', 'サトウ トウキ', 25, '987-6543', '大阪府大阪市北区梅田4-5-6', 'jane@example.com', '987-654-3210', 'password456', 'true');
INSERT IGNORE INTO users (id, role_id, name, furigana, age, post_code, address, email_address, telephone_number, password, enabled) VALUES(3, 3, '田中太郎', 'タナカ タロウ', 35, '543-2167', '京都府京都市中京区河原町7-8-9', 'alice@example.com', '567-890-1234', 'password789', 'false');


-- reservationsテーブル
INSERT IGNORE INTO reservations (id,user_id, restaurant_id, reservation_day, reservation_time, reservation_number_people) VALUES (1,1, 1, '2024-03-02', '18:00:00', 2);
INSERT IGNORE INTO reservations (id,user_id, restaurant_id, reservation_day, reservation_time, reservation_number_people) VALUES (2,2, 2, '2024-03-04', '19:00:00', 3);
INSERT IGNORE INTO reservations (id,user_id, restaurant_id, reservation_day, reservation_time, reservation_number_people) VALUES (3,3, 3, '2024-03-02', '18:00:00', 4);
INSERT IGNORE INTO reservations (id,user_id, restaurant_id, reservation_day, reservation_time, reservation_number_people) VALUES (4,1, 2, '2024-03-30', '18:00:00', 2);

-- reviewsテーブル
INSERT IGNORE INTO reviews (id,restaurant_id, user_id, number_stars, comment) VALUES (1,1, 1, 4, 'とてもおいしかった。');
INSERT IGNORE INTO reviews (id,restaurant_id, user_id, number_stars, comment) VALUES (2,3, 2, 4, 'また行きたい。');
INSERT IGNORE INTO reviews (id,restaurant_id, user_id, number_stars, comment) VALUES (3,2, 3, 2, '料理はおいしかったがサービスがいまいちだった。');

-- restaurants
INSERT IGNORE INTO restaurants (id,image_name, name, address, opening_hours, telephone_number, category_id, regular_closing, description) VALUES (1,'piza.jpg', 'pizaPIZA', '愛知県名古屋市中区栄1-1-1', '8:00-22:00', '123-456-7890', 3, '日曜日', 'とてもおいしくもちもちでえす');
INSERT IGNORE INTO restaurants (id,image_name, name, address, opening_hours, telephone_number, category_id, regular_closing, description) VALUES (2,'udon.jpg', 'うどーん', '愛知県名古屋市千種区今池2-2-2', '10:00-23:00', '547-456-7890', 4, '日曜日', 'つるっとジューシ');
INSERT IGNORE INTO restaurants (id,image_name, name, address, opening_hours, telephone_number, category_id, regular_closing, description) VALUES (3,'tenpura.jpg', 'ぷら天', '愛知県名古屋市東区東桜1-3-5', '11:00-21:00', '547-456-7890', 5, '水曜日', 'かりっと');

-- company_identification
INSERT IGNORE INTO company_identification (id,company_name, representative_director, date_establishment, address, telephone_number, business_content) VALUES(1,'ABC株式会社', '田中太郎', 2000, '東京都渋谷区1-1-1', 1234567890, '料理コンサルティング');
