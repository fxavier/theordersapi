CREATE TABLE orders(
order_id BIGSERIAL,
order_date DATE NOT NULL,
order_status VARCHAR(50) NOT NULL,
order_total NUMERIC(10, 2) NOT NULL,
user_id BIGINT NOT NULL,
address_id BIGINT NOT NULL,
PRIMARY KEY(order_id),
CONSTRAINT fk_order_user
  FOREIGN KEY(user_id) REFERENCES user_account(user_id),
CONSTRAINT fk_order_address
  FOREIGN KEY(address_id) REFERENCES shipping_address(address_id)
);

CREATE TABLE payment(
order_id BIGINT NOT NULL,
payment_status VARCHAR(20) NOT NULL,
PRIMARY KEY(order_id),
CONSTRAINT fk_payment_order
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

CREATE TABLE credit_card(
holder_name VARCHAR(100) NOT NULL,
card_number VARCHAR(200) NOT NULL,
expiry_month DATE NOT NULL,
expiry_year DATE NOT NULL,
cvc INTEGER NOT NULL,
order_id BIGINT NOT NULL,
CONSTRAINT fk_order_card
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);


CREATE TABLE cash(
payment_date DATE NOT NULL,
order_id BIGINT NOT NULL,
CONSTRAINT fk_order_bankSlip
  FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

