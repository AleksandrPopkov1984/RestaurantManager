DELETE
FROM meals;
DELETE
FROM restaurants;
DELETE
FROM user_roles;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (surname, name, email, password)
VALUES ('Igor', 'Vasiljev', 'i_vasiljev@gmail.com', '1234'),
       ('Andrej', 'Nikolaev', 'a_nikolaev@gmail.com', '4321'),
       ('Sergej', 'Anisimov', 's_anisimov@gmail.com', 'password'),
       ('Olga', 'Borodina', 'o_borodina@gmail.com', 'password'),
       ('Dmitry', 'Kolesnikov', 'd_kolesnikov@gmail.com', 'password'),
       ('Irina', 'Anishenko', 'i_anishenko@gmail.com', 'password'),
       ('Aleksandr', 'Solomatin', 'a_solomatin@gmail.com', 'password');

INSERT INTO user_roles(user_id, role)
VALUES (100000, 'ADMIN'),
       (100000, 'USER'),
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

INSERT INTO meals (name, price, restaurant_id)
VALUES ('Chicken and Bacon', 200, 100007),
       ('Steak and Onion Ciabatta', 300, 100007),
       ('Sausage and Onion Sandwich', 250, 100008),
       ('Lamb & Apricot Curry', 600, 100008),
       ('Roasted Chicken Legs', 400, 100009),
       ('Sweet & Sour Pork', 200, 100009),
       ('Fish Fingers', 310, 100010),
       ('Mixed Salad', 550, 100010),
       ('Ginger Sponge Pudding', 480, 100011),
       ('Baked Beans', 150, 100011);