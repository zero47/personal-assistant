create table core_user
(
    user_id          serial
        primary key,
    nickname         varchar(50)             not null,
    encrypt_password varchar(64)             not null,
    create_time      timestamp default now() not null,
    token            char(64)
);

create table core_memo
(
    memo_id          serial
        primary key,
    user_id          integer                 not null,
    content          varchar(1024)           not null,
    create_time      timestamp default now() not null,
    last_update_time timestamp
);
