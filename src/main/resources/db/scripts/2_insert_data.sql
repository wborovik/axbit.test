insert into author (id, first_name, middle_name, last_name, birth_date, created, changed)
values (1000, 'Александр', 'Сергеевич', 'Пушкин', '1799-06-06', now(), null);

insert into author (id, first_name, middle_name, last_name, birth_date, created, changed)
values (1001, 'Иван', 'Сергеевич', 'Тургенев', '1818-10-28', now(), null);

insert into author (id, first_name, middle_name, last_name, birth_date, created, changed)
values (1002, 'Корней', 'Иванович', 'Чуковский', '1882-03-19', now(), null);

insert into author (id, first_name, middle_name, last_name, birth_date, created, changed)
values (1003, 'Антон', 'Павлович', 'Чехов', '1860-01-17', now(), null);


insert into genre (id, description, created, changed)
values (1004, 'Отечественная поэзия для детей', now(), null);

insert into genre (id, description, created, changed)
values (1005, 'Сказки отечественных писателей', now(), null);

insert into genre (id, description, created, changed)
values (1006, 'Произведения школьной программы', now(), null);

insert into genre (id, description, created, changed)
values (1007, 'Философская художественная литература', now(), null);


insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1008, 'Сказки Пушкина', '978-5-91045-966-7', 1005, 1000, now(), null);

insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1009, 'Капитанская дочка', '978-5-9287-3324-7', 1006, 1000, now(), null);

insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1010, 'Отцы и дети', '978-5-9268-2711-5', 1007, 1001, now(), null);

insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1011, 'Сказки и стихи', '9785001928379', 1004, 1002, now(), null);

insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1012, 'Железнодорожные рассказы', '978-5-94887-134-9', 1006, 1003, now(), null);

insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1013, 'Палата № 6', '978-5-389-23268-6', 1007, 1003, now(), null);

insert into book (id, title, isbn, genre_id, author_id, created, changed)
values (1014, 'Записки Охотника', '978-5-9268-2869-3', 1006, 1001, now(), null);