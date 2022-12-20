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
	message_id uniqueidentifier NOT NULL,
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
