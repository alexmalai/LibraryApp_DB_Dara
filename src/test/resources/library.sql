-- US 1

select count(id) from users;
-- 1855

select count(distinct id) from users;
-- 1855

-- RESULT --> MANUALLY PASSED


select * from users;

select count(*) from book_borrow
where is_returned = 0;

select name from books;