CREATE TABLE IF NOT EXISTS customer (
    credit_id char(36) NOT NULL,
    first_name varchar(150) NOT NULL,
    last_name varchar(150) NOT NULL,
    pesel integer NOT NULL,

    constraint customer_pk primary key(credit_id)
);

