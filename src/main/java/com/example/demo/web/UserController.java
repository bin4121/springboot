package com.example.demo.web;

import com.example.demo.service.HiveParseTestV2;
import org.apache.hadoop.hive.ql.parse.ParseException;

import static com.example.demo.common.HiveSql.*;

public class UserController {
    public static void main(String[] args) throws ParseException {
//        HiveParseTestV2.parseSql(hql);
        HiveParseTestV2.parseSql(alterAdd);
    }
}
