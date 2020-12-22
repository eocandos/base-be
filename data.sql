CREATE DATABASE tasklistdb;

\c tasklistdb;

CREATE TABLE task (
	task_id serial PRIMARY KEY,
	task_name VARCHAR ( 50 ) NOT NULL,
	task_description VARCHAR ( 50 ),
	active BOOLEAN NOT NULL,
	create_time TIMESTAMP NOT NULL,
	update_time TIMESTAMP NOT NULL
);

INSERT INTO "public"."task" ("task_id", "task_name", "task_description", "active", "create_time", "update_time") VALUES (1, 'Ejercicio', 'Jugar Futbol', 't', '2018-03-09 23:03:26', '2018-03-10 00:15:27');
INSERT INTO "public"."task" ("task_id", "task_name", "task_description", "active", "create_time", "update_time") VALUES (2, 'Comprar leche', 'Leche deslactosada', 't', '2018-03-09 23:03:26', '2018-03-10 00:15:27');
INSERT INTO "public"."task" ("task_id", "task_name", "task_description", "active", "create_time", "update_time") VALUES (3, 'Comprar revista', 'Revista futbol', 'f', '2018-03-09 23:03:26', '2018-03-10 00:15:27');