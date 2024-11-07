INSERT INTO roles (role_type) VALUES ('EMPLOYEE');
INSERT INTO roles (role_type) VALUES ('ADMIN');
INSERT INTO roles (role_type) VALUES ('CHEF');
INSERT INTO roles (role_type) VALUES ('WAITER');

INSERT INTO users (username,password)
VALUES ('omar.elbana','weakPass');

INSERT INTO user_roles (user_username, roles_id)
VALUES ('omar.elbana', (SELECT id FROM roles WHERE role_type = 'EMPLOYEE'));

INSERT INTO employees (firstname, lastname, email, phone)
WHERE username = 'omar.elbana'
VALUES ('Omar', 'Elbana', 'Omar@sara.com', 'not provided');



