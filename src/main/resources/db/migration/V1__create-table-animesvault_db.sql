create table genre(
    id bigint not null auto_increment,
    name varchar(100) not null,
    primary key(id)
);

create table anime(
    id bigint not null auto_increment,
    genre_id bigint not null,
    title varchar(100) not null,
    type varchar(100) not null,
    airing tinyint not null,
    episodes bigint not null,
    score decimal(3, 1) not null,
    synopsis varchar(1000) not null,
    releaseYear bigint not null,

    primary key(id),
    foreign key(genre_id) references genre(id) on delete cascade on update cascade


);

