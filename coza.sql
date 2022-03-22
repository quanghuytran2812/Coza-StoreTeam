create table [User](
	uid int identity primary key,
	uemail varchar(50),
	usname varchar(50) unique not null,
	upassword varchar(36) not null,
	uavatar varchar(50),
	urole bit
)

create table Category(
	cid int identity primary key,
	cname nvarchar(255) not null,
	csession varchar(255) not null,
	cimg varchar(255) not null
)

create table Product(
	pid int identity primary key,
	pname nvarchar(255) not null,
	pprice decimal(19, 2) not null,	
	pdiscount int not null,
	pisNew bit not null,
	cid int references Category(cid) not null,
	pdes nvarchar(2000),
	pimg varchar(50)
)

create table ProductDetail(
	did int identity primary key,
	pid int not null references Product(pid),
	pfimage varchar(250),
	pbimage varchar(250),
	pcimage varchar(250),
	pcreated date not null,
	pSKU varchar(250),
	psize varchar(255) not null,
	pcolor varchar(255) not null,
	pweight decimal(19, 2) not null,
	pdismention varchar(250) not null,
	pmaterial varchar(250) not null,
	pdeslong varchar(500) not null
)

create table Cart(
	kid varchar(50) primary key,
	uid int references [User](uid) not null ,
	kbuyDate date
)

create table CartItem(
	iid varchar(50) primary key,
	iquantity int,
	iunitPrice decimal(19,2),
	pid int references Product(pid) not null,
	kid varchar(50) references Cart(kid) not null
)

create table Verify(
vid int identity primary key,
uid int not null references [User](uid),
vcode varchar(200)
)

-------------------------------------------------------------------------------------------------------------

select * from [User]
select * from Category
select * from Product
select * from ProductDetail
select * from Cart
select * from CartItem

-------------------------------------------------------------------------------------------------------------

insert into [User] values('tuananh@gmail.com', 'tuananh57', '123', 'default.png', 1)
insert into [User] values('nhungoc@gmail.com', 'nhungoc57', '123', 'default.png', 0)
insert into [User] values('nhungoc@gmail.com', 'nhungoc57z', '123', 'default.png', 0)


insert into Category values('Women', 'Spring 2022', 'banner-04.jpg')
insert into Category values('Men', 'Spring 2022', 'banner-05.jpg')
insert into Category values('Watches', 'Spring 2022', 'banner-07.jpg')
insert into Category values('Bags', 'Spring 2022', 'banner-08.jpg')
insert into Category values('Accessories', 'Spring 2022', 'banner-09.jpg')


insert into Product values('Esprit Ruffle Shirt', '16.64', 10, 1, 2, 'This is the good T-Shirt', 'product-01.jpg')
insert into Product values('Herschel supply', '35.31', 0, 0, 2, 'This is the good Product', 'product-02.jpg')
insert into Product values('Only Check Trouser', '25.50', 20, 1, 1, 'This is the good Trouser', 'product-03.jpg')
insert into Product values('Herschel supply', '63.16', 0, 0, 1, 'This is the good Herscle', 'product-11.jpg')
insert into Product values('Mini Silver Mesh Watch', '86.85', 15, 1, 3, 'This is the good Watches', 'product-15.jpg')
insert into Product values('Vintage Inspired Classic', '93.20', 0, 0, 3, 'This is the good Watches', 'product-06.jpg')
insert into Product values('Herschel Belt', '16.64', 30, 1, 5, 'This is the good Belt', 'product-12.jpg')


insert into ProductDetail values('1', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-01', 'S, M, L, XL', 'White, Black', '0.79', '110x33x100','60% cotton', 'A T-shirt, or tee shirt, is a style of fabric shirt named after the T shape of its body and sleeves. Traditionally, it has short sleeves and a round neckline, known as a crew neck, which lacks a collar. T-shirts are generally made of a stretchy, light, and inexpensive fabric and are easy to clean.')
insert into ProductDetail values('2', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-02', 'S, M, L, XL', 'White, Black', '0.79', '110x33x100','30% cotton, 30% synthetic fiber','A shirt is a cloth garment for the upper body (from the neck to the waist). Originally an undergarment worn exclusively by men, it has become, in American English, a catch-all term for a broad variety of upper-body garments and undergarments.')
insert into ProductDetail values('3', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-03', 'S, M, L, XL', 'White, Red, Black', '0.69', '125x31x98','100% Khaki', 'trousers, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.')
insert into ProductDetail values('4', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-03', 'S, M, L, XL', 'White, Yellow, Black', '0.69', '119x29x82','100% natural material', 'Herscle, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.')
insert into ProductDetail values('5', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-06', 'S, M, L, XL', 'White, Yellow, Black', '0.69', '119x29x82','100% natural material', 'Herscle, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.')
insert into ProductDetail values('6', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-05', 'S, M, L, XL', 'White, Yellow, Black', '0.69', '119x29x82','100% natural material', 'Herscle, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.')
insert into ProductDetail values('7', 'product-detail-01.jpg', 'product-detail-02.jpg', 'product-detail-03.jpg', '2022-03-11', 'JAK-04', 'S, M, L, XL', 'White, Yellow, Black', '0.69', '119x29x82','100% natural material', 'Herscle, also spelled trowsers, also called pants or slacks, an outer garment covering the lower half of the body from the waist to the ankles and divided into sections to cover each leg separately.')

-------------------------------------------------------------------------------------------------------------

select * from Category where cid = 1

select * from Product join Category on Product.cid = Category.cid

--------------------------------------------------------------------------------------------------------------

select * from [User] where uemail = 'tuananh@gmail.com'
select * from [User] where usname = 'tuananh57'

--------------------------------------------------------------------------------------------------------------

update [User] set uemail = 'asd@gmail.com' , usname = 'asd', upassword = '123', uavatar = 'default.png', urole = 0 WHERE uid = 4

--------------------------------------------------------------------------------------------------------------

select * from Product join Category on Product.cid = Category.cid join ProductDetail on Product.pid = ProductDetail.pid

select * from ProductDetail where pid = 5

select * from Product join Category on Product.cid = Category.cid join ProductDetail on Product.pid = ProductDetail.pid where Product.pid = 1

select * from Product join Category on Product.cid = Category.cid join ProductDetail on Product.pid = ProductDetail.pid where Category.cid = 3

--------------------------------------------------------------------------------------------------------------

insert into Cart values('1231233','1', 'GETDATE()')
delete Cart where kid = '123123'
insert into CartItem values('asd123', '12', '123', '1', '123123')
delete CartItem where iid = 'f7e8f375-5dc6-4e87-a475-334afbfb0512'
drop table CartItem

select * from Cart
select * from CartItem

select * from [User] where urole = 1

delete from [User] where uid = 7

delete from Category where cid = 6

insert into Category values('asd', 'Spring 2022', 'banner-09.jpg')

select * from Category

update Category set cname = 'zxc', csession = 'zzz', cimg = 'asd' where cid = 10

-----------------------------------------------------------------------------------------------------------------

update Product set pname = 'abc', pprice = '123', pdiscount = 50, pisNew = 1,cid = 2, pdes = 'This asd', pimg = 'default.png' where pid = 10

delete from Product where pid = 10

select * from Product join Category on Product.cid = Category.cid

select * from CartItem join Cart on CartItem.kid = Cart.kid

select * from Product, Category where Product.cid = Category.cid and Product.pname like '%h%'

------------------------------------------------------------------------------------------------------------------------

