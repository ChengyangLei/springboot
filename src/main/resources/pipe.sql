create user c##pipe identified by pipe123;

grant CONNECT,CREATE TABLE,CREATE VIEW,RESOURCE,UNLIMITED TABLESPACE to c##pipe;

create tablespace TBS_PIPE
datafile 'D:\oracle\oradata\TBS_PIPE.dbf'
size 256M
extent management local;

create table C##PIPE.DSE_PIPE_BASEINFO
(
  id                VARCHAR2(32) not null,
  pipe_name         VARCHAR2(50),
  code              VARCHAR2(20),
  pipeline_code     VARCHAR2(32),
  pipeline_name     VARCHAR2(50),
  pipe_material     VARCHAR2(50),
  pipe_length       NUMBER(10,2),
  pipe_radius       VARCHAR2(50),
  pipe_thickness    NUMBER,
  interface_type    VARCHAR2(32),
  start_point       VARCHAR2(32),
  end_point         VARCHAR2(32),
  company_id        VARCHAR2(32),
  install_time      DATE,
  status            CHAR(1),
  temperrature      NUMBER,
  trans_medium      VARCHAR2(32),
  pressure          NUMBER(5,2),
  flow_threshold    NUMBER(5,2),
  pres_threshold    NUMBER(5),
  design_dept       VARCHAR2(32),
  construction_dept VARCHAR2(32),
  supervisor_dept   VARCHAR2(32),
  build_dept        VARCHAR2(32),
  location          VARCHAR2(50),
  use_year          NUMBER,
  type              CHAR(1),
  location_id       VARCHAR2(32),
  create_user       VARCHAR2(32),
  create_time       DATE,
  update_time       DATE,
  update_user       VARCHAR2(32),
  road_weight       VARCHAR2(32),
  pipe_deep         VARCHAR2(32)
)
tablespace TBS_PIPE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

alter table C##PIPE.DSE_PIPE_BASEINFO
  add constraint PK_DSE_PIPE_BASEINFO primary key (ID)
  using index 
  tablespace TBS_PIPE
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
