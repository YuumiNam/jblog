select * from category;
select * from post;

-- 카테고리 생성
insert into category values (null, '카테고리10', '카테고리10', 'dltjsam');

-- findAll
select a.no, a.title, a.expla, b.postCount
	from category a, (select category_no, count(*) as postCount
						from post
						group by category_no) b
    where a.no = b.category_no
		and id = 'dltjsam';

-- findAll 포스트 수가 0일때에도 카테고리가 온전히 잘 나옴
select (select count(*) from post p
				where category_no=c.no) num 
			from category c 
			where id='dltjsam';

-- findAll 포스트 수가 0인 카테고리는 안나옴 (오답)
select category_no, count(*) as postCount
						from post
						group by category_no;

-- delete
delete 
	from category
	where no = '20';

delete from category;

select last_insert_id();