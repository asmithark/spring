create table if not exists person(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email  VARCHAR(100) NOT NULL
);