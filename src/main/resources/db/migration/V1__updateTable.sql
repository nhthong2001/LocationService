ALTER TABLE Ratting DROP CONSTRAINT ratting_pk;
ALTER TABLE Ratting ADD COLUMN id serial NOT NULL;
ALTER TABLE Ratting ADD PRIMARY KEY (id);