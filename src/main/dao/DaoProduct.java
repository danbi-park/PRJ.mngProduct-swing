package dao;

import javax.imageio.ImageIO;
import javax.swing.*;
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


    public String getProdPrice(String pId){
        String result = "";
        String sql = "select list_price from demo_product_info where product_id =?";
        try {
            conn =  connDB();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(pId));
            rs = pstmt.executeQuery();
            if(rs.next()){ //while을 안 쓴 이유 ! -> id값이 유일한 값들이기 때문에 관련되있는 제품은 한 행밖에 없어서 가격만들어옴 rs이 있으면 그 값을 담아서 가져옴
                result = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getLatestId(){
        String result = "";
        String sql = "select max(product_id)+1 from demo_product_info";
        try {
            conn =  connDB();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ImageIcon getProdImg(String pId){
        ImageIcon result = null;
        String sql = "select product_image from demo_product_info " +
                "where product_id = ? ";
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(pId));
            rs = pstmt.executeQuery();
            if(rs.next()) result =
                    new ImageIcon(ImageIO.read(rs.getBinaryStream(1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}