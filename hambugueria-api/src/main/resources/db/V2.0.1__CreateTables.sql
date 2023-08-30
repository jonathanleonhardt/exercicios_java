DROP TABLE IF EXISTS public.hamburgueria CASCADE;

CREATE TABLE public.hamburgueria (
	id serial4 NOT NULL,
	nome text NULL,
	CONSTRAINT hamburgueria_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.cliente CASCADE;

CREATE TABLE public.cliente (
	id serial4 NOT NULL,
	documento varchar(255) NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	id_hamburgueria int4 NOT NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id),
	CONSTRAINT fk3vuv5y9i0hpi1tdgrru9bx2oe FOREIGN KEY (id_hamburgueria) REFERENCES public.hamburgueria(id)
);

DROP TABLE IF EXISTS public.pedido CASCADE;

CREATE TABLE public.pedido (
	id serial4 NOT NULL,
	"data" int8 NULL,
	descricao varchar(255) NULL,
	status int2 NULL,
	id_hamburgueria int4 NOT NULL,
	CONSTRAINT pedido_pkey PRIMARY KEY (id),
	CONSTRAINT pedido_status_check CHECK (((status >= 0) AND (status <= 3))),
	CONSTRAINT fkmf53mohi3fui9bmn4luwi5sc0 FOREIGN KEY (id_hamburgueria) REFERENCES public.hamburgueria(id)
);

DROP TABLE IF EXISTS public.item CASCADE;

CREATE TABLE public.item (
	id serial4 NOT NULL,
	descricao varchar(255) NULL,
	status int2 NULL,
	id_pedido int4 NOT NULL,
	CONSTRAINT item_pkey PRIMARY KEY (id),
	CONSTRAINT item_status_check CHECK (((status >= 0) AND (status <= 3))),
	CONSTRAINT fk5toenqdp8uvohbyf311vlherr FOREIGN KEY (id_pedido) REFERENCES public.pedido(id)
);