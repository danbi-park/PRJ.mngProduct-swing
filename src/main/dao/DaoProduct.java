package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoProduct extends DaoSet {
    public Object[] getCate() {
        Object[] result = null;
        String sql = "select DISTINCT category from demo_product_info "; //열 하나만 !
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            result = list.toArray();
        } catch (SQLException throwables) { }
        return result;
    }

    public Object[] getProdList(String cate) {
        Object[] result = null;
        String sql = "select product_id, product_name from demo_product_info where category=? ";
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,cate); //1 -> 첫번째 물음표
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1)+"/"+rs.getString(2));
            }
            result = list.toArray();
        } catch (SQLException throwables) { }
        return result;
    }



    public Object[] getID() {
        Object[] result = null;
        String sql = "select max(product_id)+1 from demo_product_info ";
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            result = list.toArray();
        } catch (SQLException throwables) { }

        return result;
    }



}