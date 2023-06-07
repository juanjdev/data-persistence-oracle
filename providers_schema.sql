DROP USER providers CASCADE;
CREATE USER providers IDENTIFIED BY A;
GRANT ALL PRIVILEGES TO providers;

CONN providers/A

CREATE TABLE persons (
  ID                  NUMBER(10)      NOT NULL,
  names             VARCHAR2(100)   NOT NULL,
  last_names           VARCHAR2(100)   NOT NULL,
  birth_date    DATE            NOT NULL,
  doc_type      VARCHAR2(2)     NOT NULL,
  doc_number    VARCHAR2(15)    NOT NULL,
  CONSTRAINT pk_persons PRIMARY KEY(ID)
);

CREATE TABLE invoices (
  ID                NUMBER(10)   NOT NULL,
  invoice_date      DATE         NOT NULL,
  client_id         NUMBER(10)   NOT NULL,
  seller_id       NUMBER(10)   NOT NULL,
  CONSTRAINT pk_invoices PRIMARY KEY(ID)
);

CREATE TABLE products (
  ID                NUMBER(10)      NOT NULL,
  product_name      VARCHAR2(100)   NOT NULL,
  unit_price        NUMBER(6,3)     NOT NULL,
  CONSTRAINT pk_products PRIMARY KEY(ID)
);

CREATE TABLE product_provider (
  id_provider    NUMBER(10)    NOT NULL,
  id_product     NUMBER(10)    NOT NULL,
  CONSTRAINT pk_provider_product PRIMARY KEY(id_provider, id_product)
);

CREATE TABLE details (
  ID              NUMBER(10)      NOT NULL,
  amount        NUMBER(8)       NOT NULL,
  sell_price    NUMBER(6,3)     NOT NULL,
  id_product     NUMBER(10)      NOT NULL,
  id_invoice      NUMBER(10)      NOT NULL,
  CONSTRAINT pk_details PRIMARY KEY(ID)
);

ALTER TABLE invoices
  ADD CONSTRAINT fk_client_invoice FOREIGN KEY(client_id)
    REFERENCES persons(ID);

ALTER TABLE invoices
  ADD CONSTRAINT fk_seller_invoice FOREIGN KEY(seller_id)
    REFERENCES persons(ID);

ALTER TABLE product_provider
  ADD CONSTRAINT fk_provider_product FOREIGN KEY(id_provider)
    REFERENCES persons(ID);

ALTER TABLE product_provider
  ADD CONSTRAINT fk_product_provider FOREIGN KEY(id_product)
    REFERENCES products(ID);

ALTER TABLE details
  ADD CONSTRAINT fk_product_details_invoice FOREIGN KEY(id_product)
    REFERENCES products(ID);

ALTER TABLE details
  ADD CONSTRAINT fk_detail_invoce FOREIGN KEY(id_invoice)
    REFERENCES invoices(ID);
