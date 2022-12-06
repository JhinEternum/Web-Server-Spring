INSERT INTO profile (id, active, created_at, name) values (1, true, null, 'ADMIN');

INSERT INTO phone (id, active, created_at, name) values (1, true, null, '62 9 9690 5248');
INSERT INTO email (id, active, created_at, name) values (1, true, null, 'gabriel@gmail.com');
INSERT INTO uf (id, active, created_at, name) values (1, true, null, 'GO');
INSERT INTO city (id, active, created_at, name, uf_id) values (1, true, null, 'JATAI', 1);
INSERT INTO person (id, active, created_at, phone_id, email_id, uf_id, city_id) values (1, true, null, 1, 1, 1, 1);
INSERT INTO "user" (user_name, pass, active, validate_ip, person_id) values ('GABRIEL','$5$abc43579jk965p$I9BnCdtfs/uSGqcsJeKcSGgb5Vq5ahAprCnC7Om6.X9', true, false, 1);

-- INSERT INTO profile_users (profile_id, users_id) values (1, 1);
INSERT INTO user_profiles (user_id, profiles_id) values (1, 1);

-- INSERT INTO usuario (user_name, password, email, ativo, validar_ip) values ('TRINOVE.TECNOLOGIA','$5$abc43579jk965p$I9BnCdtfs/uSGqcsJeKcSGgb5Vq5ahAprCnC7Om6.X9','TRINOVE.TECNOLOGIA@gmail.com', true, false);
