

CREATE TABLE CLIENTE (
    id       INTEGER PRIMARY KEY NOT NULL,
    nome     VARCHAR(80) NOT NULL,
    email    VARCHAR(40) NOT NULL,
    telefone INT
);

INSERT INTO CLIENTE (id, nome, email, telefone)
VALUES (1, 'Betty', 'betty@techcamps.com', 12345678)
