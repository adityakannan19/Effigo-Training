-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	category_id bigserial NOT NULL,
	"name" varchar(255) NULL,
	created_on timestamp(6) NOT NULL,
	updated_on timestamp(6) NULL,
	CONSTRAINT category_pkey PRIMARY KEY (category_id)
);

-- public.course definition

-- Drop table

-- DROP TABLE public.course;

CREATE TABLE public.course (
	course_id bigserial NOT NULL,
	description varchar(255) NULL,
	title varchar(255) NULL,
	author_id int8 NULL,
	category_id int8 NULL,
	created_on timestamp(6) NOT NULL,
	updated_on timestamp(6) NULL,
	CONSTRAINT course_pkey PRIMARY KEY (course_id)
);


-- public.course foreign keys

ALTER TABLE public.course ADD CONSTRAINT fk2t15q384waw1loscrt4ttcg36 FOREIGN KEY (author_id) REFERENCES public."user"(user_id);
ALTER TABLE public.course ADD CONSTRAINT fkkyes7515s3ypoovxrput029bh FOREIGN KEY (category_id) REFERENCES public.category(category_id);

-- public.enrollment definition

-- Drop table

-- DROP TABLE public.enrollment;

CREATE TABLE public.enrollment (
	enrollment_id bigserial NOT NULL,
	course_id int8 NULL,
	learner_id int8 NULL,
	created_on timestamp(6) NOT NULL,
	updated_on timestamp(6) NULL,
	CONSTRAINT enrollment_pkey PRIMARY KEY (enrollment_id)
);


-- public.enrollment foreign keys

ALTER TABLE public.enrollment ADD CONSTRAINT fkbbb3ns0ujlfrf991kdwowpn2y FOREIGN KEY (learner_id) REFERENCES public."user"(user_id);
ALTER TABLE public.enrollment ADD CONSTRAINT fkbhhcqkw1px6yljqg92m0sh2gt FOREIGN KEY (course_id) REFERENCES public.course(course_id);

-- public.favorite definition

-- Drop table

-- DROP TABLE public.favorite;

CREATE TABLE public.favorite (
	favorite_id bigserial NOT NULL,
	course_id int8 NULL,
	learner_id int8 NULL,
	created_on timestamp(6) NOT NULL,
	updated_on timestamp(6) NULL,
	CONSTRAINT favorite_pkey PRIMARY KEY (favorite_id)
);


-- public.favorite foreign keys

ALTER TABLE public.favorite ADD CONSTRAINT fk3o2fdumt96b5wvl51qaf99eul FOREIGN KEY (learner_id) REFERENCES public."user"(user_id);
ALTER TABLE public.favorite ADD CONSTRAINT fk47y8nwkmm9h2g8fkhxuepfdjt FOREIGN KEY (course_id) REFERENCES public.course(course_id);

-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	user_id bigserial NOT NULL,
	"password" varchar(255) NULL,
	"role" varchar(255) NULL,
	username varchar(255) NULL,
	created_on bytea NOT NULL,
	updated_on bytea NULL,
	CONSTRAINT uk_sb8bbouer5wak8vyiiy4pf2bx UNIQUE (username),
	CONSTRAINT user_pkey PRIMARY KEY (user_id),
	CONSTRAINT user_role_check CHECK (((role)::text = ANY ((ARRAY['ADMIN'::character varying, 'AUTHOR'::character varying, 'LEARNER'::character varying])::text[])))
);