BEGIN;
INSERT INTO `book` (bookId, author, `name`, description, price) VALUES
  ("28bf63c9-1a23-11e9-a302-0242ac110003","Guice","Python","python core program",53),
  ("28c0b40e-1a23-11e9-a302-0242ac110003","Nacy","Java","Java core program",66),
  ("28c0b40e-1a23-11e9-a302-0242ac110003","Nacy","name":"Java","Java core program",66),
  ("37f60de1-1a23-11e9-a302-0242ac110003","linus","Linux","linux core program",60),
  ("4c2c5440-1a23-11e9-a302-0242ac110003","Cok Tim","C Plus Plus","C++ core program",63);
COMMIT ;