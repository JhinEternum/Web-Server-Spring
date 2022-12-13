INSERT INTO profile (id, active, created_at, name) values (1, true, null, 'ADMIN');

INSERT INTO phone (id, active, created_at, name) values (1, true, null, '62 9 9690 5248');
INSERT INTO email (id, active, created_at, name) values (1, true, null, 'gabriel@gmail.com');
INSERT INTO uf (id, active, created_at, name) values (1, true, null, 'GO');
INSERT INTO city (id, active, created_at, name, uf_id) values (1, true, null, 'JATAI', 1);
INSERT INTO person (id, active, created_at, phone_id, email_id, uf_id, city_id) values (1, true, null, 1, 1, 1, 1);
INSERT INTO "user" (user_name, pass, active, validate_ip, person_id) values ('GABRIEL','$5$abc43579jk965p$h3h0PDUw1kC/n26oz5fA7oMLgtIWnczvZsDULQcKCu1', true, false, 1);

-- INSERT INTO profile_users (profile_id, users_id) values (1, 1);
INSERT INTO user_profiles (user_id, profiles_id) values (1, 1);

INSERT INTO character_type (name, active) values ('Character', true);
INSERT INTO character_type (name, active) values ('NPC', true);
INSERT INTO character_type (name, active) values ('Monster', true);

INSERT INTO character_level (name, active) values ('Level 1', true);
INSERT INTO character_level (name, active) values ('Level 2', true);
INSERT INTO character_level (name, active) values ('Level 3', true);
INSERT INTO character_level (name, active) values ('Level 4', true);
INSERT INTO character_level (name, active) values ('Level 5', true);

