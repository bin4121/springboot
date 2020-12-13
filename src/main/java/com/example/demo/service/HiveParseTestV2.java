package com.example.demo.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.FieldEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.antlr.runtime.tree.Tree;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.springframework.stereotype.Service;

@Service
public class HiveParseTestV2 {

    public static List<FieldEntity> parseSql(String sql) throws ParseException {

        List<FieldEntity> list = new ArrayList<>();

        ParseDriver pd = new ParseDriver();
        // TODO
        // 这里如果sql中有异常的话会报错
        ASTNode ast = pd.parse(sql);

        // 1.获取操作类型及表名
        String operationType = ast.getChild(0).toString();
        int childCount = ast.getChild(0).getChild(0).getChildCount();
        String tableName = ast.getChild(0).getChild(0).getChild(childCount - 1).toString();

        System.out.println("tableName = " + tableName);

        // 2.判断
        if ("TOK_CREATETABLE".equals(operationType)) {
            System.out.println("*** 创建表 ***");
            list = createTableJavaBean(ast);
            for (FieldEntity fieldEntity : list) {
                System.out.println(fieldEntity);
            }

        } else if ("TOK_ALTERTABLE".equals(operationType)) {
            System.out.println("*** 修改表 ***");
            list = alterTableJavaBean(ast);
            for (FieldEntity entity : list) {
                System.out.println(entity);
            }
        } else {
            // TODO
            // 返回： 错误
            System.out.println("else");
        }

        return list;
    }

    /**
     * 创建表
     * @param ast
     * @return
     */
    public static ArrayList<FieldEntity> createTableJavaBean(ASTNode ast) {
        ArrayList<FieldEntity> list = new ArrayList<>();

        int tabColListIndex = -1;              // TOK_TABCOLLIST 在哪个子节点
        int tablePartColsIndex = -1;           // TOK_TABLEPARTCOLS 在哪个子节点

        // 获取各个节点信息
        for (int i = 0; i < ast.getChild(0).getChildCount(); i++) {
            if ("TOK_TABCOLLIST".equals(ast.getChild(0).getChild(i).toString())) {
                tabColListIndex = i;
            }

            if ("TOK_TABLEPARTCOLS".equals(ast.getChild(0).getChild(i).toString())) {
                tablePartColsIndex = i;
            }
        }

        // 获取字段信息 (TOK_TABCOLLIST)
        if (tabColListIndex != -1) {
            FieldEntity filedEntity;
            for (int i = 0; i < ast.getChild(0).getChild(tabColListIndex).getChildCount(); i++) {
                filedEntity = new FieldEntity();

                Tree child = ast.getChild(0).getChild(tabColListIndex).getChild(i);
                int childCount = child.getChildCount();
                filedEntity.setFieldName(child.getChild(0).toString());
                String str = child.getChild(1).toString();
                if(str.startsWith("TOK_")){
                    filedEntity.setType(str.substring(4));
                }
                if (childCount == 3) {
                    filedEntity.setDesc(child.getChild(2).toString());
                }
                list.add(filedEntity);
            }
        }

        // 获取分区信息(TOK_TABLEPARTCOLS)：
        if (tablePartColsIndex != -1) {
            FieldEntity filedEntity;
            for (int i = 0; i < ast.getChild(0).getChild(tablePartColsIndex).getChildCount(); i++) {
                filedEntity = new FieldEntity();
                Tree child = ast.getChild(0).getChild(tablePartColsIndex).getChild(i);
                int childCount = child.getChildCount();
                filedEntity.setFieldName(child.getChild(0).toString());
                String str = child.getChild(1).toString();
                if(str.startsWith("TOK_")){
                    filedEntity.setType(str.substring(4));
                }
                if (childCount == 3) {
                    filedEntity.setDesc(child.getChild(2).toString());
                }
                filedEntity.setIs_partition_field(1);
                list.add(filedEntity);
            }
        }
        return list;
    }

    /**
     * 修改表(增加字段 或 修改字段comment)
     * @param ast
     * @return
     */
    public static List<FieldEntity> alterTableJavaBean(ASTNode ast) {
        List<FieldEntity> list = new ArrayList<>();

        int alterTableAddColsIndex = -1;                 // TOK_ALTERTABLE_ADDCOLS (增加字段操作)
        int tabColListIndex = -1;                        // TOK_TABCOLLIST （增加的字段）
        int alterTableRenameColIndex = -1;               // TOK_ALTERTABLE_RENAMECOL (修改字段的comment)


        // 获取节点的index
        for (int i = 0; i < ast.getChild(0).getChildCount(); i++) {
            if ("TOK_ALTERTABLE_ADDCOLS".equals(ast.getChild(0).getChild(i).toString())) {
                alterTableAddColsIndex = i;
            }

            if ("TOK_ALTERTABLE_RENAMECOL".equals(ast.getChild(0).getChild(i).toString())) {
                alterTableRenameColIndex = i;
            }
        }

        // 新增字段
        if (alterTableAddColsIndex != -1) {
            System.out.println("--- 新增字段 ---");
            for (int i = 0; i < ast.getChild(0).getChild(alterTableAddColsIndex).getChildCount(); i++) {
                if ("TOK_TABCOLLIST".equals(ast.getChild(0).getChild(alterTableAddColsIndex).getChild(i).toString())) {
                    tabColListIndex = i;
                }
            }
            Tree child = ast.getChild(0).getChild(alterTableAddColsIndex).getChild(tabColListIndex);
            // 字段解析
            if (alterTableAddColsIndex != -1) {
                FieldEntity filedEntity;
                for (int i = 0; i < child.getChildCount(); i++) {
                    filedEntity = new FieldEntity();
                    int childCount = child.getChild(i).getChildCount();
                    filedEntity.setFieldName(child.getChild(i).getChild(0).toString());
                    if (childCount == 3) {
                        String str = child.getChild(i).getChild(1).toString();
                        if(str.startsWith("TOK_")){
                            filedEntity.setType(str.substring(4));
                        }
                        filedEntity.setDesc(child.getChild(i).getChild(2).toString());
                    } else {
                        filedEntity.setType(child.getChild(i).getChild(1).toString());
                    }
                    list.add(filedEntity);
                }
            }
        }

        // 修改注解
        if (alterTableRenameColIndex != -1) {
            FieldEntity filedEntity = new FieldEntity();
            System.out.println("--- 修改字段注解 ---");
            Tree child = ast.getChild(0).getChild(alterTableRenameColIndex);

            String oldCol = child.getChild(0).toString();
            String newCol = child.getChild(1).toString();

            if (oldCol.equals(newCol)) {
                filedEntity.setFieldName(child.getChild(0).toString());
                String str = child.getChild(2).toString();
                if(str.startsWith("TOK_")){
                    filedEntity.setType(str.substring(4));
                }
                filedEntity.setDesc(child.getChild(3).toString());
                list.add(filedEntity);
            }
        }
        return list;
    }
}

