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