create table media_type (
  id     int(11)      not null auto_increment,
  naziv  varchar(256)  not null,
  
  primary key (id)
);

create table media_source (
  id     int(11)      not null auto_increment,
  url    varchar(256) not null,
  
  primary key (id)
);

create table media (
  id     int(11)      not null auto_increment,
  naziv  varchar(256)  not null,
  tip    int(11)      not null,
  izvor  int(11)      not null,
  opis   varchar(256) not null,
  dodaci varchar(256) not null,
  
  primary key (id),
  
  constraint media_type_id foreign key (tip) references media_type (id),
  
  constraint media_source_id foreign key (izvor) references media_source (id)
);