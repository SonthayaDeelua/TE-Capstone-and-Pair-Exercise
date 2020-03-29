<<<<<<< HEAD
BEGIN TRANSACTION;   

  
CREATE TABLE theowner 

( 

        owner_id  SERIAL NOT NULL PRIMARY KEY, 

        fname  varchar(30), 

        lname  varchar (30) NOT NULL, 

        address  varchar (30) NOT NULL, 

        city  varchar (30) NOT NULL, 

        district  char (2) NOT NULL, 

        postalcode  char (6) NOT NULL, 

        phone  integer 

);   

CREATE TABLE pet  

( 

        pet_id   SERIAL NOT NULL PRIMARY KEY, 

        pet_name  varchar (30) NOT NULL, 

        owner_id  integer NOT NULL, 

        age  varchar (2), 

         

        CONSTRAINT fk_theowner FOREIGN KEY (owner_id) REFERENCES theowner(owner_id)  

); 

  

CREATE TABLE visit  

( 

        visit_id  SERIAL NOT NULL PRIMARY KEY, 

        visit_date  DATE NOT NULL 

); 

  

  CREATE TABLE invoice  

( 

        invoice_number  SERIAL NOT NULL PRIMARY KEY, 

        invoice_date  date, 

        tax_amount  numeric (15,2), 

        total_amount  numeric (15,2), 

        owner_id  integer NOT NULL, 

        visit_id  integer NOT NULL, 

         

          CONSTRAINT fk_theowner FOREIGN KEY (owner_id) REFERENCES theowner(owner_id),  

          CONSTRAINT fk_visit FOREIGN KEY (visit_id) REFERENCES visit(visit_id)  

       

); 

  

  CREATE TABLE procedure 

( 

        procedure_id  SERIAL NOT NULL PRIMARY KEY, 

        procedure_name  varchar(30) NOT NULL, 

        procedure_cost  numeric (15,2) NOT NULL, 

        pet_id  integer NOT NULL, 

        visit_id  integer NOT NULL, 

         

        CONSTRAINT fk_pet FOREIGN KEY (pet_id) REFERENCES pet(pet_id),  

        CONSTRAINT fk_visit FOREIGN KEY (visit_id) REFERENCES visit(visit_id)  

        

); 

  

  CREATE TABLE visitprocedure 

( 

        visit_id  integer NOT NULL, 

        procedure_id  integer NOT NULL, 

         

        
=======
BEGIN TRANSACTION;

CREATE TABLE pet (
        pet_id varchar (7) NOT NULL,
        pet_name varchar (30) NOT NULL,
        owner_id integer  NOT NULL,
        age integer (2),
        PRIMARY KEY (pet_id)
  );
  CREATE TABLE owner(
        owner_id serial not null,
        fname varchar(30),
        lname varchar (30) NOT NULL,
        address varchar (30) NOT NULL,
        city varchar (30) NOT NULL,
        district char (2) NOT NULL,
        postalcode varchar (6) NOT NULL,
        phone integer,
        PRIMARY KEY (owner_id)
);
  CREATE TABLE invoice (
        invoice_number serial NOT NULL,
        remitto text,
        invoice_date date,
        tax_amount numeric (15,2),
        total_amount numeric (15,2),
        owner_id integer,
        visit_id integer,
        PRIMARY KEY (invoice_number)
 );
 
        CREATE TABLE ervisit (
        visit_id        serial NOT NULL,
        visit_date      DATE NOT NULL,
        PRIMARY KEY   (visit_id)
);

  CREATE TABLE petvisit (
        visit_id serial NOT NULL,
        pet_id varchar (7) NOT NULL
);

  CREATE TABLE procedure(
        procedure_id integer NOT NULL,
        procedure_name varchar(30) NOT NULL,
        procedure_cost numeric (15,2) NOT NULL,
        PRIMARY KEY (procedure_id)
);

  CREATE TABLE visitprocedure(
        visit_id integer NOT NULL,
        procedure_id integer NOT NULL
);


ALTER TABLE pet  ADD CONSTRAINT FK_owner_id FOREIGN KEY (owner_id) REFERENCES owner(owner_id);

>>>>>>> f7d3106541f323425a36010ce6761c095098b35d

        CONSTRAINT fk_visit FOREIGN KEY (visit_id) REFERENCES visit(visit_id),  

        CONSTRAINT fk_procedure FOREIGN KEY (procedure_id) REFERENCES procedure(procedure_id)  

<<<<<<< HEAD
                

); 

  

COMMIT TRANSACTION;   
=======
ALTER TABLE visitprocedure ADD CONSTRAINT FK_visit_id FOREIGN KEY (visit_id) REFERENCES ervisit(visit_id);
ALTER TABLE procedure ADD CONSTRAINT FK_procedure_id FOREIGN KEY (procedure_id) REFERENCES procedure(procedure_id);

commit;
>>>>>>> f7d3106541f323425a36010ce6761c095098b35d
