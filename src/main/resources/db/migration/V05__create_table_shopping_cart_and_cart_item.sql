CREATE TABLE shopping_cart(
cart_id BIGSERIAL,
cart_total NUMERIC(10, 2) NOT NULL,
user_id BIGINT NOT NULL,
PRIMARY KEY(cart_id),
CONSTRAINT fk_cart_user
  FOREIGN KEY(user_id) REFERENCES user_account(user_id)
);

CREATE TABLE cart_item(
item_id BIGSERIAL,
quantity INTEGER NOT NULL,
unit_price NUMERIC(10, 2) NOT NULL,
product_id BIGINT NOT NULL,
cart_id BIGINT NOT NULL,
PRIMARY KEY(item_id),
CONSTRAINT fk_cart_item_product
  FOREIGN KEY(product_id) REFERENCES product(product_id),
CONSTRAINT fk_cart_item_cart
  FOREIGN KEY(cart_id) REFERENCES shopping_cart(cart_id)
);