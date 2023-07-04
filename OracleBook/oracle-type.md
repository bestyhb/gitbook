urowid,rowid,bfile,nclob,clob,blob,interval day to second,interval year to month,timestamp with local time zone,timestamp with time zone,timestamp,date, long raw,long,binary_double,binary_float,number,raw,nvarchar2,varchar2,nchar,

# 什么是定长字符串和变长字符串，两者有什么区别？
Oracle中，定长字符串和变长字符串都用于存储字符串类型的数据。
定长字符串使用CHAR定义，表示固定长度的字符串数据类型，长度为2000字节。
变长字符串使用VARCHAR2定义，表示可变长度的字符串数据类型，最大长度为4000字节。
> 注：Oracle 12c版本后，VARCHAR2最大长度为32767字节。

# 为什么说CHAR类型的字符串的长度是固定的？
当数据类型为CHAR时，而存入的字符串数据的内容长度不够是，Oracle将在数据内容后面自动填充空格，以补全数据，所以CHAR的长度总是固定的。

# 当输入的数据长度大于或小于字符串定义长度时的表现是什么？

# 为什么说CHAR比VARCHAR效率高？

# 什么时候使用变长字符串，什么时候使用定长字符串？
字段长度固定不变，例如性别、手机号码、身份证号码等数据，使用定长字符串类型存储，即Oracle CHAR；字段长度不确定，例如姓名、学历、地址、URL等数据，使用变长字符串类型进行存储，即Oracle VARCHAR2。

# Oracle变长字符串类型为何不是varchar1，而是varchar2？
varchar1（实际为varchar）为标准SQL里定义的数据类型，varchar2是Oracle独有的一种数据类型。
varchar定义固定长度的字符串，varchar2定义可变长度字符串。
varchar定义字符串存储长度为2000，varchar2定义存储长度为4000。
对于字符编码而言，varchar定义中，1个中文字符占用2字节，1个英文字符占用1个字节；varchar2定义，1个中文或英文字符皆占用2字节。
对于空串处理上，varchar不处理空串，即输入空串存储空串，而varchar2输入空串则代表null。

# 什么时候使用VARCHAR，什么时候使用VARCHAR2？
MySQL最好使用varchar类型，Oracle则使用varchar2。

# varchar2输入空串后，在存储之前就转化为null进行存储，还是说直接存入null？

# 为什么说Oracle比Java的数字类型更精准？Number类型的具体精度为多少？
Oracle中 Number和Java long,int,double类型都用于存放数字，
Oracle Number精度为38位
Java long 精度 20位
Java int 精度
Java short 精度
Java dobule 精度
Java float 精度
所以说Oracle Number类型比Java数字类型更精准。

# Oracle定点数和浮点数的精度如何定义？输入的长度超过定义精度会如何表现？
NUMBER(m,n) m表示总长度 n表示小数位的精度。
如果存入的小数位精度超过n，则四舍五入后取值。
例如NUMBER(10,3)，数值总长度为10，小数点后位数位3。
如果输入123.4567，实机数值为123.457。
如果输入123456789.321，总长度超过10，Oracle将提示错误。
如果只输入定点数，使用NUMBER(m)，m表示可以存入数据的最大位数。