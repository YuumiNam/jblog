show tables;

desc user;
desc blog;
desc category;
desc post;

select * from user;
select * from blog;
select * from category;
select * from post;

-- 회원가입
insert 
	into user 
	values('dltjsam', '이선무', 1234);

-- findByIdAndPassword
select id
	from user 
    where id = 'dltjsam'
		and password = '1234';

delete from user;