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
    offer_name text,
    offer_account_id bigint,
    offer_category_id bigint,
    offer_date time with time zone,
    offer_price money,
    CONSTRAINT offer_pkey PRIMARY KEY (offer_id),
    CONSTRAINT offer_offer_account_id_fkey FOREIGN KEY (offer_account_id)
        REFERENCES account (account_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT offer_offer_category_id_fkey FOREIGN KEY (offer_category_id)
        REFERENCES category (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
  )
  WITH (
    OIDS=FALSE
  );
  ALTER TABLE offer
    OWNER TO postgres;


    alter table offer
        add constraint fk_offer_account foreign key(offer_account_id)
        references account;


    alter table offer
        add constraint fk_offer_category foreign key(offer_category_id)
        references category;

