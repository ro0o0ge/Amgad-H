-- backup actual_grade
create table `actual_grades.7.2020` as select * from actual_grades;
truncate table actual_grades;
-- bacup student_att
create table `student_attendance.7.2020` as select * from student_attendance;
truncate table student_attendance;
-- backup student_exp
create table `student_expenses.7.2020` as select * from student_expenses;
truncate table student_expenses;
-- 3rd secondary
update class_students set c_id = null where c_id > 67;
-- 2nd secondary
update class_students set c_id = 72 where c_id = 66;
update class_students set c_id = 71 where c_id = 65;
update class_students set c_id = 70 where c_id = 64;
update class_students set c_id = 69 where c_id = 63;
update class_students set c_id = 68 where c_id = 62;
update class_students set c_id = 67 where c_id = 61;
-- 1st secondary
update class_students set c_id = 66 where c_id = 60;
update class_students set c_id = 65 where c_id = 59;
update class_students set c_id = 64 where c_id = 58;
update class_students set c_id = 63 where c_id = 57;
update class_students set c_id = 62 where c_id = 56;
update class_students set c_id = 61 where c_id = 55;
-- 6th primary
update class_students set c_id = 58 where c_id = 51;
update class_students set c_id = 59 where c_id = 52;
update class_students set c_id = 60 where c_id = 53;
update class_students set c_id = 60 where c_id = 54;
update class_students set c_id = 55 where c_id = 47;
update class_students set c_id = 56 where c_id = 48;
update class_students set c_id = 57 where c_id = 49;
update class_students set c_id = 57 where c_id = 50;
-- 5th primary
update class_students set c_id = 54 where c_id = 46;
update class_students set c_id = 53 where c_id = 45;
update class_students set c_id = 52 where c_id = 44;
update class_students set c_id = 51 where c_id = 43;
update class_students set c_id = 50 where c_id = 42;
update class_students set c_id = 49 where c_id = 41;
update class_students set c_id = 48 where c_id = 40;
update class_students set c_id = 47 where c_id = 39;
-- 4th primary
update class_students set c_id = 46 where c_id = 38;
update class_students set c_id = 45 where c_id = 37;
update class_students set c_id = 44 where c_id = 36;
update class_students set c_id = 43 where c_id = 35;
update class_students set c_id = 42 where c_id = 34;
update class_students set c_id = 41 where c_id = 33;
update class_students set c_id = 40 where c_id = 32;
update class_students set c_id = 39 where c_id = 31;
-- 3th primary
update class_students set c_id = 38 where c_id = 30;
update class_students set c_id = 37 where c_id = 29;
update class_students set c_id = 36 where c_id = 28;
update class_students set c_id = 35 where c_id = 27;
update class_students set c_id = 34 where c_id = 26;
update class_students set c_id = 33 where c_id = 25;
update class_students set c_id = 32 where c_id = 24;
update class_students set c_id = 31 where c_id = 23;
-- 2nd primary
update class_students set c_id = 30 where c_id = 22;
update class_students set c_id = 29 where c_id = 21;
update class_students set c_id = 28 where c_id = 20;
update class_students set c_id = 27 where c_id = 19;
update class_students set c_id = 26 where c_id = 18;
update class_students set c_id = 25 where c_id = 17;
update class_students set c_id = 24 where c_id = 16;
update class_students set c_id = 23 where c_id = 15;
-- 1st primary
update class_students set c_id = 22 where c_id = 14;
update class_students set c_id = 21 where c_id = 13;
update class_students set c_id = 20 where c_id = 12;
update class_students set c_id = 19 where c_id = 11;
update class_students set c_id = 18 where c_id = 10;
update class_students set c_id = 17 where c_id = 9;
update class_students set c_id = 16 where c_id = 8;
update class_students set c_id = 15 where c_id = 7;



