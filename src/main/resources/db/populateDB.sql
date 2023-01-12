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
       ('Николаев', 'Андрей', 'a_nikolaev@gmail.com', 'admin'),
       ('UserSurname', 'UserName', 'user@gmail.com', 'password'),
       ('Бородина', 'Ольга', 'o_borodina@gmail.com', 'password'),
       ('Колесников', 'Дмитрий', 'd_kolesnikov@gmail.com', 'password'),
       ('Анищенко', 'Ирина', 'i_anishenko@gmail.com', 'password'),
       ('Соломатин', 'Александр', 'a_solomatin@gmail.com', 'password');

INSERT INTO user_roles(user_id, role)
VALUES (100000, 'ADMIN'),
       (100001, 'ADMIN'),
       (100002, 'USER'),
       (100003, 'USER'),
       (100004, 'USER'),
       (100005, 'USER'),
       (100006, 'USER');

INSERT INTO restaurants (name)
VALUES ('Метрополь'),
       ('Токио Сити'),
       ('Сыроварня'),
       ('Карл и Фридрих'),
       ('Русская рыбалка');

INSERT INTO menus(date, restaurant_id)
VALUES ('2022-12-20', 100007),
       ('2022-12-20', 100008),
       ('2022-12-20', 100009),
       ('2022-12-20', 100010),
       ('2022-12-21', 100011);

INSERT INTO meals (name, price, menu_id)
VALUES ('Куриный бульон', 260, 100012),
       ('Солянка мясная', 390, 100012),
       ('Уха из ладожского судака', 760, 100012),
       ('Рыбные котлеты с соусом по-польски', 600, 100012),
       ('Медальоны из лосося с овощами', 950, 100012),
       ('Том Ям с морепродуктами', 530, 100013),
       ('Филадельфия Люкс', 580, 100013),
       ('Ролл Запеченый краб', 300, 100013),
       ('Борщ', 680, 100014),
       ('Стейк Рибай', 1350, 100014),
       ('Шашлык куриный', 1000, 100014),
       ('Салат из овощей', 450, 100015),
       ('Цезарь с креветками', 780, 100015),
       ('Мюнхенские колбаски', 750, 100015),
       ('Филе семги', 2000, 100015),
       ('Уха из трех видов рыбы', 780, 100016),
       ('Котлеты из щуки', 920, 100016);

INSERT INTO votes (user_id, restaurant_id, date, time)
VALUES (100002, 100007, '2022-12-25', '10:00:00'),
       (100005, 100010, '2022-12-25', '12:30:00');