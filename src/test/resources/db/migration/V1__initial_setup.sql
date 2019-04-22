create TABLE users
(
    id bigserial NOT NULL,
    login character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

create type public."Tour_type" as ENUM
    ('RELAX', 'TRAINING', 'TRAVEL', 'HONEYMOON', 'WITH_CHILD', 'MEDICAL', 'RELIGIOUS', 'ADVENTURE', 'NATURE', 'CULTURAL');


CREATE TABLE public."Tour"
(
    id bigserial NOT NULL,
    photo character varying(255) NOT NULL,
    date date NOT NULL,
    duration bigint NOT NULL,
    description character varying(2048),
    cost bigint NOT NULL,
   tour_type public."Tour_type",
   hotel_id bigint NOT NULL,
    country_id bigint NOT NULL,

    CONSTRAINT tour_pkey PRIMARY KEY (id)
);


create type public."FeaturesType" as ENUM
    ('AIR_CONDIDTIONING', 'TV', 'BREAKFAST', 'DINNER', 'SAFE', 'KINGSIZE_BED', 'MINI_BAR', 'BALCONY', 'WI_FI', 'HAIR_DRYER');

CREATE TABLE public."Hotel"
(
    id bigserial NOT NULL,
    name character varying(255) NOT NULL,
    stars bigint NOT NULL,
       website character varying(2048),
    latitude REAL NOT NULL,
   longitude REAL NOT NULL,
   features public."FeaturesType"[],

    CONSTRAINT hotel_pkey PRIMARY KEY (id)
);

CREATE TABLE public."Country"
(
    id bigserial NOT NULL,
    name character varying(255) NOT NULL,

    CONSTRAINT country_pkey PRIMARY KEY (id)
);

CREATE TABLE public."Review"
(
    id bigserial NOT NULL,
    date date NOT NULL,
   text character varying(2048),
   user_id bigint NOT NULL,
    tour_id bigint NOT NULL,

    CONSTRAINT review_pkey PRIMARY KEY (id)
);