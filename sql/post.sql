select * from post;

select * from user;
select * from blog;
select * from category;
select * from post;

-- 포스트에서 카테고리 불러오기
select no as categoryNo, title
	from category;

-- 포스트 생성
insert into post 
	values (null, '하이', '하이', now(), 3);
    
delete from post;