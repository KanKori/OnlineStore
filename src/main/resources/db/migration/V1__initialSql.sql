-- Table: public.Products

-- DROP TABLE IF EXISTS public."Products";

CREATE TABLE IF NOT EXISTS public."Products"
(
    id integer NOT NULL,
    title character varying(50) COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    image text COLLATE pg_catalog."default",
    price DOUBLE PRECISION,
    CONSTRAINT "Products_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Products"
    OWNER to postgres;

CREATE TABLE public."PurchaseItem"
(
    id integer NOT NULL,
    product_id integer,
    count integer DEFAULT 1,
    PRIMARY KEY (id),
    CONSTRAINT "Invoice_products_id_fkey" FOREIGN KEY (product_id)
        REFERENCES public."Products" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public."PurchaseItem"
    OWNER to postgres;

-- Table: public.User

-- DROP TABLE IF EXISTS public."User";

CREATE TABLE IF NOT EXISTS public."User"
(
    id integer NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default" NOT NULL,
    telephone character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    role text COLLATE pg_catalog."default",
    adress character varying COLLATE pg_catalog."default",
    CONSTRAINT "User_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."User"
    OWNER to postgres;

-- Table: public.Order

-- DROP TABLE IF EXISTS public."Order";

CREATE TABLE IF NOT EXISTS public."Order"
(
    id integer NOT NULL,
    user_id integer,
    purchase_item_id integer,
    CONSTRAINT "Order_pkey" PRIMARY KEY (id),
    CONSTRAINT purchase_item_order_fk FOREIGN KEY (purchase_item_id)
        REFERENCES public."PurchaseItem" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_order_fk FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Order"
    OWNER to postgres;


