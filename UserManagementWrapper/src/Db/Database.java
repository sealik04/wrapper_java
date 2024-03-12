package Db;

import java.sql.*;

public class Database {
    protected Connection conn;
    protected Query query;

    public Database(String db, String userName, String pass) throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://localhost/" + db, userName, pass);
    }
    private int query(String query, Object[] params) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(query);
        if(params != null){
            int index = 1;
            for (Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }
        return ps.executeUpdate();
    }

    public int delete(String table, String condition, Object[] param) throws SQLException{
        query = new Query();
        query.delete(table).where(condition);
        return query(query.getQuery(), param);
    }

    public int insert(String table, Object[] params) throws SQLException{
        query = new Query();
        query.insert(table).values(params);

        return query(query.getQuery(), params);
    }

    public int update(String table, String[] columns, String condition, Object[] params) throws SQLException{
        query = new Query();
        query.update(table).set(columns).where(condition);

        return query(query.getQuery(), params);
    }

    public ResultSet select(String table, Object[] columns, Object[] params) throws SQLException{
        return this.select(table, columns, "", params);
    }

    public ResultSet select(String table, Object[] columns, String condition, Object[] params) throws SQLException{
        query = new Query();
        query.select(columns).from(table).where(condition);

        PreparedStatement ps = conn.prepareStatement(query.getQuery());
        if(params != null){
            int index = 1;
            for(Object param : params){
                ps.setObject(index, param);
                index++;
            }
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
