CREATE TABLE employee (
    emp_id VARCHAR(5) PRIMARY KEY,
    emp_name VARCHAR(30) NOT NULL,
    password VARCHAR(16) NOT NULL,
    birthday DATE NOT NULL,
    gender INTEGER NOT NULL,
    delete_at BOOLEAN NOT NULL
);