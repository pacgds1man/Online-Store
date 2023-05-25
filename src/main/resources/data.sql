insert into Customer (firstname, lastname, age, country)
values ('john', 'doe', 31, 'USA'),
       ('Robert', 'Luna', 22, 'USA'),
       ('David', 'Robinson', 22, 'UK'),
       ('John', 'Reinhardt', 25, 'UK'),
       ('Batty', 'DOE', 28, 'UAE'),
       ('SELF_BOT', 'SELF_BOT', 1, 'UNKNOWN');

insert into Order_table (item, amount, customer_id)
values ('Keyboard', 400, 1),
       ('Monitor', 12500, 5),
       ('SSD', 2500, 4),
       ('SSD', 2044, null);
insert into Shipping (status , order_id)
values ('PENDING', 2),
       ('DELIVERED', 1),
       ('ASSEMBLY', 3)