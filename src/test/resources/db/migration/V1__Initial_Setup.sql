CREATE SEQUENCE public.users_id_seq;
CREATE TABLE public.users(

    id integer not null default nextval('users_id_seq'),
    login varchar(20),
    password varchar(50),

)
CREATE SEQUENCE public.Tour_id_seq;
CREATE TYPE public.Tour_type AS ENUM
    ('RELAX', 'TRAINING', 'TRAVEL', 'HONEYMOON', 'WITH_CHILD', 'MEDICAL', 'RELIGIOUS', 'ADVENTURE', 'NATURE', 'CULTURAL');
CREATE TABLE public.Tour(

    id integer not null default nextval('Tour_id_seq'),
    photo varchar(50),
    date date,
    duration integer,
    description varchar(50),
    cost integer,
    tour_type "Tour_type",
    hotel_id integer,
    country_id integer,
)






