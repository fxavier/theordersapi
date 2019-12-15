CREATE TABLE order_item(
item_id BIGSERIAL,
quantity INTEGER NOT NULL,
unit_price NUMERIC(10, 2) NOT NULL,
product_id BIGINT NOT NULL,
order_id BIGINT NOT NULL,
PRIMARY KEY(iteM_id),
CONSTRAINT fk_product_order_item
  FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_order_order_item
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);
