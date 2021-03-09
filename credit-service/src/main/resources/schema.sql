CREATE TABLE IF NOT EXISTS credit (
    id numeric(20) NOT NULL,
    name varchar(150) NOT NULL,

    constraint credit_pk primary key(id),
);

CREATE TABLE IF NOT EXISTS customer (
    credit_id numeric(20) NOT NULL,
    first_name varchar(150) NOT NULL,
    last_name varchar(150) NOT NULL,
    pesel integer NOT NULL,

    constraint customer_pk primary key(credit_id),
    constraint credit_fk foreign key(credit_id) references credit(id)
);

CREATE TABLE IF NOT EXISTS product (
    credit_id numeric(20) NOT NULL,
    name varchar(150) NOT NULL,
    value numeric(2),

    constraint product_pk primary key(credit_id),
    constraint credit_fk foreign key(credit_id) references credit(id)
);

