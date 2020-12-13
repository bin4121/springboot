package com.example.demo.entity;


public class FieldEntity {
    // 字段名
    private String fieldName;

    // 字段类型
    private String type;

    // 字段长度
    private int length;

    // 是否为空
    private int nullable;

    // 是否为主键
    private int is_primary;

    // 是否为分区字段
    private int is_partition_field;

    // 安全级别
    private String security_level;

    // 默认值
    private String default_value;

    // 值域
    private String value_domain;

    // 注释
    private String desc;

    // 无参构造
    public FieldEntity(){
        security_level = "C1";
    }
//    // 有参构造
//    public FieldEntity(String fieldName, String type, int length, int nullable, int is_primary,
//                       int is_partition_field, String security_level,
//                       String default_value, String value_domain, String desc) {
//        this.fieldName = fieldName;
//        this.type = type;
//        this.length = length;
//        this.nullable = nullable;
//        this.is_primary = is_primary;
//        this.is_partition_field = is_partition_field;
//        this.security_level = security_level;
//        this.default_value = default_value;
//        this.value_domain = value_domain;
//        this.desc = desc;
//    }

//    @Override
//    public String toString() {
//        return "FieldEntity{" +
//                "fieldName='" + fieldName + '\'' +
//                ", type='" + type + '\'' +
//                ", length=" + length +
//                ", nullable=" + nullable +
//                ", is_primary=" + is_primary +
//                ", is_partition_field=" + is_partition_field +
//                ", security_level='" + security_level + '\'' +
//                ", default_value='" + default_value + '\'' +
//                ", value_domain='" + value_domain + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNullable() {
        return nullable;
    }

    public void setNullable(int nullable) {
        this.nullable = nullable;
    }

    public int getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(int is_primary) {
        this.is_primary = is_primary;
    }

    public int getIs_partition_field() {
        return is_partition_field;
    }

    public void setIs_partition_field(int is_partition_field) {
        this.is_partition_field = is_partition_field;
    }

    public String getSecurity_level() {
        return security_level;
    }

    public void setSecurity_level(String security_level) {
        this.security_level = security_level;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }

    public String getValue_domain() {
        return value_domain;
    }

    public void setValue_domain(String value_domain) {
        this.value_domain = value_domain;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

