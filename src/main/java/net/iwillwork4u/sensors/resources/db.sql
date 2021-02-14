drop table if exists user;
drop table if exists sensor;
drop table if exists measurement;

create table user(
    user_id identity,
    user_name varchar(30),
    email varchar(30),
/*    password_hash varchar(60),*/
    created_date timestamp,
    last_modified_date timestamp,
    phonenumber varchar(25),
    carrier varchar(25),
    constraint pk_uid primary key( user_id )
);

create table sensor(
    sensor_id identity ,
    sensor_name varchar(30),
    htAlert integer,
    ltAlert integer,
    lhAlert integer,
    hhAlert integer,
    tempAlertOn boolean,
    humAlertOn boolean,
    timeBetweenAlerts integer,
    alertTriggered timestamp,
    lastTemp double,
    uid long,
    constraint pk_sid primary key ( sensor_id ),
    constraint fk_uid foreign key ( uid ) references ( uid )
);

create table measurement
(
    measurement_id identity,
    timestamp   timestamp,
    temperature double,
    humidity    double,
    sid long,
    constraint pk_mid primary key ( measurement_id ),
    constraint fk_sid foreign key ( sid ) references ( sid )
);

insert into user values ( 4, 'u2',  'u2@email.com', {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 18:47:52.69'},  '5555555555', 'SPRINT' );
insert into sensor values ( 2 ,'s1', 80, 50, 80, 50,true, true, 1, {ts '2012-09-17 18:47:52.69'}, 1, 70.0 );
insert into measurement values ( 3, {ts '2012-09-17 18:47:52.69'}, 70.0, 50.0, 2 );

/*create table user(
                     deptno numeric,
                     dname  varchar(14),
                     loc    varchar(13),
                     constraint pk_dept primary key ( deptno )
);

create table emp(
                    empno    numeric,
                    ename    varchar(10),
                    job      varchar(9),
                    mgr      numeric,
                    hiredate date,
                    sal      numeric,
                    comm     numeric,
                    deptno   numeric,
                    constraint pk_emp primary key ( empno ),
                    constraint fk_deptno foreign key ( deptno ) references dept ( deptno )
);

insert into dept values( 10, 'ACCOUNTING', 'NEW YORK' );
insert into dept values( 20, 'RESEARCH', 'DALLAS' );
insert into dept values( 30, 'SALES', 'CHICAGO' );
insert into dept values( 40, 'OPERATIONS', 'BOSTON' );

insert into emp values(
                          7839, 'KING', 'PRESIDENT', null,
                          to_date( '17-11-1981' , 'dd-mm-yyyy' ),
                          7698, null, 10
                      );
insert into emp values(
                          7698, 'BLAKE', 'MANAGER', 7839,
                          to_date( '1-5-1981' , 'dd-mm-yyyy' ),
                          7782, null, 20
                      );
insert into emp values(
                          7782, 'CLARK', 'MANAGER', 7839,
                          to_date( '9-6-1981' , 'dd-mm-yyyy' ),
                          7566, null, 30
                      );
insert into emp values(
                          7566, 'JONES', 'MANAGER', 7839,
                          to_date( '2-4-1981' , 'dd-mm-yyyy' ),
                          7839, null, 40
                      );*/