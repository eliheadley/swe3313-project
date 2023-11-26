CREATE TABLE users(
      phone_number varchar(10),
      password varchar(25),
      first_name varchar(20),
      last_name varchar(20),
      payment_method varchar(6),
      delivery_address varchar(80),
      user_type varchar(10)
);

ALTER TABLE users ADD PRIMARY KEY (phone_number);

ALTER TABLE USERS MODIFY phone_number VARCHAR(200);
