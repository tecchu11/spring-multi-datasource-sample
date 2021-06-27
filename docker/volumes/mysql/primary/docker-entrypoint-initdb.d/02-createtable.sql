USE primary_mysql;

DROP TABLE IF EXISTS async_primary;
CREATE TABLE async_primary(
id INT auto_increment NOT NULL,
registered_at DATETIME NOT NULL,
registered_id VARCHAR(10) NOT NULL,
PRIMARY KEY(id)
)
