CREATE TABLE todo
(
    id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(64)  NOT NULL,
    description VARCHAR(256) NOT NULL,
    status      VARCHAR(16)  DEFAULT 'TODO' NOT NULL
);

CREATE TABLE task
(
    id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    todo_id     BIGINT        NOT NULL,
    title       VARCHAR(256) NOT NULL,
    description VARCHAR(64)  NOT NULL,
    status      VARCHAR(16)  DEFAULT 'TODO' NOT NULL,
    FOREIGN KEY (todo_id) REFERENCES todo (id) ON DELETE CASCADE
);

