CREATE TABLE users (
  user_id VARCHAR(36) PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone_no VARCHAR(255) NOT NULL

);

CREATE TABLE customers (
  customer_id VarChar(35) NOT NULL,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  phone_no VARCHAR(255) NOT NULL,
gender VARCHAR(255) NOT NULL,
  membership_level VARCHAR(255) NOT NULL DEFAULT 'Bronze',
  PRIMARY KEY (customer_id)
);

CREATE TABLE reservations (
  reservation_id VARCHAR(35) NOT NULL ,
  user_id VARCHAR(5) ,
  customer_id VARCHAR(35) NOT NULL,
  date DATE NOT NULL,
  time VARCHAR(50) NOT NULL,
  table_number INT NOT NULL,
  number_of_people INT NOT NULL,
  PRIMARY KEY (reservation_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE orders (
  order_id VARCHAR(35) NOT NULL ,
  customer_id VARCHAR(35) NOT NULL,
  date DATE NOT NULL,
  order_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  total_price DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Employee (
  Emp_id VARCHAR(35) NOT NULL ,
name VARCHAR(35) NOT NULL,
  NIC VARCHAR(12) NOT NULL ,
  phone_number VARCHAR(10) NOT NULL,
address VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  job_role VARCHAR(255) NOT NULL,
  charge_per_hour DECIMAL(10,2) NOT NULL,
  qualification VARCHAR(255) NOT NULL,
barcode_data VARCHAR(255) NOT NULL,
  PRIMARY KEY (Emp_id)
);

CREATE TABLE prepared_detail (
  pre_id VARCHAR(35) NOT NULL AUTO_INCREMENT,
  order_id VACHAR(35) NOT NULL,
  employee_id VARCHAR(35) NOT NULL,
  responsibility VARCHAR(255) NOT NULL,
  PRIMARY KEY (pre_id),
  FOREIGN KEY (order_id) REFERENCES orders (order_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (employee_id) REFERENCES Employee (Emp_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE menu_item (
  item_id VARCHAR(35) ,
  name VARCHAR(255) NOT NULL,
  unit_price DECIMAL(10,2) NOT NULL,
  menu_type VARCHAR(255) NOT NULL,
  qty_on_hand INT NOT NULL DEFAULT 0,
 stock_id  VARCHAR(35),
  availability VARCHAR(255) NOT NULL DEFAULT 'Available',
  image VARCHAR(255),
  description VARCHAR(255),
 FOREIGN KEY (stock_id) REFERENCES stock_item (stock_id) ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY (item_id)
);

CREATE TABLE order_item (
  order_id VARCHAR(35) NOT NULL,
  item_id VARCHAR(35) NOT NULL,
  item_price DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders (order_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (item_id) REFERENCES menu_item (item_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE stock_item (
  stock_id VARCHAR(35) ,
  name VARCHAR(255) NOT NULL ,
  cost_price DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL DEFAULT 0,
  PRIMARY KEY (stock_id)
);

CREATE TABLE menu_ingredients_details (
  id INT NOT NULL AUTO_INCREMENT,
  item_id VARCHAR(35) NOT NULL,
  stock_id VARCHAR(35) NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (item_id) REFERENCES menu_item (item_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (stock_id) REFERENCES stock_item (stock_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE supplier (
  sup_id VARCHAR(35) ,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone_number VARCHAR(10) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (sup_id)
);

CREATE TABLE item_supply_details (
  supplier_id VARCHAR(35) NOT NULL,
  stock_id VARCHAR(35) NOT NULL,
  date DATE NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (supplier_id) REFERENCES supplier (sup_id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (stock_id) REFERENCES stock_item (stock_id) ON UPDATE CASCADE ON DELETE CASCADE
);









