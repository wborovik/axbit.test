create sequence if not exists hibernate_sequence start 1 increment 1;

create table if not exists author
(
    id          bigint  not null primary key,
    first_name  varchar not null,
    middle_name varchar,
    last_name   varchar not null,
    birth_date  date,
    created     timestamp(6),
    changed     timestamp(6)
);

create table if not exists genre
(
    id          bigint  not null primary key,
    description varchar not null,
    created     timestamp(6),
    changed     timestamp(6)
);

create table if not exists book
(
    id        bigint  not null primary key,
    title     varchar,
    isbn      varchar not null,
    genre_id  bigint,
    author_id bigint,
    created   timestamp(6),
    changed   timestamp(6)
);
alter table if exists book add constraint book_genre_fk foreign key (genre_id) references genre;
alter table if exists book add constraint book_author_fk foreign key (author_id) references author;