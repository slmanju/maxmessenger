SET REFERENTIAL_INTEGRITY FALSE;
truncate table message;
truncate table m_role;
truncate table m_user;
SET REFERENTIAL_INTEGRITY TRUE;
--
insert into m_role (id, code, name) values ('1', 'ADMIN', 'Admin');
--
insert into m_user (id, email, password, first_name, last_name, birth_date, profile_picture, role_id) values ('1', 'manjula121@gmail.com', 'manjula', 'Manjula', 'Jayawardana', '1983-10-13', 'noimage.png', '1');
insert into m_user (id, email, password, first_name, last_name, birth_date, profile_picture, role_id) values ('2', 'manjula.jayawardana@seebo.com.au', 'manjula', 'Manjula', 'Jayawardana', '1983-10-13', 'noimage.png', '1');