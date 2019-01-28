
create database if not exists REGHOURS;
use REGHOURS;

create table if not exists `USER` (
	`userId` int not null auto_increment primary key,
	`username` varchar(32) not null,
    `firstname` varchar(48) not null,
    `lastname` varchar(90) not null, 
    `passwd` varchar(64) not null #sha256 encoded password
);

create table if not exists `TIMERECORD` (
	`idRecord` int not null primary key,
    `record` datetime not null,
    `type` varchar(1) not null,
    # Only possible value  is Entry (E) or Exit (X)
    `user` int not null,
    foreign key(`user`) references `USER`(`userId`)
);

# passwd: Benjamin995# 
# --> SHA256: 93A4BEAD3D527E99BC4271330142B2243EC0033BAB74F2F7F94EDDA5FD84659B
insert into `USER`(`username`, `firstname`, `lastname`, `passwd`)
values('benji', 'Benjamin Adam', 'Nagy', 
	   '93A4BEAD3D527E99BC4271330142B2243EC0033BAB74F2F7F94EDDA5FD84659B');

# passwd: Visigodo69@ 
# --> SHA256: 4B9B1F4BCA3511922128ADC3A5E9509CD24406E0D80D2CF4CCABA8DFACDE9723
insert into `USER`(`username`, `firstname`, `lastname`, `passwd`)
values('visigodo', 'Visigodo', 'de Hispania',
	   '4B9B1F4BCA3511922128ADC3A5E9509CD24406E0D80D2CF4CCABA8DFACDE9723');
       
create user if not exists 'reghours'@'localhost' 
identified by 'reghourspasswd';

grant select, insert, update, delete
	on REGHOURS.*
    to 'reghours'@'localhost';
       

