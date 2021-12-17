CREATE TABLE privilages
(
    Id SERIAL PRIMARY KEY NOT NULL,
    discount INTEGER,
    privilagename VARCHAR(100)
);

CREATE TABLE users
(
    Id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL, 
    last_name VARCHAR(100) NOT NULL,
	email VARCHAR(100) 	NOT NULL,
	privilageID INTEGER Default 1 REFERENCES privilages(id)
);

Insert into privilages(discount,privilagename) Values(
    0,'new user'
);
Insert into privilages(discount,privilagename) Values(
    3,'bronze'
);
Insert into privilages(discount,privilagename) Values(
    8,'silver'  
);
Insert into privilages(discount,privilagename) Values(
    10,'gold'  
);
Insert into users(first_name,last_name,email) Values(
    'testname','testlastname','test@mail.te'
);
