CREATE DATABASE testdb5;

\c testdb5;

CREATE TABLE task (
	task_id serial PRIMARY KEY,
	task_name VARCHAR ( 50 ) UNIQUE NOT NULL,
	task_description VARCHAR ( 50 ),
	create_time TIMESTAMP NOT NULL,
	update_time TIMESTAMP NOT NULL
);

INSERT INTO "public"."task" ("task_id", "task_name", "task_description", "create_time", "update_time") VALUES (0, 'EJERCICIO', 't', '2018-03-09 23:03:26', '2018-03-10 00:15:27');