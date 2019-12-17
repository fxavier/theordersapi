
CREATE TABLE shipping_table(
table_id SERIAL,
village_id BIGINT NOT NULL,
price NUMERIC(10, 2) NOT NULL,
PRIMARY KEY(table_id),
CONSTRAINT fk_shipping_table_village
  FOREIGN KEY(village_id) REFERENCES village(village_id)
);
