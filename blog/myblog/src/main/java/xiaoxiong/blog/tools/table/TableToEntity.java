package xiaoxiong.blog.tools.table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.sql.*;


/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/21
 */
public class TableToEntity {

    private static Logger log = LoggerFactory.getLogger(TableToEntity.class);
    private static Connection conn = null;
    private static Statement st = null;
    static {
        String URL="jdbc:mysql://127.0.0.1:3306/myblog?useUnicode=true&amp;characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, password);
            st=conn.createStatement();
        } catch (SQLException e) {
            log.error("创建出错");
        } catch (ClassNotFoundException e) {
            log.error("驱动找不到");
        }
    }

    public static void selectTable(String tableName){
        StringBuilder entity = new StringBuilder();
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
//            //获取表的名字
//            ResultSet tableRet = dbmd.getTables(null, "%", tableName, new String[]{"TABLE"});
//            while(tableRet.next()) System.out.println(tableRet.getString("TABLE_NAME"));

            //获取该表所有的列
            ResultSet colRet = dbmd.getColumns(null,"%", tableName,"%");

            while(colRet.next()){
//                //类型大小
//                int datasize = colRet.getInt("COLUMN_SIZE");
//                int digits = colRet.getInt("DECIMAL_DIGITS");
//                //是否可以为null 0 : not null  1 : null
//                int nullable = colRet.getInt("NULLABLE");

                String columnName = colRet.getString("COLUMN_NAME");
                String columnType = colRet.getString("TYPE_NAME");
                String comment = colRet.getString("REMARKS");
                if(comment != null && !StringUtils.isEmpty(comment)){
                    entity.append("//").append(comment).append("\n");
                }
                StringBuilder nb = new StringBuilder(columnName);
                entityName(columnName, nb, "_");
                entityName(columnName, nb, "-");
                entity.append("private ");
                switch (columnType){
                    case "INT":
                        entity.append("Integer ");
                        break;
                    case "VARCHAR":
                    case "TEXT":
                        entity.append("String ");
                        break;
                    case "DATETIME":
                        entity.append("Date ");
                        break;
                    default:break;
                }
                entity.append(nb.append(";\n").toString());
            }

        } catch (SQLException e) {
            log.error("查询出错{}", e);
        }
        System.out.println(entity.toString());
    }

    private static void entityName(String columnName, StringBuilder nb, String rgx) {
        while(nb.toString().contains(rgx)){
            int ind1 = nb.toString().indexOf(rgx);
            int len = nb.toString().length();
            if(ind1 != -1){
                nb.replace(ind1, ind1+1, "");
                if(ind1 != len - 1 || ind1 != len - 2){
                    //由于删除掉"_" 所有下面还是ind1, ind1 + 1
                    nb.replace(ind1, ind1 + 1, Character.toUpperCase(columnName.charAt(ind1+1))+"");
                }
            }
        }
    }


    public static void main(String[] args){
        selectTable("reply_answer");
//        ResultSet rs=st.executeQuery("select * from user");
    }

}
