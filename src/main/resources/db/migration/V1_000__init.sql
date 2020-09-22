
create table public.client
(
	inn varchar(10) not null
		constraint client_pkey
			primary key,
	first_name varchar(255),
	last_name varchar(255),
	middle_name varchar(255)
);

create table public.transaction
(
	id uuid not null
		constraint transaction_pkey
			primary key,
	amount double precision,
	card varchar(16),
	currency varchar(5),
	place varchar(255),
	client_inn varchar(255) not null
		constraint client_inn_client_pkey
			references public.client
);

