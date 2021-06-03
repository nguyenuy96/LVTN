DELETE FROM account;
DELETE FROM role;
DELETE FROM privilege;

INSERT INTO privilege (name)
    VALUES
        ('WRITE'),
        ('WRITE_SCOPE'),
        ('WRITE_SCOPE1'),
        ('READ')
    ON DUPLICATE KEY UPDATE
        name = VALUES(name);

SELECT @privilege_write := privilege_id FROM privilege WHERE name = 'WRITE';
SELECT @privilege_write_scope := privilege_id FROM privilege WHERE name = 'WRITE_SCOPE';
SELECT @privilege_write_scope1 := privilege_id FROM privilege WHERE name = 'WRITE_SCOPE1';
SELECT @privilege_write_read := privilege_id FROM privilege WHERE name = 'READ';

INSERT INTO role (role_name, search_name, privilege_id)
    VALUES
        ('Master', 'Master', @privilege_write),
        ('Administrator', 'Administrator', @privilege_write_scope),
        ('Employee', 'Employee', @privilege_write_scope1),
        ('Normal', 'Normal', @privilege_write_read)
    ON DUPLICATE KEY UPDATE
        role_name = VALUES(role_name),
        search_name = VALUES(search_name);

SELECT @role_id := role_id FROM role WHERE role_name = 'Master';

INSERT INTO account (user_name, password, changed_password_time, role_id, is_active)
    VALUES
        ('master', '$2y$12$T0l3.ELcGL.RXyq7Lbk3a.jVrIjFL5H7nXer70/HGzmZVN7zKedky', 0, @role_id, true)
    ON DUPLICATE KEY UPDATE
        user_name = VALUES(user_name),
        role_id = @role_id;
