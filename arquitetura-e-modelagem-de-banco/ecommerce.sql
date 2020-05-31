CREATE DATABASE ecommerce;

CREATE EXTENSION pgcrypto;

CREATE TABLE users (
  user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE products (
  product_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name VARCHAR(100) NOT NULL UNIQUE,
  description VARCHAR(100) NOT NULL,
  price NUMERIC(15,6) NOT NULL,
  stock INTEGER NOT NULL
);

CREATE TABLE addresses (
  address_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  country VARCHAR(50) NOT NULL,
  state VARCHAR(50) NOT NULL,
  street VARCHAR(50) NOT NULL,
  complement VARCHAR(50) DEFAULT 'empty',
  number VARCHAR(50) NOT NULL
);

CREATE TABLE orders (
  order_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id UUID REFERENCES users(user_id),
  shipping_address UUID REFERENCES addresses(address_id)
);

CREATE TABLE order_details (
  order_details_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  order_id UUID REFERENCES orders(order_id),
  product_id UUID REFERENCES products(product_id),
  amount NUMERIC(15,6) NOT NULL,
  quantity INTEGER NOT NULL,
  free_shipping BOOLEAN DEFAULT false
);



