CREATE TABLE users(
      phone_number varchar(400),
      password varchar(25),
      first_name varchar(20),
      last_name varchar(20),
      payment_method varchar(6),
      delivery_address varchar(80),
      user_type varchar(10)
);

ALTER TABLE users ADD PRIMARY KEY (phone_number);

ALTER TABLE users ALTER COLUMN password varchar(400);

update users set password = '600000:58ec4cf819c19d45167d8a973603dca4:94a5c2220031151d9b00d43a592d863edb5471b3f85876babbafbe516b472fef2205d60f977d8859f4aeebea929192765836033e1e811887bf52d9cc1dd72b37' where phone_number = '6789770152';
update users set password = '600000:c1bced1beecd459d8dec4f4ec6c49028:04dc296b7952669f57baf8db9f6feb3ba11058d847bad21eb6a8bcecee28bae6279f50956366019936028038b2dc8ed030badc5a17968ff8ee67461142ee1c15' where phone_number LIKE '%96';