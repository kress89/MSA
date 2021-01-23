insert into media_type (id, naziv)
  values
  (1, 'Movie'),
  (2, 'Show');
  
insert into media_source (id, url)
  values
  (1, 'localhost'),
  (2, 'http://www.omdbapi.com/?apikey=@key@&s=@title@&type=@type@');