package com.example.demo.web;

import com.example.demo.common.ResponseData;
import com.example.demo.entity.FieldEntity;
import com.example.demo.service.HiveParseTestV2;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.common.HiveSql.*;

@RestController
public class UserController {
    @PostMapping("getlandpage/{sql}")
    public ResponseData getSql(@RequestParam String sql) throws ParseException {
        ResponseData responseData = new ResponseData();

        List<FieldEntity> data = HiveParseTestV2.parseSql(sql);

        responseData.setData(data);

        return responseData;
    }
}
