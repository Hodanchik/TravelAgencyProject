

    CREATE     TABLE public.users (
    id SERIAL NOT NULL,
        login VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    PRIMARY KEY(id),
);
CREATE SEQUENCE public.users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;


    OWNER TO public.users;