DELETE
FROM votes;
DELETE
FROM meals;
DELETE
FROM menus;
DELETE
FROM restaurants;
DELETE
FROM user_roles;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (surname, name, email, password)
VALUES ('AdminSurname', 'AdminName', 'admin@gmail.com', 'admin'),
       ('Nikolaev', 'Andrej', 'a_nikolaev@gmail.com', 'admin'),
       ('UserSurname', 'UserName', 'user@gmail.com', 'password'),
       ('Borodina', 'Olga', 'o_borodina@gmail.com', 'password'),
       ('Kolesnikov', 'Dmitry', 'd_kolesnikov@gmail.com', 'password'),
       ('Anishenko', 'Irina', 'i_anishenko@gmail.com', 'password'),
       ('Solomatin', 'Aleksandr', 'a_solomatin@gmail.com', 'password');

INSERT INTO user_roles(user_id, role)
VALUES (100000, 'ADMIN'),
       (100001, 'ADMIN'),
       (100002, 'USER'),
       (100003, 'USER'),
       (100004, 'USER'),
       (100005, 'USER'),
       (100006, 'USER');

INSERT INTO restaurants (name)
VALUES ('Metropol'),
       ('Tokio'),
       ('Art-Caviar'),
       ('Karl and Fridrich'),
       ('Russian fishing');

INSERT INTO menus(date, restaurant_id)
VALUES ('2022-12-20', 100007),
       ('2022-12-20', 100008),
       ('2022-12-20', 100009),
       ('2022-12-20', 100010),
       ('2022-12-21', 100011);

INSERT INTO meals (name, price, menu_id)
VALUES ('Chicken and Bacon', 200, 100012),
       ('Steak and Onion Ciabatta', 300, 100012),
       ('Sausage and Onion Sandwich', 250, 100013),
       ('Lamb & Apricot Curry', 600, 100013),
       ('Roasted Chicken Legs', 400, 100014),
       ('Sweet & Sour Pork', 200, 100014),
       ('Fish Fingers', 310, 100015),
       ('Mixed Salad', 550, 100015),
       ('Ginger Sponge Pudding', 480, 100016),
       ('Baked Beans', 150, 100016);

INSERT INTO votes (user_id, restaurant_id, date, time)
VALUES (100002, 100007, '2022-12-25', '10:00:00'),
       (100005, 100010, '2022-12-25', '12:30:00');