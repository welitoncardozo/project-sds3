CREATE TABLE IF NOT EXISTS seller (
    seller_id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255) NOT NULL,

    CONSTRAINT pk_seller PRIMARY KEY (seller_id)
);

CREATE TABLE IF NOT EXISTS sale (
    sale_id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    seller_id INTEGER NOT NULL,
    amount NUMERIC NOT NULL,
    deals INTEGER NOT NULL,
    visited INTEGER NOT NULL,
    date TIMESTAMP WITHOUT TIME ZONE NOT NULL,

    CONSTRAINT pk_sale PRIMARY KEY (sale_id),
    CONSTRAINT fk_sale_seller FOREIGN KEY (seller_id)
        REFERENCES seller (seller_id)
);
