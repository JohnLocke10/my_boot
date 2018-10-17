create table topics(
id varchar (30) primary key,
name varchar(200),
description varchar2(200));

create table courses(
id varchar(30) primary key,
name varchar(200),
description varchar(200),
topic_id varchar(30));

ALTER TABLE courses
ADD CONSTRAINT topic_fk
FOREIGN KEY (topic_id) REFERENCES topics(id);

create table students(
id number (20) primary key,
first_name varchar (100),
last_name varchar (100),
age number(2));

create table courses_students(
course_id varchar(30),
student_id number(20));

ALTER TABLE courses_students
ADD CONSTRAINT courses_fk
FOREIGN KEY (course_id) REFERENCES courses(id);

ALTER TABLE courses_students
ADD CONSTRAINT student_fk
FOREIGN KEY (student_id) REFERENCES students(id);
