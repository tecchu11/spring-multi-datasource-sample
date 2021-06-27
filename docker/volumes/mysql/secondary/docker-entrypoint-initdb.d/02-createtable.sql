USE secondary_mysql;

DROP TABLE IF EXISTS async_secondary;
CREATE TABLE async_secondary(
id INT auto_increment NOT NULL,
registered_at DATETIME NOT NULL,
registered_id VARCHAR(10) NOT NULL,
PRIMARY KEY(id)
)
