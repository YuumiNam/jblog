select * from category;

-- 카테고리 생성
insert into category values (null, '카테고리3', '기본 설명', 'dltjsam');

-- findAll
select a.no, a.title, a.expla, b.postCount
	from category a, (select category_no, count(*) as postCount
						from post
						group by category_no) b
    where a.no = b.category_no
		and id = 'dltjsam';

select category_no, count(*) as postCount
	from post
	group by category_no;

-- delete
delete 
	from category
	where no = '20';

delete from category;

select last_insert_id();