INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Paulo','Keller','paulokeller','test@test.com');
INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Zezinho','Zé','zezinho','test@zezinho.com');
INSERT INTO users (first_name,last_name,username,email) 
VALUES ('Zezao','Zé','zezao','test@zezao.com');

INSERT INTO products (name,description,stock) 
VALUES ('camiseta','camiseta dahora',10);
INSERT INTO products (name,description,stock) 
VALUES ('jaqueta','jaqueta dahora',3);
INSERT INTO products (name,description,stock) 
VALUES ('camisa','camisa dahora',8);
INSERT INTO products (name,description,stock) 
VALUES ('tenis','tenis de robozão',1);

INSERT INTO prices (value, product_id)
VALUES (50.50, '36d5781c-cc98-4759-b1f1-375c86fdb888');
INSERT INTO prices (value, product_id)
VALUES (99.00, 'ff03e781-1c27-4322-a7f7-aabd1cd0cdad');
INSERT INTO prices (value, product_id)
VALUES (39.20, '96fe5679-d0cb-4663-a115-6dde0f9634b7');
INSERT INTO prices (value, product_id)
VALUES (50.20, '96fe5679-d0cb-4663-a115-6dde0f9634b7');
INSERT INTO prices (value, product_id)
VALUES (3000.00, '9bbe4c43-0aa5-4825-8dbd-e36d24a9f6dc');

INSERT INTO addresses (country,state,street,number) 
VALUES ('BRASIL','RIO DE JANEIRO','OUTRA RUA QUALQUER','23A');
INSERT INTO addresses (country,state,street,complement,number)
VALUES ('BRASIL','SAO PAULO','RUA QUALQUER','Próximo ao mercadinho','23');
INSERT INTO addresses (country,state,street,complement,number)
VALUES ('BRASIL','RIO DE JANEIRO','MAIS UMA RUA QUALQUER','Apartamento','30C');
INSERT INTO addresses (country,state,street,complement,number)
VALUES ('BRASIL','ESPIRITO SANTO','MAIS UMA RUA QUALQUER','Casa','10');

INSERT INTO orders (user_id,shipping_address)
VALUES ('a871b6ad-b2a8-4cf1-8c48-14243926c199','6da6e468-3fd4-4f43-87fa-3cfecb3c343c');
INSERT INTO orders (user_id,shipping_address)
VALUES ('e51765d6-4f68-4064-8f4c-adc0a769626c','56ff1bf0-831c-43ee-95b9-fe696dd83722');
INSERT INTO orders (user_id,shipping_address)
VALUES ('85d91524-72cc-4511-83b8-84a7383343e7','d18f2490-8e9f-4a58-8eea-ccf0baa3a3a5');

INSERT INTO order_details (order_id,product_id,quantity,free_shipping)
VALUES ('ebc65ce7-821c-4750-b8c3-11caef2e880a','36d5781c-cc98-4759-b1f1-375c86fdb888', 3, false);
INSERT INTO order_details (order_id,product_id,quantity,free_shipping)
VALUES ('51568489-9ada-41a8-b85e-c55b299faa76','96fe5679-d0cb-4663-a115-6dde0f9634b7', 4, false);
INSERT INTO order_details (order_id,product_id,quantity,free_shipping)
VALUES ('c1c206d2-1a04-4e36-9e4b-b6588b955d16','9bbe4c43-0aa5-4825-8dbd-e36d24a9f6dc', 1, true);

SELECT order_details_id
FROM order_details
WHERE free_shipping = true;

SELECT value, ROUND(AVG(value),2)
FROM prices
GROUP BY value;

SELECT * FROM prices
ORDER BY date DESC;

SELECT name, value, date, quantity, stock, free_shipping, buy_at FROM
(( order_details LEFT JOIN products ON products.product_id = order_details.product_id)
LEFT JOIN prices ON prices.product_id = order_details.product_id
LEFT JOIN orders ON orders.order_id = order_details.order_id)
WHERE buy_at BETWEEN buy_at AND timezone('utc' :: TEXT, now());