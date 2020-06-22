INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Paulo','Keller','paulokeller','test@test.com');
INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Zezinho','Zé','zezinho','test@zezinho.com');
INSERT INTO users (first_name,last_name,username,email, is_premium) 
VALUES ('Zezao','Zé','zezao','test@zezao.com', true);

INSERT INTO products (name,description,price,stock) 
VALUES ('camiseta','camiseta dahora',50.50,10);
INSERT INTO products (name,description,price,stock) 
VALUES ('jaqueta','jaqueta dahora',99.00,3);
INSERT INTO products (name,description,price,stock) 
VALUES ('camisa','camisa dahora',39.20,8);
INSERT INTO products (name,description,price,stock) 
VALUES ('tenis','tenis de robozão',3000.00,1);

INSERT INTO addresses (country,state,street,number) 
VALUES ('BRASIL','RIO DE JANEIRO','OUTRA RUA QUALQUER','23A');
INSERT INTO addresses (country,state,street,complement,number)
VALUES ('BRASIL','SAO PAULO','RUA QUALQUER','Próximo ao mercadinho','23');
INSERT INTO addresses (country,state,street,complement,number)
VALUES ('BRASIL','RIO DE JANEIRO','MAIS UMA RUA QUALQUER','Apartamento','30C');
INSERT INTO addresses (country,state,street,complement,number)
VALUES ('BRASIL','ESPIRITO SANTO','MAIS UMA RUA QUALQUER','Casa','10');

INSERT INTO orders (user_id,shipping_address)
VALUES ('c08a4635-d60d-47d3-9f41-4c2ef21d53fb','e5587acf-aa4b-499a-a919-ab8f8cbc1c5a');
INSERT INTO orders (user_id,shipping_address)
VALUES ('c08a4635-d60d-47d3-9f41-4c2ef21d53fb','ed26bf2b-0419-4dc1-8b4b-e0545174d49c');
INSERT INTO orders (user_id,shipping_address)
VALUES ('99d4703a-f8ee-4370-a1ae-add03eb1b73e','58a07654-a21d-4508-b714-8972cbc8b004');
INSERT INTO orders (user_id,shipping_address)
VALUES ('99d4703a-f8ee-4370-a1ae-add03eb1b73e','58a07654-a21d-4508-b714-8972cbc8b004');
INSERT INTO orders (user_id,shipping_address)
VALUES ('cbac6f19-3894-4c77-aab9-c5797f7b3f13','deaa60b7-296c-4b6a-b365-54d96ce5f9a6');

INSERT INTO order_details (order_id,product_id,amount,quantity,free_shipping)
VALUES ('93a560fe-0124-43c9-a041-3da9d18d7148','a193ea87-21c4-4b12-900e-3ffba81013f3', 252.50, 1, false);
INSERT INTO order_details (order_id,product_id,amount,quantity,free_shipping)
VALUES ('30936d2d-b77f-405c-ba55-40d3ca0a322c','59ff88cd-6232-4edd-9911-5821f1d33f4e', 99.00, 1, false);
INSERT INTO order_details (order_id,product_id,amount,quantity,free_shipping)
VALUES ('ec832f99-d51c-4abf-8d36-bd857236f014','41ad937d-8591-46f5-ad2a-d68267efe1a3', 235.20, 1, false);
INSERT INTO order_details (order_id,product_id,amount,quantity,free_shipping)
VALUES ('d1c8eedf-7d22-45cd-b486-859ae3bb3e2c','8745108e-b732-4f6f-abb2-f0f32568a907', 3000.20, 1, true);
INSERT INTO order_details (order_id,product_id,amount,quantity,free_shipping)
VALUES ('c4fdcda9-dfff-4008-aef8-f230289f4420','a193ea87-21c4-4b12-900e-3ffba81013f3', 101.00, 1, true);

ALTER TABLE order_details
RENAME COLUMN oder_id TO order_id;

SELECT order_details_id
FROM order_details
WHERE free_shipping = true;

SELECT order_details_id, SUM(amount)  
FROM order_details
GROUP BY order_details_id
ORDER BY SUM(amount) DESC
LIMIT 5;

SELECT price, ROUND(AVG(price),2)
FROM products
GROUP BY price;

SELECT order_details_id, COUNT(free_shipping), SUM(amount) 
FROM order_details
GROUP BY order_details_id;

SELECT * FROM
(( orders LEFT JOIN order_details ON orders.order_id = order_details.order_id)
LEFT JOIN products ON products.product_id = order_details.product_id);