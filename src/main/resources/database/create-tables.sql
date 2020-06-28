create table client(
    id serial primary key not null,
    username varchar(30) not null,
    password varchar(30) not null,
    first_name varchar(30),
    second_name varchar(30)
);

create table account_number(
    number serial primary key not null,
    client_id integer not null,
    foreign key (client_id) references client,
    type varchar(20) not null,
    count double precision not null
);

create table transaction_history(
    id serial primary key not null,
    sender_id integer not null,
    foreign key (sender_id) references account_number,
    receiver_id integer not null,
    foreign key (receiver_id) references account_number,
    count double precision not null,
    date timestamp not null
);

create table token(
    id serial primary key not null,
    token varchar(100) not null,
    client_id integer not null,
    foreign key (client_id) references client,
    type varchar(30) not null
)