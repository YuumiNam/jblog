select * from blog;

-- 블로그 생성
insert into blog value('dltjsam', concat('이선무','의 블로그'), '하이');

select a.name as userName
	from user a, blog b
    where a.id = b.id;

-- 블로그 메인
-- post가 비어있을때
select a.name as userName, b.title, b.profile, c.no as categoryNo, c.title as categoryTitle 
				from user a, blog b, category c 
					where a.id = 'dooli'
						and b.id = c.id;

-- post가 비어있지않을때
select a.name as userName, b.title, b.profile, c.no as categoryNo, c.title as categoryTitle, d.contents as postContents, d.reg_date as postDate 
	from user a, blog b, category c, post d 
		where a.id = b.id 
			and b.id = c.id 
            and c.no = d.category_no;                  
						


delete from blog;