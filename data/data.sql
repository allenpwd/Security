INSERT INTO `sys_user`(`id`, `username`, `password`, `create_date`, `last_login_time`, `enabled`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`) VALUES (1, 'allen', '$2a$10$Vvs5.7dQVCPZqjaMrxMaSu5YMt4wLSLi7saq.G6xIDffevjChu2P2', '2019-09-03 16:02:07', '2019-09-12 16:02:10', 1, 1, 1, 1);
INSERT INTO `sys_user`(`id`, `username`, `password`, `create_date`, `last_login_time`, `enabled`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`) VALUES (2, 'pwd', '$2a$10$Vvs5.7dQVCPZqjaMrxMaSu5YMt4wLSLi7saq.G6xIDffevjChu2P2', '2019-08-30 16:02:23', '2019-09-12 16:02:28', 1, 1, 1, 1);


INSERT INTO `sys_role`(`id`, `role_name`, `role_desc`) VALUES (1, 'ADMIN', '管理员');
INSERT INTO `sys_role`(`id`, `role_name`, `role_desc`) VALUES (2, 'USER', '普通用户');


INSERT INTO `sys_auth`(`id`, `auth_name`, `auth_desc`) VALUES (1, 'PRODUCT_LIST', '产品查看');
INSERT INTO `sys_auth`(`id`, `auth_name`, `auth_desc`) VALUES (2, 'PRODUCT_ADD', '产品添加');
INSERT INTO `sys_auth`(`id`, `auth_name`, `auth_desc`) VALUES (3, 'PRODUCT_UPDATE', '产品修改');
INSERT INTO `sys_auth`(`id`, `auth_name`, `auth_desc`) VALUES (4, 'PRODUCT_DELETE', '产品删除');


INSERT INTO `sys_role_auth`(`auth_id`, `role_id`) VALUES (1, 1);
INSERT INTO `sys_role_auth`(`auth_id`, `role_id`) VALUES (2, 1);
INSERT INTO `sys_role_auth`(`auth_id`, `role_id`) VALUES (3, 1);
INSERT INTO `sys_role_auth`(`auth_id`, `role_id`) VALUES (4, 1);
INSERT INTO `sys_role_auth`(`auth_id`, `role_id`) VALUES (1, 2);


INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (1, 2);
INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (2, 1);

