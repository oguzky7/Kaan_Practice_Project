package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;

    public static ResultSet getResultSet(String sqlQuery){
        /**
         * This method create connection to the database,
         * execute query and return object ResulSet
         * @param sqlQuery
         * @return ResultSet
         */
        Connection conn = null;
        Statement statement = null;

        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("dbUrl"),
                    ConfigReader.getPropertyValue("dbUsername"),
                    ConfigReader.getPropertyValue("dbPassword"));
            statement = conn.createStatement();

            rset = statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }

    public static ResultSetMetaData getRsetMetaData(String query){
        /**
         * This method return an Object of ResultSetMetaData
         *
         * @param query
         * @return ResultSetMetaData
         */
        rset = getResultSet(query);
        rSetMetaData = null;

        try {
            rSetMetaData = rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }




    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
/**
 * This method extracts data from ResultSet and stores into List of Maps
 */
        rSetMetaData = getRsetMetaData(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        Map<String, String> mapData;

        try {
            //iterates over the rows
            while (rset.next()) {
                mapData = new LinkedHashMap<>();
                //iterates over the columns
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) {
                    String key = rSetMetaData.getColumnName(i);
                    String value = rset.getString(key);
                    //we store data from every column into a map
                    mapData.put(key, value);
                }
                //we store map with Data into a List
                listFromRset.add(mapData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFromRset;
    }


}
