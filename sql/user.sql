show tables;

desc user;
desc blog;
desc category;
desc post;

select * from user;
select * from blog;
select * from category;

-- 회원가입
insert 
	into user 
	values('dltjsam', '이선무', 1234);

-- findByIdAndPassword
select id, password 
	from user;

delete from user;