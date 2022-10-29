-- Table: public.products

-- DROP TABLE IF EXISTS public."products";

CREATE TABLE IF NOT EXISTS public."products"
(
    id character varying NOT NULL,
    title character varying(50) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    image text COLLATE pg_catalog."default",
    price DOUBLE PRECISION,
    CONSTRAINT "products_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."products"
    OWNER to postgres;


-- Table: public.users

-- DROP TABLE IF EXISTS public."users";

CREATE TABLE IF NOT EXISTS public."users"
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default" NOT NULL,
    phone character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    role text COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    status character varying COLLATE pg_catalog."default",
    CONSTRAINT "users_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."users"
    OWNER to postgres;


-- Table: public.orders

-- DROP TABLE IF EXISTS public."orders";

CREATE TABLE IF NOT EXISTS public."orders"
(
    id character varying NOT NULL,
    users_id character varying,
    comment text,
    CONSTRAINT "orders_pkey" PRIMARY KEY (id),
    CONSTRAINT users_orders_fk FOREIGN KEY (users_id)
        REFERENCES public."users" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."orders"
    OWNER to postgres;

CREATE TABLE public."purchase_item"
(
    id character varying NOT NULL,
    product_id character varying,
    order_id character varying,
    count integer DEFAULT 1,
    PRIMARY KEY (id),
    CONSTRAINT "purchase_item_products_id_fkey" FOREIGN KEY (product_id)
        REFERENCES public."products" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    constraint purchase_item_table_order_table_id_fk foreign key (order_id)
    references public."orders" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE IF EXISTS public."purchase_item"
    OWNER to postgres;
