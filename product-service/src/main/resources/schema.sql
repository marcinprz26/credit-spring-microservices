CREATE TABLE IF NOT EXISTS product (
    credit_id char(36) NOT NULL,
    name varchar(150) NOT NULL,
    value numeric(2),

    constraint product_pk primary key(credit_id)
);

