### table
```
-- 회원 테이블
create table member_table_project(
id bigint primary key auto_increment unique,
memberEmail varchar(50) not null,
memberPassword varchar(30) not null,
memberName varchar(20) not null,
memberMobile varchar(20) not null,
fileAttached int default 0
);

-- 게시글 테이블
create table board_table_project(
id bigint primary key auto_increment unique,
boardTitle varchar(50) not null,
boardWriter varchar(20) not null,
boardContents varchar(500) not null,
boardHits int default 0,
boardCreatedDate datetime default now(),
memberId bigint,
constraint fk_board foreign key(memberId) references member_table_project(id) on delete cascade,
fileAttached int default 0
);

-- 게시글 파일 업데이트 테이블
create table board_file_table_project(
id bigint auto_increment primary key,
originalFileName varchar(100),
storedFileName varchar(100),
boardId bigint,
constraint fk_board_file_table foreign key(boardId) references board_table_project(id) on delete cascade
);

-- 댓글 테이블
create table comment_table_project(
id bigint primary key auto_increment,
commentWriter varchar(50) not null,
commentContents varchar(300) not null,
commentCreatedDate datetime default now(),
boardId bigint,
memberId bigint,
constraint fk_comment_board foreign key(boardId) references board_table_project(id) on delete cascade,
constraint fk_comment_board2 foreign key(memberId) references member_table_project(id) on delete cascade
);

-- 회원가입 파일 업데이트 테이블
create table member_file_table(
id bigint auto_increment primary key,
originalFileName varchar(100),
storedFileName varchar(100),
memberId bigint,
constraint fk_member_file_table foreign key(memberId) references member_table_project(id) on delete cascade
);
