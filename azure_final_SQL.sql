drop table stock;
drop table company;
CREATE TABLE company (
  code VARCHAR(50) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  turnover DECIMAL(30,5) NOT NULL,
  ceo VARCHAR(50) NOT NULL,
  website VARCHAR(50) NOT NULL,
  stock_exchange VARCHAR(50) NOT NULL,
  creat_dtm DATE
  ) ;

CREATE TABLE stock (
  id INT IDENTITY PRIMARY KEY,
  stock_price DECIMAL(30,5) NOT NULL,
  company_code VARCHAR(50) NOT NULL,
  creat_dtm DATE,
  FOREIGN KEY (company_code) REFERENCES company(code) ON DELETE CASCADE
) ;