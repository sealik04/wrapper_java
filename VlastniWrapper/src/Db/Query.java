package Db;

public class Query {
    private StringBuilder query;

    public Query delete(String table){
        query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(table);
        return this;
    }
    public Query where(String condition){
        query.append(" WHERE ");
        query.append(condition);
        return this;
    }

    public Query update(String table){
        query = new StringBuilder();
        query.append("UPDATE ");
        query.append(table);
        query.append(" SET ");
        return this;
    }
    public Query set(String[] columns){
        int count = columns.length;
        if(count == 0){
            throw new IllegalArgumentException("Neplatný počet parametrů");
        }
        for (String column : columns){
            query.append(column);
            query.append("=");
            query.append("?");
            query.append(",");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        return this;
    }

    public Query insert(String table){
        query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(table);
        return this;
    }

    public Query values(Object[] parametry){
        query.append(" VALUES(");

        int count = parametry.length;
        if(count == 0){
            throw new IllegalArgumentException("Neplatný počet parametrů");
        }
        for (int i = 0; i <count; i++){
            query.append("?,");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(");");
        return this;
    }

    public Query select(Object[] columns){
        query = new StringBuilder();
        query.append("SELECT ");
        if(columns  != null){
            for (Object column : columns){
                query.append(column);
                query.append(",");
            }
            query.deleteCharAt(query.lastIndexOf(","));
        } else {
            query.append("* ");
        }
        return this;
    }

    public Query from(String table){
        query.append(" FROM ");
        query.append(table);
        return this;
    }

    public String getQuery(){
        return query.toString();
    }
}
