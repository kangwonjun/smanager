--tbl_student ���̺��.
	create table tbl_student (
	std_no varchar2(10) primary key,
	std_name varchar2(100) not null,
	std_phone varchar2(20),-- 010-1111-2222
	address varchar2(100),
	birth_date date,
	creation_date date default sysdate
	);
    
    insert into tbl_student (std_no, std_name, std_phone,address)
	values('s2024-01', 'ȫ�浿', '010-1234-1234', '���� 100����');
	
	insert into tbl_student (std_no, std_name, std_phone,address)
	values('s2024-02', '��浿', '010-1234-1234', '���� 99����');
	
	insert into tbl_student (std_no, std_name, std_phone,address)
	values('s2024-03', '���浿', '010-1234-1234', '���� 88����');
	
	select *
    from tbl_student;

      	update tbl_student
	set address ='���� 100'
	where std_no = 's2024-01';
    
    
     insert into tbl_student (std_no, std_name, std_phone)
    values('s2024-04','��α�','010-2222-5678');
    
    
    
    select *
    from tbl_student;
    
    --���� �ּ� ����
    update tbl_student
    set birth_date = to_date('1997-05-05','yyyy-mm-dd')
            ,address = '���� 200'
    where std_no ='s2024-02';   
    
    
    update tbl_student
    set birth_date = to_date('1995-08-25','yyyy-mm-dd')
            ,address = '���� 100'
    where std_no ='s2024-01';   
    
    
    
     update tbl_student
    set birth_date = to_date('1999-03-25','yyyy-mm-dd')
            ,address = '�뱸 ���ε�'
    where std_no ='s2024-04'; 
    
    update tbl_student
	set birth_date =to_date('2002-03-25','yyyy-mm-dd')
	where std_no = 's2024-03';
    

    
    update tbl_student
	set std_phone ='010-5846-6951'
	where std_no = 's2024-04';
    
    update tbl_student
	set std_no ='s2024-09'
	where std_name = '������';
    
    --�̸�����
    update tbl_student
    set   std_no = '���氪'  
            ,std_name = '���氪'
            ,std_phone = '���氪'
    where std_no ='s2024-02'; 
    
   DELETE from tbl_student
   where std_no = 's2024-02';
    
    
    
     select *
    from tbl_student;
    
    
    rollback;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    