CREATE TABLE IF NOT EXISTS customer (
    id numeric(20) NOT NULL,
    first_name varchar(150) NOT NULL,
    last_name varchar(150) NOT NULL,
    pesel integer NOT NULL,

    constraint customer_pk primary key(id),
);

CREATE TABLE IF NOT EXISTS product (
    id numeric(20) NOT NULL,
    name varchar(150) NOT NULL,
    value numeric(2),

    constraint product_pk primary key(id),
);

CREATE TABLE IF NOT EXISTS credit (
    id numeric(20) NOT NULL,
    name varchar(150) NOT NULL,
    product_id numeric(20) NOT NULL,
    customer_id numeric(20) NOT NULL

    constraint credit_pk primary key(id),
    constraint product_fk foreign key(product_id) references product(id),
    constraint customer_fk foreign key(customer_id) references customer(id),
);