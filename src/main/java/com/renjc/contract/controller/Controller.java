package com.renjc.contract.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import org.postgresql.Driver;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/centercontract")
@Slf4j
public class Controller {
    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("getContract")
    public JSONObject getContract() {
        //定义下面需要的对象
        Connection conn = null;
        Statement stmt = null;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            DriverManager.registerDriver(new Driver());
            //地址
            String url = "jdbc:postgresql://172.24.247.173:5432/cmtt";
            //用户名
            String user = "cmtt_xmzj";
            //密码
            String password = "&v%duU1$";
            //创建链接
            logger.error("开始链接数据库");
            conn = DriverManager.getConnection(url, user, password);
            logger.error("数据库连接对象" + conn);
            //第三步获取数据库操作对象
            stmt = conn.createStatement();
            //第四步 执行sql语句
            String sql = "select * from cmtt_share_view.view_cms_contract_base_info";
            //查询结果
            ResultSet resultSet = stmt.executeQuery(sql);
            //结果解析并封装
            while (resultSet.next()) {
                JSONObject result = new JSONObject();
                formResult(resultSet, result);
                jsonArray.add(result);
            }
            jsonObject.put("contract_result",jsonArray);
            return jsonObject;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            jsonObject.put("error", e.getMessage());
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return jsonObject;
    }

    @GetMapping("getDept")
    public JSONObject getDept() {
        //定义下面需要的对象
        Connection conn = null;
        Statement stmt = null;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            DriverManager.registerDriver(new Driver());
            //地址
            String url = "jdbc:postgresql://172.24.247.173:5432/cmtt";
            //用户名
            String user = "cmtt_xmzj";
            //密码
            String password = "&v%duU1$";
            //创建链接
            logger.error("开始链接数据库");
            conn = DriverManager.getConnection(url, user, password);
            logger.error("数据库连接对象" + conn);
            //第三步获取数据库操作对象
            stmt = conn.createStatement();
            //第四步 执行sql语句
            String sql = "select * from cmtt_share_view.view_cms_cms_other_execuse_dept";
            //查询结果
            ResultSet resultSet = stmt.executeQuery(sql);
            //结果解析并封装
            while (resultSet.next()) {
                JSONObject result = new JSONObject();
                formResult1(resultSet, result);
                jsonArray.add(result);
            }
            jsonObject.put("dept_result",jsonArray);
            return jsonObject;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            jsonObject.put("error", e.getMessage());
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return jsonObject;
    }

    @GetMapping("getPerson")
    public JSONObject getPerson() {
        //定义下面需要的对象
        Connection conn = null;
        Statement stmt = null;
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            DriverManager.registerDriver(new Driver());
            //地址
            String url = "jdbc:postgresql://172.24.247.173:5432/cmtt";
            //用户名
            String user = "cmtt_xmzj";
            //密码
            String password = "&v%duU1$";
            //创建链接
            logger.error("开始链接数据库");
            conn = DriverManager.getConnection(url, user, password);
            logger.error("数据库连接对象" + conn);
            //第三步获取数据库操作对象
            stmt = conn.createStatement();
            //第四步 执行sql语句
            String sql = "select * from cmtt_share_view.view_cms_cms_other_execuse_person";
            //查询结果
            ResultSet resultSet = stmt.executeQuery(sql);
            //结果解析并封装
            while (resultSet.next()) {
                JSONObject result = new JSONObject();
                formResult2(resultSet, result);
                jsonArray.add(result);
            }
            jsonObject.put("person_result",jsonArray);
            return jsonObject;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            jsonObject.put("error", e.getMessage());
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return jsonObject;
    }

    private void formResult(ResultSet resultSet, JSONObject result) throws SQLException {
        result.put("CONTRACT_NAME", resultSet.getString("CONTRACT_NAME"));
        result.put("CONTRACT_SERIAL_NO", resultSet.getString("CONTRACT_SERIAL_NO"));
        result.put("CONTRACT_NO", resultSet.getString("CONTRACT_NO"));
        result.put("PROVINCE_CODE", resultSet.getString("PROVINCE_CODE"));
        result.put("OLD_CONTRACT_NO", resultSet.getString("OLD_CONTRACT_NO"));
        result.put("OLD_CONTRACT_NAME", resultSet.getString("OLD_CONTRACT_NAME"));
        result.put("CREATE_DATE", resultSet.getString("CREATE_DATE"));
        result.put("APPROVE_DATE", resultSet.getString("APPROVE_DATE"));
        result.put("SIGNED_DATE", resultSet.getString("SIGNED_DATE"));
        result.put("ARC_TIME", resultSet.getString("ARC_TIME"));
        result.put("START_DATE", resultSet.getString("START_DATE"));
        result.put("END_DATE", resultSet.getString("END_DATE"));
        result.put("FINISH_DATE", resultSet.getString("FINISH_DATE"));
        result.put("INC_EXP_TYPE", resultSet.getString("INC_EXP_TYPE"));
        result.put("CURRENCY", resultSet.getString("CURRENCY"));
        result.put("AMOUNT_TYPE", resultSet.getString("AMOUNT_TYPE"));
        result.put("ORIGINAL_CURRENCY_AMOUNT", resultSet.getString("ORIGINAL_CURRENCY_AMOUNT"));
        result.put("AMOUNT_INCLUDING_TAX", resultSet.getString("AMOUNT_INCLUDING_TAX"));
        result.put("AMOUNT_ADJUST_INCLUDING_TAX", resultSet.getString("AMOUNT_ADJUST_INCLUDING_TAX"));
        result.put("AMOUNT_EXCLUDING_TAX", resultSet.getString("AMOUNT_EXCLUDING_TAX"));
        result.put("AMOUNT_ADJUST_EXCLUDING_TAX", resultSet.getString("AMOUNT_ADJUST_EXCLUDING_TAX"));
        result.put("TAX_AMOUNT", resultSet.getString("TAX_AMOUNT"));
        result.put("TAX_AMOUNT_ADJUST", resultSet.getString("TAX_AMOUNT_ADJUST"));
        result.put("VENDOR_CODE", resultSet.getString("VENDOR_CODE"));
        result.put("VENDOR_NAME", resultSet.getString("VENDOR_NAME"));
        result.put("VENDOR_SITE_CODE", resultSet.getString("VENDOR_SITE_CODE"));
        result.put("VENDOR_SITE_INFO", resultSet.getString("VENDOR_SITE_INFO"));
    }
    private void formResult1(ResultSet resultSet, JSONObject result) throws SQLException {
        result.put("DEPT_CODE", resultSet.getString("DEPT_CODE"));
        result.put("DEPT_NAME", resultSet.getString("DEPT_NAME"));
    }
    private void formResult2(ResultSet resultSet, JSONObject result) throws SQLException {
        result.put("OTHER_EXECUTOR", resultSet.getString("OTHER_EXECUTOR"));
        result.put("OTHER_EXECUTOR_CODE", resultSet.getString("OTHER_EXECUTOR_CODE"));
        result.put("DEPT_NAME", resultSet.getString("DEPT_NAME"));
        result.put("DEPT_CODE", resultSet.getString("DEPT_CODE"));
        result.put("COMPANY_CODE", resultSet.getString("COMPANY_CODE"));
        result.put("COMPANY_NAME", resultSet.getString("COMPANY_NAME"));
    }
}
