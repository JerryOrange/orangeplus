drop table quartz_cron_config if exists;
create table quartz_cron_config(
    id int generated by default as identity,
    cron nvarchar(40),  
    primary key(id)  
);  