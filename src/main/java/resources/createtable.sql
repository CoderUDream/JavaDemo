CREATE TABLE account11(
	accountid INT NOT NULL AUTO_INCREMENT,
	name char(20) NOT NULL,
	money INT NOT NULL,
	stockcount INT DEFAULT 0,
	PRIMARY KEY (accountid),
	UNIQUE unique_index_name(name),
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE stock22(
	stockid INT NOT NULL AUTO_INCREMENT,
	name char(20) NOT NULL,
	count INT NOT NULL,
	PRIMARY KEY (stockid),
	UNIQUE KEY unique_index_name(name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
