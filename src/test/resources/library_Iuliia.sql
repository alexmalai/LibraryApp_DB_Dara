

select b.name as bookName, author, bc.name as bookCategoryName from books b inner join
                                                                    book_categories bc on b.book_category_id = bc.id
where b.name = 'Lord of the Files';

