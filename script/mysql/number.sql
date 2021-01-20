
-- 测试bit表
-- drop table bit_test
create table bit_test (id int not null AUTO_INCREMENT, b0 bit,b1 bit(1),b2 bit(2),b3 bit(3),b10 bit(10),b20 bit(20),b60 bit(60)
,b64 bit(64),
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 测试tinyint表
create table tinyint_test (id int not null AUTO_INCREMENT, t1 tinyint(1),t2 tinyint(2),t10 tinyint(10),t20 tinyint(20)
,t64 tinyint(64),t100 tinyint(100),
st1 tinyint(1) zerofill,st2 tinyint(2) zerofill,st10 tinyint(10) zerofill,st20 tinyint(20) zerofill
,st64 tinyint(64) zerofill,st100 tinyint(100) zerofill,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 测试tinyint表
create table int_test (id int not null AUTO_INCREMENT, t1 int(1),t2 int(2),t10 int(10),t20 int(20)
,t64 int(64),t100 int(100),
st1 int(1) zerofill,st2 int(2) zerofill,st10 int(10) zerofill,st20 int(20) zerofill
,st64 int(64) zerofill,st100 int(100) zerofill,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table int_test1 (id int not null AUTO_INCREMENT, t0 int, st1 int(1) ,st10 int(10) ,st100 int(100) ,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table int_test2 (id int not null AUTO_INCREMENT, t0 int,t1 int(1),t10 int(10),t100 int(100),
st0 int zerofill,st1 int(1) zerofill,st10 int(10) zerofill,st100 int(100) zerofill,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table serial_test (id SERIAL);

-- decimal table
create table decimal_table(id serial, m1 decimal(20,8),m2 dec(10,2),m3 NUMERIC(8,2),m4 fixed(6,2))

create table t1(a int(11));
create table t2(a int(11),b int(11));
create table t3(b int(11));

insert into t1 values(1);
insert into t1 values(2);
insert into t2 values(1,101);
insert into t3 values(101);