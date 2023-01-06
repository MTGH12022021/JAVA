create database ChatApplication
drop database ChatApplication

use ChatApplication
go
create table Admin(
	admin_id varchar(255) NOT NULL DEFAULT newid() unique,
	admin_name nvarchar(50),
	email nvarchar(50) unique,
	password nvarchar(50),
	state int,
	establish date,
	constraint PK_Admin primary key (admin_id),
);

create table Users (
	user_id varchar(255) NOT NULL DEFAULT newid() unique,
	user_name nvarchar(50),
	email nvarchar(50) unique,
	password nvarchar(50),
	state int,
	establish date,
	constraint PK_USER primary key (user_id),
);

create table ChatHistory(
	user_id varchar(255) NOT NULL,
	times datetime,
	constraint PK_ChatHistory primary key (user_id, times),
);


create table Friends(
	user_id varchar(255) NOT NULL ,
	friend_id varchar(255) not null,
	constraint PK_Friend primary key (user_id, friend_id),
);

create table MessagesFriend(
	user_id varchar(255) NOT NULL,
	message_id varchar(255) NOT NULL DEFAULT newid() unique,
	message_content nvarchar(200),
	validate int,
	times time,
	constraint PK_MessagesFriend primary key (message_id),
);

create table MessagesGroup(
	user_id varchar(255) NOT NULL,
	group_id varchar(255) NOT NULL,
	message_id varchar(255) NOT NULL DEFAULT newid() unique,
	message_content nvarchar(200),
	validate int,
	times time,
	constraint PK_MessagesGroup primary key (message_id),
);

create table Groups(
	name nvarchar(50),
	group_id varchar(255) NOT NULL DEFAULT newid() unique,
	constraint PK_Groups primary key (group_id),
)

create table AdminGroup(
	group_id varchar(255) NOT NULL,
	admin_id varchar(255) NOT NULL,
	constraint PK_AdminGroup primary key (group_id, admin_id),
)

create table MemberGroup(
	user_id varchar(255) NOT NULL ,
	group_id varchar(255) NOT NULL,
	constraint PK_MemberGroup primary key (user_id, group_id),
);

--ChatHistory

alter table ChatHistory
add constraint FK_ChatHistory_Users
foreign key (user_id)
references Users(user_id)

--Friends

alter table Friends
add constraint FK_Friends_user_Users
foreign key (user_id)
references Users(user_id)

alter table Friends
add constraint FK_Friends_friend_Users
foreign key (friend_id)
references Users(user_id)

--MessagesFriend

alter table MessagesFriend
add constraint FK_MessagesFriend_Users
foreign key (user_id)
references Users(user_id)

--MessagesGroup

alter table MessagesGroup
add constraint FK_MessagesGroup_Users
foreign key (user_id)
references Users(user_id)

alter table MessagesGroup
add constraint FK_MessagesGroup_Groups
foreign key (group_id)
references Groups(group_id)

--MemberGroup
alter table MemberGroup
add constraint FK_MemberGroup_Users
foreign key (user_id)
references Users(user_id)

alter table MemberGroup
add constraint FK_MemberGroup_Groups
foreign key (group_id)
references Groups(group_id)


insert into Users (user_id,user_name,email,password,state,establish) values ('541CAE5A-09B2-4324-83DC-33D83534BDDD', 'volehoai2222',	'volehoai070902@gmail.com'	,'bbe79b3beefe462a8859639fff6872aa',	0	,'2022-11-30')
insert into Users (user_id,user_name,email,password,state,establish) values ('92A2CB96-3551-4D15-BF29-C286CDDB4B3A', 'nguyenquangtien',	'nguyenquangtien@gmail.com'	,'202cb962ac59075b964b07152d234b70',	0	,'2022-11-30')
insert into Users (user_id,user_name,email,password,state,establish) values ('D5C6ECE3-29B9-4D9A-ADD0-073942C38FE0', 'duy',	'phamducduy@gmail.com'	,'bbe79b3beefe462a8859639fff6872aa',	0	,'2022-11-30')
insert into Users (user_id,user_name,email,password,state,establish) values ('F51067AF-F27D-4A9F-8623-83F8135C19A3', 'khoiyeuthuy',	'nguyenvukhoi@gmail.com'	,'1de3f1191cf4d8b9f05888accefc88b2',	0	,'2022-11-30')

insert into Friends (user_id,friend_id) values ('92A2CB96-3551-4D15-BF29-C286CDDB4B3A', '541CAE5A-09B2-4324-83DC-33D83534BDDD')
insert into Friends (user_id,friend_id) values ('541CAE5A-09B2-4324-83DC-33D83534BDDD', '92A2CB96-3551-4D15-BF29-C286CDDB4B3A')

insert into Friends (user_id,friend_id) values ('92A2CB96-3551-4D15-BF29-C286CDDB4B3A', 'D5C6ECE3-29B9-4D9A-ADD0-073942C38FE0')
insert into Friends (user_id,friend_id) values ('D5C6ECE3-29B9-4D9A-ADD0-073942C38FE0', '92A2CB96-3551-4D15-BF29-C286CDDB4B3A')

insert into Groups(name, group_id) values ('KHTN', NEWID());

insert into MemberGroup(user_id, group_id) values('541CAE5A-09B2-4324-83DC-33D83534BDDD','3F5C40E0-0AF4-40BD-9374-1B5494082FE2')
insert into MemberGroup(user_id, group_id) values('D5C6ECE3-29B9-4D9A-ADD0-073942C38FE0','3F5C40E0-0AF4-40BD-9374-1B5494082FE2')
insert into MemberGroup(user_id, group_id) values('F51067AF-F27D-4A9F-8623-83F8135C19A3','3F5C40E0-0AF4-40BD-9374-1B5494082FE2')