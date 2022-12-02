select * from blog;

-- 블로그 생성
insert into blog value('dltjsam', '이선무블로그', '하이');

-- 블로그 메인
select a.name, b.title 
	from user a, blog b 
	where b.title = '블로그';
                     
						


delete from blog;