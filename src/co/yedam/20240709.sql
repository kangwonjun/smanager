--tbl_student 테이블명.
	create table tbl_student (
	std_no varchar2(10) primary key,
	std_name varchar2(100) not null,
	std_phone varchar2(20),-- 010-1111-2222
	address varchar2(100),
	birth_date date,
	creation_date date default sysdate
	);
    
    insert into tbl_student (std_no, std_name, std_phone,address)
	values('s2024-01', '홍길동', '010-1234-1234', '서울 100번지');
	
	insert into tbl_student (std_no, std_name, std_phone,address)
	values('s2024-02', '김길동', '010-1234-1234', '서울 99번지');
	
	insert into tbl_student (std_no, std_name, std_phone,address)
	values('s2024-03', '강길동', '010-1234-1234', '서울 88번지');
	
	select *
    from tbl_student;

      	update tbl_student
	set address ='대전 100'
	where std_no = 's2024-01';
    
    
     insert into tbl_student (std_no, std_name, std_phone)
    values('s2024-04','김민규','010-2222-5678');
    
    
    
    select *
    from tbl_student;
    
    --생일 주소 변경
    update tbl_student
    set birth_date = to_date('1997-05-05','yyyy-mm-dd')
            ,address = '대전 200'
    where std_no ='s2024-02';   
    
    
    update tbl_student
    set birth_date = to_date('1995-08-25','yyyy-mm-dd')
            ,address = '대전 100'
    where std_no ='s2024-01';   
    
    
    
     update tbl_student
    set birth_date = to_date('1999-03-25','yyyy-mm-dd')
            ,address = '대구 동인동'
    where std_no ='s2024-04'; 
    
    update tbl_student
	set birth_date =to_date('2002-03-25','yyyy-mm-dd')
	where std_no = 's2024-03';
    

    
    update tbl_student
	set std_phone ='010-5846-6951'
	where std_no = 's2024-04';
    
    update tbl_student
	set std_no ='s2024-09'
	where std_name = '강민준';
    
    --이름변경
    update tbl_student
    set   std_no = '변경값'  
            ,std_name = '변경값'
            ,std_phone = '변경값'
    where std_no ='s2024-02'; 
    
   DELETE from tbl_student
   where std_no = 's2024-02';
    
    
    
     select *
    from tbl_student;
    
    
    rollback;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    