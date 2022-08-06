create or replace table category
(
    id          bigint auto_increment
        primary key,
    parent_id   bigint       null,
    depth       int          not null,
    name        varchar(100) not null,
    created_at  datetime     not null,
    modified_at datetime     null,
    deleted_at  datetime     null
);

create or replace table item
(
    id               bigint auto_increment
        primary key,
    member_id        bigint       not null,
    item_category_id bigint       null,
    title            varchar(255) not null,
    content          text         null,
    thumbnail        text         null,
    price_goal       bigint       null,
    created_at       datetime     not null,
    modified_at      datetime     null,
    deleted_at       datetime     null
);

create or replace table item_category
(
    id          bigint auto_increment
        primary key,
    item_id     bigint   not null,
    category_id bigint   not null,
    created_at  datetime not null,
    modified_at datetime null,
    deleted_at  datetime null
);

create or replace table item_html
(
    id             bigint auto_increment
        primary key,
    item_id        bigint   not null,
    item_url       text     not null,
    price_html_tag text     not null,
    created_at     datetime not null,
    modified_at    datetime null,
    deleted_at     datetime null
);

create or replace table item_image
(
    id          bigint auto_increment
        primary key,
    item_id     bigint       not null,
    name        varchar(500) null,
    url         text         null,
    size        bigint       null,
    resize_name varchar(500) null,
    resize_url  text         null,
    resize_size bigint       null,
    created_at  datetime     not null,
    modified_at datetime     null,
    deleted_at  datetime     null
);

create or replace table item_price_history
(
    id          bigint auto_increment
        primary key,
    item_id     bigint   not null,
    price       bigint   null,
    created_at  datetime not null,
    modified_at datetime null,
    deleted_at  datetime null
);

