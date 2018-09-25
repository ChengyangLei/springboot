----------------------------------------------------------
-- Export file for user C##ADMIN@10.100.50.80:1521/ORCL --
-- Created by Administrator on 2018/9/20 ������, 14:16:49 ---
----------------------------------------------------------

set define off
spool sys_table.log

prompt
prompt Creating table HT_T_SYS_ORGANIZATION
prompt ====================================
prompt
create global temporary table C##ADMIN.HT_T_SYS_ORGANIZATION
(
  id VARCHAR2(255 CHAR) not null
)
on commit delete rows;

prompt
prompt Creating table T_SYS_DEPARTMENT
prompt ===============================
prompt
create table C##ADMIN.T_SYS_DEPARTMENT
(
  id               VARCHAR2(32) not null,
  code             VARCHAR2(14) not null,
  pid              VARCHAR2(32),
  name             VARCHAR2(60) not null,
  grad             CHAR(1),
  organization_id  VARCHAR2(32) not null,
  resp             VARCHAR2(256) not null,
  order_index      NUMBER,
  status           CHAR(1) not null,
  description      VARCHAR2(256),
  creator          VARCHAR2(32) not null,
  create_time      TIMESTAMP(6) not null,
  last_updator     VARCHAR2(32),
  last_update_time TIMESTAMP(6),
  del_flag         CHAR(1) not null,
  lev              NUMBER
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_DEPARTMENT
  is '����ϵͳ�Ĳ�����Ϣ';
comment on column C##ADMIN.T_SYS_DEPARTMENT.id
  is '����ID';
comment on column C##ADMIN.T_SYS_DEPARTMENT.code
  is '���Ŵ���(��֯��������+�Զ�����)';
comment on column C##ADMIN.T_SYS_DEPARTMENT.pid
  is '��ID(���ݽ���ʱ��ת��Ϊ�ϼ����Ŵ���)';
comment on column C##ADMIN.T_SYS_DEPARTMENT.name
  is '��������';
comment on column C##ADMIN.T_SYS_DEPARTMENT.grad
  is '���ż���';
comment on column C##ADMIN.T_SYS_DEPARTMENT.organization_id
  is '��������ID�����ݽ���ʱ��ת��Ϊ�����������룩';
comment on column C##ADMIN.T_SYS_DEPARTMENT.resp
  is '����ְ��';
comment on column C##ADMIN.T_SYS_DEPARTMENT.order_index
  is '˳���';
comment on column C##ADMIN.T_SYS_DEPARTMENT.status
  is '״̬(0-δ���� 1-����)';
comment on column C##ADMIN.T_SYS_DEPARTMENT.description
  is '��ע';
comment on column C##ADMIN.T_SYS_DEPARTMENT.creator
  is '������';
comment on column C##ADMIN.T_SYS_DEPARTMENT.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_DEPARTMENT.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_DEPARTMENT.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_DEPARTMENT.del_flag
  is 'ɾ����ʶ';
comment on column C##ADMIN.T_SYS_DEPARTMENT.lev
  is '���νṹ���';
create index C##ADMIN.INDEX_DEPARTMENT_NAME on C##ADMIN.T_SYS_DEPARTMENT (NAME)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_DEPARTMENT
  add constraint PK_T_SYS_DEPARTMENT primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_DICTIONARY
prompt ===============================
prompt
create table C##ADMIN.T_SYS_DICTIONARY
(
  id               VARCHAR2(32) not null,
  code             VARCHAR2(100) not null,
  name             VARCHAR2(100) not null,
  order_index      NUMBER not null,
  status           CHAR(1) not null,
  pid              VARCHAR2(32) not null,
  description      VARCHAR2(200),
  create_time      TIMESTAMP(6) not null,
  creator          VARCHAR2(32) not null,
  last_update_time TIMESTAMP(6),
  last_updator     VARCHAR2(32),
  del_flag         CHAR(1) not null,
  value            VARCHAR2(4000),
  lev              NUMBER
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_DICTIONARY
  is '���ڼ�¼ϵͳ�Ļ���������Ϣ';
comment on column C##ADMIN.T_SYS_DICTIONARY.id
  is '����ID';
comment on column C##ADMIN.T_SYS_DICTIONARY.code
  is '������code';
comment on column C##ADMIN.T_SYS_DICTIONARY.name
  is '����������';
comment on column C##ADMIN.T_SYS_DICTIONARY.order_index
  is '������˳��';
comment on column C##ADMIN.T_SYS_DICTIONARY.status
  is '״̬(0-δ����;������)';
comment on column C##ADMIN.T_SYS_DICTIONARY.pid
  is '��������';
comment on column C##ADMIN.T_SYS_DICTIONARY.description
  is '˵��';
comment on column C##ADMIN.T_SYS_DICTIONARY.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_DICTIONARY.creator
  is '������';
comment on column C##ADMIN.T_SYS_DICTIONARY.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_DICTIONARY.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_DICTIONARY.del_flag
  is 'ɾ����ʶ(0-δɾ��;1-��ɾ��)';
comment on column C##ADMIN.T_SYS_DICTIONARY.value
  is '������ֵ';
comment on column C##ADMIN.T_SYS_DICTIONARY.lev
  is '���νṹ���';
create index C##ADMIN.INDEX_T_SYS_DICTIONARY_PID on C##ADMIN.T_SYS_DICTIONARY (PID)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index C##ADMIN.UNIQUE_CODE on C##ADMIN.T_SYS_DICTIONARY (CODE)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_DICTIONARY
  add constraint PK_T_SYS_DICTIONARY primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_JOB
prompt ========================
prompt
create table C##ADMIN.T_SYS_JOB
(
  id               VARCHAR2(32) not null,
  code             VARCHAR2(16) not null,
  name             VARCHAR2(60) not null,
  grad             VARCHAR2(2),
  resp             VARCHAR2(256) not null,
  dept_id          VARCHAR2(32) not null,
  order_index      NUMBER,
  status           CHAR(1),
  description      VARCHAR2(256),
  creator          VARCHAR2(32) not null,
  create_time      TIMESTAMP(6) not null,
  last_updator     VARCHAR2(32),
  last_update_time TIMESTAMP(6),
  del_flag         CHAR(1) not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_JOB
  is '��¼ϵͳ�ĸ�λ��Ϣ';
comment on column C##ADMIN.T_SYS_JOB.id
  is '����ID';
comment on column C##ADMIN.T_SYS_JOB.code
  is '��λ����';
comment on column C##ADMIN.T_SYS_JOB.name
  is '��λ����';
comment on column C##ADMIN.T_SYS_JOB.grad
  is '��λ����';
comment on column C##ADMIN.T_SYS_JOB.resp
  is '��λְ��';
comment on column C##ADMIN.T_SYS_JOB.dept_id
  is '��������ID������ʱ��ҪҪת��Ϊ�������ű��룩';
comment on column C##ADMIN.T_SYS_JOB.order_index
  is '˳���';
comment on column C##ADMIN.T_SYS_JOB.status
  is '״̬(0-δ���� 1-����)';
comment on column C##ADMIN.T_SYS_JOB.description
  is '��ע';
comment on column C##ADMIN.T_SYS_JOB.creator
  is '������';
comment on column C##ADMIN.T_SYS_JOB.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_JOB.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_JOB.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_JOB.del_flag
  is 'ɾ����ʶ';
create index C##ADMIN.AK_JOB_AK_T_SYS_JO on C##ADMIN.T_SYS_JOB (CODE)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index C##ADMIN.INDEX_JOB_NAME on C##ADMIN.T_SYS_JOB (NAME)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_JOB
  add constraint PK_T_SYS_JOB primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_ORGANIZATION
prompt =================================
prompt
create table C##ADMIN.T_SYS_ORGANIZATION
(
  id               VARCHAR2(32) not null,
  code             VARCHAR2(9) not null,
  name             VARCHAR2(60) not null,
  pid              VARCHAR2(32),
  division_id      VARCHAR2(32) not null,
  short_name       VARCHAR2(60),
  type             CHAR(1),
  corporation      VARCHAR2(40) not null,
  specialfication  CHAR(1),
  belong           CHAR(1),
  status           CHAR(1) not null,
  order_index      NUMBER not null,
  url              VARCHAR2(150),
  email            VARCHAR2(150),
  address          VARCHAR2(150),
  zip              VARCHAR2(6),
  telephone        VARCHAR2(33),
  fax              VARCHAR2(33),
  description      VARCHAR2(256),
  creator          VARCHAR2(32) not null,
  create_time      TIMESTAMP(6) not null,
  last_updator     VARCHAR2(32),
  last_update_time TIMESTAMP(6),
  del_flag         CHAR(1) not null,
  lev              NUMBER,
  lttd             NUMBER(18,9),
  lgtd             NUMBER(18,9)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_ORGANIZATION
  is '��֯�����Ļ�����Ϣ������ˮ�������ܲ��š�ˮ����ҵ��λ������ˮ������λ���Լ�Ϊˮ���ṩ�������ҵ���������ȵ�λ�Ļ�����Ϣ';
comment on column C##ADMIN.T_SYS_ORGANIZATION.id
  is '����ID';
comment on column C##ADMIN.T_SYS_ORGANIZATION.code
  is '��֯��������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.name
  is '��������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.pid
  is '��IDֻ���������ID';
comment on column C##ADMIN.T_SYS_ORGANIZATION.division_id
  is '�����㼶����ID(���ݽ���ʱת��Ϊ������������)';
comment on column C##ADMIN.T_SYS_ORGANIZATION.short_name
  is '�������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.type
  is '��������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.corporation
  is '���˴���';
comment on column C##ADMIN.T_SYS_ORGANIZATION.specialfication
  is '�������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.belong
  is '������ϵ';
comment on column C##ADMIN.T_SYS_ORGANIZATION.status
  is '״̬(0-δ���� 1-����)';
comment on column C##ADMIN.T_SYS_ORGANIZATION.order_index
  is '˳���';
comment on column C##ADMIN.T_SYS_ORGANIZATION.url
  is '��վ';
comment on column C##ADMIN.T_SYS_ORGANIZATION.email
  is '����';
comment on column C##ADMIN.T_SYS_ORGANIZATION.address
  is '��ַ';
comment on column C##ADMIN.T_SYS_ORGANIZATION.zip
  is '��������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.telephone
  is '�칫�ҵ绰';
comment on column C##ADMIN.T_SYS_ORGANIZATION.fax
  is '�������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.description
  is '��ע';
comment on column C##ADMIN.T_SYS_ORGANIZATION.creator
  is '������';
comment on column C##ADMIN.T_SYS_ORGANIZATION.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_ORGANIZATION.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_ORGANIZATION.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_ORGANIZATION.del_flag
  is 'ɾ����ʶ';
comment on column C##ADMIN.T_SYS_ORGANIZATION.lev
  is '���νṹ���';
comment on column C##ADMIN.T_SYS_ORGANIZATION.lttd
  is 'γ��';
comment on column C##ADMIN.T_SYS_ORGANIZATION.lgtd
  is '����';
create index C##ADMIN.AK_ORGANIZATION_AK_T_SYS_OR on C##ADMIN.T_SYS_ORGANIZATION (CODE)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index C##ADMIN.INDEX_ORGANIZATION_NAME on C##ADMIN.T_SYS_ORGANIZATION (NAME)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_ORGANIZATION
  add constraint PK_T_SYS_ORGANIZATION primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_RESOURCE
prompt =============================
prompt
create table C##ADMIN.T_SYS_RESOURCE
(
  id               VARCHAR2(32) not null,
  code             VARCHAR2(40) not null,
  name             VARCHAR2(100) not null,
  type             CHAR(1) not null,
  url              VARCHAR2(200),
  pid              VARCHAR2(32) not null,
  order_index      NUMBER not null,
  description      VARCHAR2(200),
  icon             VARCHAR2(200),
  view_type        CHAR(1) not null,
  create_time      TIMESTAMP(6) not null,
  creator          VARCHAR2(32) not null,
  last_update_time TIMESTAMP(6),
  last_updator     VARCHAR2(32),
  del_flag         CHAR(1) default '0' not null,
  lev              NUMBER not null,
  status           NUMBER not null
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_RESOURCE
  is '��¼ϵͳ��Դ��Ϣ(Ȩ��)';
comment on column C##ADMIN.T_SYS_RESOURCE.id
  is '����ID';
comment on column C##ADMIN.T_SYS_RESOURCE.code
  is '��Դ����';
comment on column C##ADMIN.T_SYS_RESOURCE.name
  is '��Դ����';
comment on column C##ADMIN.T_SYS_RESOURCE.type
  is '��Դ����(0-ϵͳ;1-ģ�飻2-����ģ��;3-�˵�;4-������)';
comment on column C##ADMIN.T_SYS_RESOURCE.url
  is '��Դ��ַ';
comment on column C##ADMIN.T_SYS_RESOURCE.pid
  is '����ԴID';
comment on column C##ADMIN.T_SYS_RESOURCE.order_index
  is '��Դ˳��';
comment on column C##ADMIN.T_SYS_RESOURCE.description
  is '��Դ��ע';
comment on column C##ADMIN.T_SYS_RESOURCE.icon
  is '��Դͼ��';
comment on column C##ADMIN.T_SYS_RESOURCE.view_type
  is '��Դ������(0-��ǰҳ���;1-������ʽ��;2-������ʽ)';
comment on column C##ADMIN.T_SYS_RESOURCE.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_RESOURCE.creator
  is '������';
comment on column C##ADMIN.T_SYS_RESOURCE.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_RESOURCE.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_RESOURCE.del_flag
  is 'ɾ����ʶ(0-û��ɾ��;1-�Ѿ�ɾ��)';
comment on column C##ADMIN.T_SYS_RESOURCE.lev
  is '���νṹ���';
comment on column C##ADMIN.T_SYS_RESOURCE.status
  is '�˺�����״̬(0-���� 1-����)';
create index C##ADMIN.AK_UK_RESOURCE_T_SYS_RE on C##ADMIN.T_SYS_RESOURCE (CODE)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_RESOURCE
  add constraint PK_T_SYS_RESOURCE primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_ROLE
prompt =========================
prompt
create table C##ADMIN.T_SYS_ROLE
(
  id               VARCHAR2(32) not null,
  name             VARCHAR2(100) not null,
  status           CHAR(1) not null,
  description      VARCHAR2(200),
  create_time      TIMESTAMP(6) not null,
  creator          VARCHAR2(32) not null,
  last_update_time TIMESTAMP(6),
  last_updator     VARCHAR2(32),
  del_flag         CHAR(1) not null,
  temp_flag        CHAR(1) not null,
  end_time         TIMESTAMP(6),
  code             VARCHAR2(40),
  type             CHAR(1)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_ROLE
  is '��ɫ';
comment on column C##ADMIN.T_SYS_ROLE.id
  is '��ɫID';
comment on column C##ADMIN.T_SYS_ROLE.name
  is '��ɫ����';
comment on column C##ADMIN.T_SYS_ROLE.status
  is '��ɫʹ��״̬(0-����;1-����)';
comment on column C##ADMIN.T_SYS_ROLE.description
  is '˵��';
comment on column C##ADMIN.T_SYS_ROLE.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_ROLE.creator
  is '������';
comment on column C##ADMIN.T_SYS_ROLE.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_ROLE.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_ROLE.del_flag
  is 'ɾ����־';
comment on column C##ADMIN.T_SYS_ROLE.temp_flag
  is '��ʱ��ʶ(0-����ʱ��ɫ,1-��ʱ��ɫ)';
comment on column C##ADMIN.T_SYS_ROLE.end_time
  is '��ʱ��ɫ��ֹ����';
comment on column C##ADMIN.T_SYS_ROLE.code
  is '��ɫ����';
comment on column C##ADMIN.T_SYS_ROLE.type
  is '��ɫ���1-��Ԫ����Ա 2-��Ԫ��ȫԱ 3-��Ԫ���Ա 4-����Ԫ������Ա��';
create index C##ADMIN.AK_UK_ROLE_T_SYS_ROLE on C##ADMIN.T_SYS_ROLE (CODE)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_ROLE
  add constraint PK_T_SYS_ROLE primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_ROLE_RESOURCE_R
prompt ====================================
prompt
create table C##ADMIN.T_SYS_ROLE_RESOURCE_R
(
  role_id     VARCHAR2(32),
  resource_id VARCHAR2(32)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column C##ADMIN.T_SYS_ROLE_RESOURCE_R.role_id
  is '��ɫID';
comment on column C##ADMIN.T_SYS_ROLE_RESOURCE_R.resource_id
  is '��ԴID';
alter table C##ADMIN.T_SYS_ROLE_RESOURCE_R
  add constraint AK_UK_ROLE_RESOURCE_T_SYS_RO unique (ROLE_ID, RESOURCE_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_USER
prompt =========================
prompt
create table C##ADMIN.T_SYS_USER
(
  id               VARCHAR2(32) not null,
  user_name        VARCHAR2(40) not null,
  password         VARCHAR2(40) not null,
  name             VARCHAR2(40) not null,
  card_id          VARCHAR2(18),
  sex              CHAR(1) not null,
  duty_level       CHAR(2) default '1',
  tech_title       VARCHAR2(256),
  degree           CHAR(1),
  telephone        VARCHAR2(15),
  mobile           VARCHAR2(11),
  email            VARCHAR2(40),
  birthday         DATE,
  start_workdate   DATE,
  school           VARCHAR2(100),
  study_major      VARCHAR2(100),
  address          VARCHAR2(100),
  born_place       VARCHAR2(100),
  political_status VARCHAR2(32),
  nationality      VARCHAR2(32),
  order_index      NUMBER not null,
  description      VARCHAR2(256),
  status           NUMBER not null,
  login_time       TIMESTAMP(6),
  logout_time      TIMESTAMP(6),
  line_status      CHAR(1),
  creator          VARCHAR2(32) not null,
  create_time      TIMESTAMP(6) not null,
  last_updator     VARCHAR2(32),
  last_update_time TIMESTAMP(6),
  del_flag         CHAR(1) not null,
  type             CHAR(1)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_USER
  is '��¼ϵͳ���û���Ϣ�����˺���Ϣ���û������Ϣ,��¼�ǳ���';
comment on column C##ADMIN.T_SYS_USER.id
  is '����ID';
comment on column C##ADMIN.T_SYS_USER.user_name
  is '�û���';
comment on column C##ADMIN.T_SYS_USER.password
  is '����';
comment on column C##ADMIN.T_SYS_USER.name
  is '����';
comment on column C##ADMIN.T_SYS_USER.card_id
  is '���֤����';
comment on column C##ADMIN.T_SYS_USER.sex
  is '�Ա�(����)';
comment on column C##ADMIN.T_SYS_USER.duty_level
  is 'ְ�񼶱�(����)';
comment on column C##ADMIN.T_SYS_USER.tech_title
  is '����ְ��(�ֶ���д)';
comment on column C##ADMIN.T_SYS_USER.degree
  is 'ѧ��(����)';
comment on column C##ADMIN.T_SYS_USER.telephone
  is '�绰����';
comment on column C##ADMIN.T_SYS_USER.mobile
  is '�ֻ�����';
comment on column C##ADMIN.T_SYS_USER.email
  is '�����ʼ�';
comment on column C##ADMIN.T_SYS_USER.birthday
  is '��������';
comment on column C##ADMIN.T_SYS_USER.start_workdate
  is '��ʼ����ʱ��';
comment on column C##ADMIN.T_SYS_USER.school
  is '��ҵԺУ';
comment on column C##ADMIN.T_SYS_USER.study_major
  is '��ѧרҵ';
comment on column C##ADMIN.T_SYS_USER.address
  is '��ͥסַ';
comment on column C##ADMIN.T_SYS_USER.born_place
  is '������';
comment on column C##ADMIN.T_SYS_USER.political_status
  is '������ò';
comment on column C##ADMIN.T_SYS_USER.nationality
  is '�û�����';
comment on column C##ADMIN.T_SYS_USER.order_index
  is '˳���';
comment on column C##ADMIN.T_SYS_USER.description
  is '��ע';
comment on column C##ADMIN.T_SYS_USER.status
  is '�˺�����״̬(0-���� 1-����)';
comment on column C##ADMIN.T_SYS_USER.login_time
  is '��¼ʱ��';
comment on column C##ADMIN.T_SYS_USER.logout_time
  is '�ǳ�ʱ��';
comment on column C##ADMIN.T_SYS_USER.line_status
  is '��¼״̬(0-�˳�״̬1-��¼״̬)';
comment on column C##ADMIN.T_SYS_USER.creator
  is '������';
comment on column C##ADMIN.T_SYS_USER.create_time
  is '����ʱ��';
comment on column C##ADMIN.T_SYS_USER.last_updator
  is '�޸���';
comment on column C##ADMIN.T_SYS_USER.last_update_time
  is '�޸�ʱ��';
comment on column C##ADMIN.T_SYS_USER.del_flag
  is 'ɾ����ʶ(0-δɾ��;1-��ɾ��)';
comment on column C##ADMIN.T_SYS_USER.type
  is '���ͣ��Ƿ����Ա0-�ǹ���Ա 1-����Ա��';
create index C##ADMIN.AK_UK_USER_T_SYS_US on C##ADMIN.T_SYS_USER (USER_NAME)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table C##ADMIN.T_SYS_USER
  add constraint PK_T_SYS_USER primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_USER_DEP_R
prompt ===============================
prompt
create table C##ADMIN.T_SYS_USER_DEP_R
(
  user_id VARCHAR2(32) not null,
  dept_id VARCHAR2(32) not null,
  type    CHAR(1) default '1'
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column C##ADMIN.T_SYS_USER_DEP_R.user_id
  is '�û�ID';
comment on column C##ADMIN.T_SYS_USER_DEP_R.dept_id
  is '����ID';
alter table C##ADMIN.T_SYS_USER_DEP_R
  add constraint PK_T_SYS_USER_DEP_R primary key (USER_ID, DEPT_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_USER_JOB_R
prompt ===============================
prompt
create table C##ADMIN.T_SYS_USER_JOB_R
(
  user_id VARCHAR2(32) not null,
  job_id  VARCHAR2(32) not null,
  type    CHAR(1) default '1'
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column C##ADMIN.T_SYS_USER_JOB_R.user_id
  is '�û�ID';
comment on column C##ADMIN.T_SYS_USER_JOB_R.job_id
  is '��λID';
alter table C##ADMIN.T_SYS_USER_JOB_R
  add constraint PK_T_SYS_USER_JOB_R primary key (USER_ID, JOB_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_USER_ROLE_R
prompt ================================
prompt
create table C##ADMIN.T_SYS_USER_ROLE_R
(
  user_id VARCHAR2(32),
  role_id VARCHAR2(32)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table C##ADMIN.T_SYS_USER_ROLE_R
  is '��¼�û���Ӧ�Ľ�ɫ��Ϣ';
comment on column C##ADMIN.T_SYS_USER_ROLE_R.user_id
  is '�û�ID';
comment on column C##ADMIN.T_SYS_USER_ROLE_R.role_id
  is '��ɫID';
alter table C##ADMIN.T_SYS_USER_ROLE_R
  add constraint AK_UK_USER_ROLE_T_SYS_US unique (ROLE_ID, USER_ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
