CREATE DATABASE ecommerce;

CREATE EXTENSION pgcrypto;

CREATE TABLE users (
  user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE product (
  product_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name VARCHAR(100) NOT NULL UNIQUE,
  description VARCHAR(100) NOT NULL,
  stock INTEGER NOT NULL
);

CREATE TABLE price (
  date TIMESTAMP DEFAULT timezone('utc' :: TEXT, now()),
  value NUMERIC(15,6) NOT NULL,
  product_id UUID REFERENCES product(product_id),
  UNIQUE(date, product_id),
  PRIMARY KEY (date, product_id) 
);

CREATE TABLE country (
  country_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE state (
  state_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  country_id UUID REFERENCES country(country_id),
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE address (
  address_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  state_id UUID REFERENCES state(state_id),
  street VARCHAR(50) NOT NULL,
  complement VARCHAR(50) DEFAULT 'empty',
  number VARCHAR(50) NOT NULL
);

CREATE TABLE orders (
  order_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID REFERENCES users(user_id),
  shipping_address UUID REFERENCES address(address_id),
  buy_at TIMESTAMP DEFAULT timezone('utc' :: TEXT, now())
);

CREATE TABLE order_details (
  order_details_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  order_id UUID REFERENCES orders(order_id),
  product_id UUID REFERENCES product(product_id),
  quantity INTEGER NOT NULL,
);