CREATE TABLE tasks
(
    id INT PRIMARY KEY,
    user_id INT NOT NULL,
    name VARCHAR(32),
    status VARCHAR(32) default 'RENDERING' NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);