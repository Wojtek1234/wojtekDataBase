CREATE TABLE account
(
  account_id bigint NOT NULL,
  account_name text NOT NULL,
  CONSTRAINT account_id PRIMARY KEY (account_id),
  CONSTRAINT ac_name UNIQUE (account_name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE account
  OWNER TO postgres;


  CREATE TABLE category
  (
    category_id bigint NOT NULL,
    category_name text NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (category_id),
    CONSTRAINT cat_name UNIQUE (category_name)
  )
  WITH (
    OIDS=FALSE
  );
  ALTER TABLE category
    OWNER TO postgres;
CREATE TABLE offer
(
  offer_id bigint NOT NULL,
  offer_name text NOT NULL,
  offer_account_id bigint NOT NULL,
  offer_category_id bigint NOT NULL,
  offer_date time with time zone NOT NULL,
  offer_price double precision,
  CONSTRAINT off_id PRIMARY KEY (offer_id),
  CONSTRAINT fk_offer_account FOREIGN KEY (offer_account_id)
      REFERENCES account (account_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_offer_category FOREIGN KEY (offer_category_id)
      REFERENCES category (category_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE offer
  OWNER TO postgres;
