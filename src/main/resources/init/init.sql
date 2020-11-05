INSERT INTO role (role_name, search_name)
    VALUES
        ('Master', 'Master'),
        ('Administrator', 'Administrator'),
        ('Employee', 'Employee'),
        ('Normal', 'Normal')
    ON DUPLICATE KEY UPDATE
        role_name = VALUES(role_name),
        search_name = VALUES(search_name);

SELECT @role_id := role_id FROM role WHERE role_name = 'Master';

INSERT INTO account (user_name, password, changed_password_time, role_id)
    VALUES
        ('master', '$2y$12$T0l3.ELcGL.RXyq7Lbk3a.jVrIjFL5H7nXer70/HGzmZVN7zKedky', 0, @role_id)
    ON DUPLICATE KEY UPDATE
        user_name = VALUES(user_name),
        role_id = @role_id;
