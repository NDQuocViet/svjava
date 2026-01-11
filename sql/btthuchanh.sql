select CalcuateTax(15000000);
create table Persons(
ID int not null auto_increment,
LastName varchar(255) not null,
FirstName varchar(255),
Age int,
primary key(ID)
);

call procedure_person('add',NULL,'Thanh','Bui',6);
call procedure_person('update',3, 'Tuan','Nguyen',8);
call procedure_person('delete',2,null,null,null);


-- 02. cau lenh In: lấy ra tất cả sản phẩm thuộc loại LG hoặc Samsung
	select * from ecom.product
	inner join ecom.productType on product.typeId = productType.productTypeId
	where typeName in ('LG','Samsung');
    
-- 03. Lấy thông tin chi tiết của đơn hàng có mã: 99
select * 
from ecom.orders, ecom.orderDetail, ecom.customer , ecom.product
where 
	orders.id = orderDetail.orderId 
    and customer.customerId = orders.customerId 
    and product.id = orderDetail.productId  
    and orders.id =99;
    
-- 04. Lấy ra các sản phẩm có giá nhập vào < 6 tr và giá bán ra nằm trong khoảng 4tr đến 7 tr
select * from ecom.product
inner join ecom.orderDetail
on product.id = orderDetail.productId
where product.price <6000000 and orderDetail.price between 4000000 and 7000000
order by product.id;

-- 05. Lấy ra các sản phẩm có giá nhập vào < 6 tr và loi nhuan > 3 tr
select distinct t.id, t.proName
from (
    select p.id, p.proName,
           (od.price - p.price) * od.`number` as profit
    from ecom.product p
    join ecom.orderDetail od on p.id = od.productId
    where p.price < 6000000
) t
where t.profit > 3000000
order by t.id ;


-- 06. Lấy ra các sản phẩm cùng với tổng giá trị lợi nhuận nằm trong khoảng từ 1 tỷ đến 6 tỷ VNĐ
select p.id, p.proName, t.total_profit
from (
    select od.productId,
           sum((od.price - p.price) * od.`number`) as total_profit, p.proName
    from ecom.orderDetail od
    join ecom.product p on p.id = od.productId
    group by od.productId
) t
join ecom.product p on p.id = t.productId
where t.total_profit between 1000000000 and 6000000000;

select od.productId,
	   sum((od.price - p.price) * od.`number`) as total_profit, p.proName
from ecom.orderDetail od
join ecom.product p on p.id = od.productId
group by od.productId
order by od.productId;

-- thủ thuật  giảm  recod
select pro.id,pro.typeId,pro.proName,pro.description,
concat(FORMAT(pro.price,0),'vnd') as 'gia nhap vao',
concat(FORMAT(loiNhuan.total,0),'vnd') as 'lợi nhuận'
from
(select p.id, sum(abs(od.price - p.price)*od.number) as total
from product p, orderDetail od
where
	p.id =od.productId
group by p.id
) as loiNhuan,product pro
where
	pro.id = loiNhuan.id and
    pro.price<6000000 and
    loiNhuan.total between 1000000000 and 6000000000
order by 'lợi nhuận' desc,pro.id,pro.price;

-- 07. lấy các sản phẩm có giá nhập vào nhỏ hơn 600 và giá bán ra nằm trong khoảng [700, 1100] sắp xếp kết quả truy vấn theo giá nhập vào, nếu giá nhập vào bằng nhau thì sắp sếp theo giá bán ra.

select distinct p.id, p.proName, p.price as import_price, od.price as sell_price
from ecom.product p
join ecom.orderDetail od on p.id = od.productId
where p.price < 600000
  and od.price between 70000 and 1100000
order by p.price asc, od.price asc;

-- 08. Lấy ra các đơn hàng đc giao cho khách hàng trong tháng 1 - 2022
select * from orders where deliveriedDate >= '2022-01-01'
  and deliveriedDate <  '2022-02-01';
  
-- 09. Lấy chi tiết tất cả các đơn hàng sắp xếp theo trạng thái đơn hàng, ngày đặt hàng, ngày yêu cầu giao hàng, ngày nhận hàng.

select *
from orders o
inner join orderDetail od on o.id = od.orderId
ORDER BY 
o.createdDate DESC,
o.deliveriedDate DESC;


-- 10. tính tổng tiền mỗi đơn hàng
select * 
from 
	orders o ,
	(
		select od.orderId, sum(od.`number` * od.price) as tongtiendonhang
		from orderDetail od
		group by od.orderId
	) as odd
where o.id=odd.orderId;
    
-- 11. Mã hoá password sử dụng sha: 
--		INSERT INTO table_name VALUES (data), (data), (data);
insert into customer (fullName, address, phone, userName, password) 
values ('nguyen van 09800000016', 'ha noi 2', '09800000016', 'nvsu16', sha2('Ab@123456', 256)), 
	('nguyen van 09800000017', 'ha noi 2', '09800000017', 'nvsu17', sha2('Ab@123456', 256)), 
    ('nguyen van 09800000018', 'ha noi 2', '09800000018', 'nvsu18', sha2('Ab@123456', 256));
    
select * from customer where fullName like '%098000%';
select * from customer where userName = 'nvsu16' and password = sha2('Ab@123456', 256);
    
    