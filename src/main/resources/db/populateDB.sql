DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (datetime, description, calories, user_id) VALUES 
  ('2016-08-01 10:00:00','завтрак', 555, 100000),
  ('2016-08-01 15:00:00','обед', 555, 100000),
  ('2016-08-01 20:00:00','ужин', 555, 100000),
  ('2016-08-02 10:00:00','завтрак', 555, 100001),
  ('2016-08-02 15:00:00','обед', 555, 100001),
  ('2016-08-02 20:00:00','ужин', 555, 100001);