/**
 * Copyright HashData. All Rights Reserved.
 */

package com.dataflow.core.model.jdbc;


import com.dataflow.common.model.BussinessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取数据库表的具体数据
 */
public class Table {
    public int ncolumns;
    public ArrayList<String> columnName;
    public HashMap<String, Integer> columnType;
    public HashMap<String, Integer> columnPrecision;
    public HashMap<String, Integer> columnScale;
    public ArrayList<String> keyNames;


    public Table(String tableName, Map<String, List<String>> tableMap, Connection conn)
            throws BussinessException {
        this.ncolumns = 0;
        this.columnName = new ArrayList<String>();
        this.keyNames = new ArrayList<String>();
        this.columnType = new HashMap<String, Integer>();
        this.columnPrecision = new HashMap<String, Integer>();
        this.columnScale = new HashMap<String, Integer>();

        Statement statement = null;
        ResultSet rs = null;
        ResultSetMetaData rsMetaData = null;

        try {
            List<String> mapList = tableMap.get(tableName);
            this.keyNames.addAll(mapList);

            statement = conn.createStatement();

            String queryTableInfo = "select * from public." + tableName + " where 1=2";
            rs = statement.executeQuery(queryTableInfo);
            rsMetaData = rs.getMetaData();
            this.ncolumns = rsMetaData.getColumnCount();

            for (int i = 0, len = rsMetaData.getColumnCount(); i < len; i++) {
                String name = rsMetaData.getColumnName(i + 1);
                this.columnName.add(name);
                this.columnType.put(name, rsMetaData.getColumnType(i + 1));
                this.columnPrecision.put(name, rsMetaData.getPrecision(i + 1));
                this.columnScale.put(name, rsMetaData.getScale(i + 1));
            }
        } catch (SQLException e) {
            try {
                conn.close();
            } catch (SQLException ignore) {
            }
            throw new BussinessException("Could not get metadata for public. " + tableName + ".\n", e);
        }
    }
}
