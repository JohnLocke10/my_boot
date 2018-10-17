insert into topics(id, name, description) values ('topicId1', 'topicName1', 'topicDesc1');
insert into topics(id, name, description) values ('topicId2', 'topicName2', 'topicDesc2');

insert into courses(id, name, description, topic_id) values ('courseId1', 'courseName1', 'courseDesc1', 'topicId1');
insert into courses(id, name, description, topic_id) values ('courseId2', 'courseName2', 'courseDesc2', 'topicId2');

insert into students(id, first_name, last_name, age) values (1, 'Kilian', 'Mbappe', 19);
insert into students(id, first_name, last_name, age) values (2, 'Mario', 'Balotelli', 27);

--commit;