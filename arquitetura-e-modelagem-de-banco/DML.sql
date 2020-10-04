INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Paulo','Keller','paulokeller','test@test.com');
INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Zezinho','Zé','zezinho','test@zezinho.com');
INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Zezao','Zé','zezao','test@zezao.com');

INSERT INTO product (name,description,stock) 
VALUES ('camiseta','camiseta dahora',10);
INSERT INTO product (name,description,stock) 
VALUES ('jaqueta','jaqueta dahora',3);
INSERT INTO product (name,description,stock) 
VALUES ('camisa','camisa dahora',8);
INSERT INTO product (name,description,stock) 
VALUES ('tenis','tenis de robozão',1);

INSERT INTO price (value, product_id)
VALUES (50.50, '3659c8be-f41e-4c05-9875-8e57397c90fa');
INSERT INTO price (value, product_id)
VALUES (99.00, 'e7cf9d36-eaf7-48e4-a0c9-dc49a8e5c8e0');
INSERT INTO price (value, product_id)
VALUES (39.20, '3058b5b1-1577-4abc-8cf1-f6a25aea5eae');
INSERT INTO price (value, product_id)
VALUES (50.20, '3058b5b1-1577-4abc-8cf1-f6a25aea5eae');
INSERT INTO price (value, product_id)
VALUES (3000.00, 'b08ceac2-7e2f-4473-9d43-1f318d47e161');

INSERT INTO country (name) 
VALUES ('BRASIL');

INSERT INTO state (name, country_id) 
VALUES ('SAO PAULO', 'f8d7cfe9-71da-408c-85cf-c1bdf3c2b6c5');
INSERT INTO state (name, country_id) 
VALUES ('RIO DE JANEIRO', 'f8d7cfe9-71da-408c-85cf-c1bdf3c2b6c5');

INSERT INTO address (state_id,street,complement,number) 
VALUES ('793a4076-011e-4dc8-8af1-3d0b7a95cfc8','MAIS UMA RUA QUALQUER','apartamento','23A');
INSERT INTO address (state_id,street,complement,number) 
VALUES ('793a4076-011e-4dc8-8af1-3d0b7a95cfc8','OUTRA RUA QUALQUER','apartamento','30C');
INSERT INTO address (state_id,street,complement,number) 
VALUES ('510d817a-9737-4938-a50e-a8a523b7c736','RUA QUALQUER','casa','23');

INSERT INTO orders (user_id,shipping_address)
VALUES ('2774fbde-b25f-45c4-aa3e-802ddde0ea3a','710869db-86dc-47ea-ae2d-041223484c69');
INSERT INTO orders (user_id,shipping_address)
VALUES ('52ebf62e-3c50-4a74-8eaa-1a15bf5cdb11','dfe9a8c9-07c1-4fa7-8faf-c82ea18b5559');
INSERT INTO orders (user_id,shipping_address)
VALUES ('cb43ecdf-7003-40bc-b1c1-fdb71897d6bd','f5c7ab00-df34-43f1-a87d-d1ae78006853');

INSERT INTO order_details (order_id,product_id,quantity,free_shipping)
VALUES ('a4569d3c-b039-4e0e-87ae-e076ff0ea2d5','710869db-86dc-47ea-ae2d-041223484c69', 3, false);
INSERT INTO order_details (order_id,product_id,quantity,free_shipping)
VALUES ('6030831c-c363-4696-b848-947f0756cd0f','3058b5b1-1577-4abc-8cf1-f6a25aea5eae', 4, false);
INSERT INTO order_details (order_id,product_id,quantity,free_shipping)
VALUES ('8a3ecf01-5484-401d-914a-5ce14b3f2e1d','dfe9a8c9-07c1-4fa7-8faf-c82ea18b5559', 1, true);

UPDATE orders 
SET shipping_address = '3058b5b1-1577-4abc-8cf1-f6a25aea5eae' 
WHERE order_id = '6030831c-c363-4696-b848-947f0756cd0f';

SELECT order_details_id
FROM order_details
WHERE order_id = '2774fbde-b25f-45c4-aa3e-802ddde0ea3a';

SELECT value, ROUND(AVG(value),2)
FROM price
GROUP BY value;

SELECT * FROM price
ORDER BY date DESC;

SELECT name, value, description, date, stock
FROM product
LEFT JOIN price
ON product.product_id = price.product_id;