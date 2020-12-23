
DROP TABLE IF EXISTS  address_list;

CREATE TABLE  address_list (
  id int auto_increment,
  name varchar(20) COMMENT "姓名",
  telephone varchar(20)  COMMENT "联系方式",
  address varchar(50)  COMMENT "联系地址",
  sex int(1) COMMENT "性别",
  mark varchar(255)  COMMENT "备注",
  company varchar(50)  COMMENT "所属公司",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





DROP TABLE IF EXISTS  borrow_record;

CREATE TABLE borrow_record (
  id int auto_increment,
  part_name varchar(20) COMMENT "零部件名称",
  part_specification varchar(50)  COMMENT "规格",
  category varchar(20)  COMMENT "所属类别",
  figure_number varchar(50)  COMMENT "图号",
  number int  COMMENT "数量",
  material  varchar(20)  COMMENT "材料",
  borrow_name varchar(20)  COMMENT "借用人",
  borrow_time datetime  COMMENT "借用时间",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  supplier varchar(50) COMMENT "所属部门或者客户公司名称",
  mark varchar(255)  COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS  delivery_record;


CREATE TABLE delivery_record (
  id int auto_increment,
  part_name varchar(20)  COMMENT "零部件名称",
  part_specification varchar(50)  COMMENT "规格",
  category varchar(20)  COMMENT "所属类别",
  figure_number varchar(50)  COMMENT "图号",
  number bigint(8)  COMMENT "发货数量",
  delivery_name varchar(20)  COMMENT "发货人",
  delivery_address varchar(50)  COMMENT "发货地址",
  delivery_time datetime  COMMENT "发货时间",
  borrow_name varchar(20)  COMMENT "收货人姓名",
  telephone varchar(28)  COMMENT "收货地址",
  supplier varchar(50)  COMMENT "收货供应商",
  borrow_address varchar(50)  COMMENT "收获供地址",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  mark varchar(255) DEFAULT NULL COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS  in_record;

CREATE TABLE in_record (
  id int AUTO_INCREMENT,
  part_name varchar(50) COMMENT "零部件名称",
  part_specification varchar(50)  COMMENT "规格",
  figure_number varchar(50)  COMMENT "图号",
  material  varchar(20)  COMMENT "材料",
  supplier varchar(50)  COMMENT "供货商",
  category varchar(20)  COMMENT "所属类别",
  quantity int  COMMENT "入库数量",
  location varchar(20)  COMMENT "库位",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  mark varchar(255)  COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS  non_conforming;

CREATE TABLE non_conforming (
  id INT AUTO_INCREMENT,
  part_name varchar(50) COMMENT "零部件名称",
  category varchar(20)  COMMENT "所属类别",
  part_specification varchar(50)  COMMENT "规格",
  material  varchar(20)  COMMENT "材料",
  figure_number varchar(50)  COMMENT "图号",
  quantity bigint(8)  COMMENT "入库数量",
  location varchar(50) COMMENT  "库位",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  mark varchar(255)  COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS out_record;

CREATE TABLE out_record (
  id int AUTO_INCREMENT,
  part_name varchar(50)  COMMENT "零部件名称",
  category varchar(20)  COMMENT "所属类别",
  part_specification varchar(50)  COMMENT "规格",
  figure_number varchar(50)  COMMENT "图号",
  material  varchar(20)  COMMENT "材料",
  number int unsigned zerofill  COMMENT "领用数量",
  receive_name varchar(20)  COMMENT "领用人",
  receive_time datetime  COMMENT "领用时间",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  supplier varchar(50)  COMMENT "供货商",
  mark varchar(255)  COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS storage_table;

CREATE TABLE storage_table (
  id int AUTO_INCREMENT,
  part_name varchar(50)  COMMENT "零部件名称",
  category varchar(20)  COMMENT "类别",
  part_specification varchar(50) COMMENT "规格",
  material  varchar(20)  COMMENT "材料",
  figure_number varchar(50)  COMMENT "图号",
  number int unsigned zerofill  COMMENT "数量",
  supplier varchar(50)  COMMENT "供货商",
  location varchar(20)  COMMENT "库位",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  mark varchar(255)  COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS user_table;

CREATE TABLE user_table (
  id int AUTO_INCREMENT,
  username varchar(20)  COMMENT "用户名",
  password varchar(45)  COMMENT "密码",
  role varchar(20)  COMMENT "角色",
  authority varchar(40)  COMMENT "权限",
  created_name varchar(20)  COMMENT "创建人",
  created_time date  COMMENT "创建时间",
  updated_name varchar(20) COMMENT "更新人",
  update_time date  COMMENT "更新时间",
  mark varchar(255) COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS category_table;

CREATE TABLE category_table (
  id int AUTO_INCREMENT,
  name varchar(20)  COMMENT "用户名",
  created_time datetime COMMENT "创建时间",
  created_name varchar(20) COMMENT "创建人",
  updated_time datetime  COMMENT "更新时间",
  updated_name varchar(20) COMMENT "跟新人",
  mark varchar(255) COMMENT "备注",
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


