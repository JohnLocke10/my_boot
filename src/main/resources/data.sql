insert into topic(id, name, description) values ('topicId1', 'topicName1', 'topicDesc1');
insert into topic(id, name, description) values ('topicId2', 'topicName2', 'topicDesc2');

insert into course(id, name, description, topic_id) values ('courseId1', 'courseName1', 'courseDesc1', 'topicId1');
insert into course(id, name, description, topic_id) values ('courseId2', 'courseName2', 'courseDesc2', 'topicId2');

--commit;