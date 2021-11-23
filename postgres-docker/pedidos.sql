create table pedidos(
   codigo int not null
  ,codigo_client int not null
  ,valor_total numeric(6,2) not null default 0
  ,numero_cartao varchar(16)
  ,data date default now() not null
)
;

alter table
  add constraint pk_Pedidos
  ,add primary key(codigo)
;