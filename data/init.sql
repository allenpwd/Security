/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/9/11 23:15:08                           */
/*==============================================================*/


drop table if exists sys_role_auth;
drop table if exists sys_user_role;
drop table if exists sys_auth;
drop table if exists sys_role;
drop table if exists sys_user;


/*==============================================================*/
/* Table: sys_auth                                              */
/*==============================================================*/
create table sys_auth
(
   id                   int(10) not null comment '权限ID',
   auth_name            varchar(50) comment '权限名',
   auth_desc            varchar(50) comment '权限描述符',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   int(10) not null comment '角色ID',
   role_name            varchar(50) comment '角色名',
   role_desc            varchar(50) comment '角色说明',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role_auth                                         */
/*==============================================================*/
create table sys_role_auth
(
   auth_id               int(10) comment '权限ID',
   role_id              int(10) comment '角色ID'
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   int(10) not null comment '用户ID',
   username             varchar(50) comment '用户名',
   password             varchar(50) comment '密码',
   create_date          datetime comment '创建日期',
   last_login_time      datetime comment '最后登录时间',
   enabled              int(5) comment '是否可用',
   account_non_expired          int(5) comment '是否没过期',
   account_non_locked           int(5) comment '是否没锁定',
   credentials_non_expired int(5) comment '证书是否没过期',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   user_id              int(10) comment '用户ID',
   role_id              int(10) comment '角色ID'
);

alter table sys_role_auth add constraint FK_Reference_3 foreign key (auth_id)
      references sys_auth (id) on delete restrict on update restrict;

alter table sys_role_auth add constraint FK_Reference_4 foreign key (role_id)
      references sys_role (id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_1 foreign key (user_id)
      references sys_user (id) on delete restrict on update restrict;

alter table sys_user_role add constraint FK_Reference_2 foreign key (role_id)
      references sys_role (id) on delete restrict on update restrict;

