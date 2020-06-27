create table client(
    id serial primary key not null,
    username varchar(30) not null,
    password varchar(30) not null,
    first_name varchar(30),
    second_name varchar(30),
    token varchar(100)
);

create table account_number(
    number serial primary key not null,
    client_id integer not null,
    foreign key (client_id) references client,
    type varchar(20) not null,
    count numeric not null
);

create table translation_history(
    id serial primary key not null,
    sender_id integer not null,
    foreign key (sender_id) references account_number,
    receiver_id integer not null,
    foreign key (receiver_id) references account_number,
    count numeric not null,
    date timestamp not null
);