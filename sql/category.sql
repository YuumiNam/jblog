select * from category;

-- 카테고리 생성
insert into category values (null, '카테고리3', '기본 설명', 'dltjsam');

-- findAll
select no, title, expla
	from category
    where id = 'dltjsam';

-- delete
delete 
	from category
	where no = '20';

delete from category;

select last_insert_id();