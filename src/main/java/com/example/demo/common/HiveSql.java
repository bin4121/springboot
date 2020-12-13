package com.example.demo.common;


public class HiveSql {
    public static final String hql = "CREATE TABLE `test.ai_map_baidu_poi_keyword`(        \n" +
            "   id string COMMENT 'poiID',                      \n" +
            "   name string COMMENT 'poi名称',                   \n" +
            "   longitude double COMMENT 'poi经度',              \n" +
            "   latitude double COMMENT 'poi纬度',               \n" +
            "   province string COMMENT 'poi所属省份',             \n" +
            "   city string COMMENT 'poi所属城市',                 \n" +
            "   area string COMMENT 'poi所属区县',                 \n" +
            "   address string COMMENT 'poi地址信息',              \n" +
            "   adcode string COMMENT 'poi行政区划代码',             \n" +
            "   telephone string COMMENT 'poi电话信息',            \n" +
            "   street_id string COMMENT 'poi街景图id',           \n" +
            "   detail int COMMENT 'poi是否有详情页：1有，0没有',         \n" +
            "   tag string COMMENT 'poi标签',                    \n" +
            "   type string COMMENT 'poi所属分类',                 \n" +
            "   children string COMMENT 'poi子点数据',             \n" +
            "   detailinfo string COMMENT 'poi的详细信息',          \n" +
            "   url string COMMENT '抓取POI的URL，URL内含详细参数',      \n" +
            "   `time` string COMMENT '抓取POI时调用搜索接口的时间')         \n" +
            " PARTITIONED BY (                                   \n" +
            "   dt string COMMENT '日期')                        \n" +
            " ROW FORMAT SERDE                                   \n" +
            "   'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'  \n" +
            " WITH SERDEPROPERTIES (                             \n" +
            "   'field.delim'='\\t',                              \n" +
            "   'serialization.format'='\\t')                     \n" +
            " STORED AS INPUTFORMAT                              \n" +
            "   'org.apache.hadoop.mapred.TextInputFormat'       \n" +
            " OUTPUTFORMAT                                       \n" +
            "   'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat' \n" +
            " LOCATION                                           \n" +
            "   'obs://bigdatahll/warehouse/tablespace/hive/lbs.db/ai_map_baidu_poi_keyword' \n" +
            " TBLPROPERTIES (                                    \n" +
            "   'bucketing_version'='2',                         \n" +
            "   'transient_lastDdlTime'='1606804299')";

    public static final String hql1 = "CREATE EXTERNAL TABLE `temp.ai_map_baidu_poi_keyword`( \n" +
            "  `id` string COMMENT 'poiID',                     \n" +
            "  `name` string COMMENT 'poi名称',             \n" +
            "  `longitude` double COMMENT 'poi经度',        \n" +
            "  `latitude` double COMMENT 'poi纬度',         \n" +
            "   `province` string COMMENT 'poi所属省份',            \n" +
            "   `city` string COMMENT 'poi所属城市',                \n" +
            "   `area` string COMMENT 'poi所属区县',                \n" +
            "   `address` string COMMENT 'poi地址信息',             \n" +
            "   `adcode` string COMMENT 'poi行政区划代码',          \n" +
            "   `telephone` string COMMENT 'poi电话信息',           \n" +
            "   `street_id` string COMMENT 'poi街景图id',        \n" +
            "   `detail` int COMMENT 'poi是否有详情页：1有，0没有',   \n" +
            "   `tag` string COMMENT 'poi标签',                   \n" +
            "   `type` string COMMENT 'poi所属分类',                 \n" +
            "   `children` string COMMENT 'poi子点数据',             \n" +
            "   `detailinfo` string COMMENT 'poi的详细信息',         \n" +
            "   `url` string COMMENT '抓取POI的URL，URL内含详细参数', \n" +
            "   `time` string COMMENT '抓取POI时调用搜索接口的时间')  \n" +
            " PARTITIONED BY (                                   \n" +
            "   `dt` string COMMENT '日期',                      \n" +
            "   `p2` string COMMENT '分区2')                       \n"+
            " ROW FORMAT SERDE                                   \n" +
            "   'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n" +
            " WITH SERDEPROPERTIES (                             \n" +
            "   'field.delim'='\\t',                              \n" +
            "   'serialization.format'='\\t')                     \n" +
            " STORED AS INPUTFORMAT                              \n" +
            "   'org.apache.hadoop.mapred.TextInputFormat'       \n" +
            " OUTPUTFORMAT                                       \n" +
            "   'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'\n" +
            " LOCATION                                           \n" +
            "   'hdfs://hwyclusterns1/user/joker.sun/bmap_poi/spider_poi/keyword' \n" +
            " TBLPROPERTIES (                                    \n" +
            "   'bucketing_version'='2',                         \n" +
            "   'spark.sql.create.version'='2.3.2.3.1.4.0-315',  \n" +
            "   'spark.sql.sources.schema.numPartCols'='1',      \n" +
            "   'spark.sql.sources.schema.numParts'='1',         \n" +
            "   'spark.sql.sources.schema.part.0'='{\"type\":\"struct\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poiID\"}},{\"name\":\"name\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi名称\"}},{\"name\":\"longitude\",\"type\":\"double\",\"nullable\":true,\"metadata\":{\"comment\":\"poi经度\"}},{\"name\":\"latitude\",\"type\":\"double\",\"nullable\":true,\"metadata\":{\"comment\":\"poi纬度\"}},{\"name\":\"province\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi所属省份\"}},{\"name\":\"city\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi所属城市\"}},{\"name\":\"area\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi所属区县\"}},{\"name\":\"address\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi地址信息\"}},{\"name\":\"adcode\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi行政区划代码\"}},{\"name\":\"telephone\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi电话信息\"}},{\"name\":\"street_id\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi街景图id\"}},{\"name\":\"detail\",\"type\":\"integer\",\"nullable\":true,\"metadata\":{\"comment\":\"poi是否有详情页：1有，0没有\"}},{\"name\":\"tag\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi标签\"}},{\"name\":\"type\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi所属分类\"}},{\"name\":\"children\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi子点数据\"}},{\"name\":\"detailInfo\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"poi的详细信息\"}},{\"name\":\"url\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"抓取POI的URL，URL内含详细参数\"}},{\"name\":\"time\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"抓取POI时调用搜索接口的时间\"}},{\"name\":\"dt\",\"type\":\"string\",\"nullable\":true,\"metadata\":{\"comment\":\"日期\"}}]}',  \n" +
            "   'spark.sql.sources.schema.partCol.0'='dt',       \n" +
            "   'transient_lastDdlTime'='1606617154')";

    public static final String sql = "CREATE TABLE complex(\n" +
            "   iol1 TINYINT,\n" +
            "   iol2 SMALLINT,\n" +
            "   iol3 INT,\n" +
            "   iol4 BIGINT,\n" +
            "   bol1 BOOLEAN,\n" +
            "   fol1 FLOAT,\n" +
            "   fol2 DOUBLE,\n" +
            "   sol1 String,\n" +
            "   col1 ARRAY< INT>,\n" +
            "   col2 MAP< STRING,INT>,\n" +
            "   col3 STRUCT< a:STRING,b:INT,c:DOUBLE>\n" +
            ")";

    public static final String parquet = "CREATE TABLE parquet_test (\n" +
            " id int,\n" +
            " str string,\n" +
            " mp MAP<STRING,STRING>,\n" +
            " lst ARRAY<STRING>,\n" +
            " strct STRUCT<A:STRING,B:STRING>) \n" +
            " PARTITIONED BY (part string)\n" +
            " STORED AS PARQUET";

    // 修改表
    public static final String alterAdd = " ALTER TABLE test.test_change ADD COLUMNS (a INT COMMENT 'ADD new collumn'," +
            "b string COMMENT '新字段')";

    public static final String alterComment = "alter table detail_flow_conversion_base_raw change column original_union_id original_union_id string comment '原始设备唯一性标识'";

    public static final String alterCommentAndCol = "ALTER TABLE test.comment_table_test \n" +
            "CHANGE COLUMN newid id STRING COMMENT 'ididid'";
}

