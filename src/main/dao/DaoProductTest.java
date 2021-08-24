package dao;

import controller.MainController;
import vo.ProductVO;
import vo.UserVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class DaoProductTest extends DaoSet{

    public ProductVO checkLogin(int prodId, String prodName){ //참조형 변수를 리턴타입으로 해줄 수 있음
        ProductVO product = null;
        try {
            conn = connDB();
            String query = "select * from demo_product_info where product_id=? and product_name=? ";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,prodId);
            pstmt.setString(2,prodName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new ProductVO( //생성자 있는데 왜 안되는지
                        rs.getInt(1),        //prodId
                        rs.getString(2),     //prodName
                        rs.getString(3),     //Description
                        rs.getString(4),     //category
                        rs.getString(5),     //prodAvail
                        rs.getInt(6),        //price
                        rs.getString(7),     //prodImg
                        rs.getString(8),     //mimeType
                        rs.getString(9),     //fileName
                        rs.getDate(10)     //imgLstDate
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }


    public void registUser(UserVO vo){
        try {
            conn = connDB();
            if(duplicateId(vo.getId())) return;
            String sql = "insert into demo_users(user_id, user_name, " +
                    "password, created_on, quota, products, expires_on, " +
                    "admin_user, id) values(demo_users_seq.nextval,?,?," +
                    "sysdate,null,'Y',null,'N', ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getUserName());
            pstmt.setString(2,vo.getPassword());
            pstmt.setString(3,vo.getId());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                JOptionPane.showMessageDialog(null,"등록이 완료되었습니다.");

            }else{
                JOptionPane.showMessageDialog(null,"등록에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean duplicateId(String id){
        boolean result = false;
        try {
            conn = connDB();
            String sql = "select * from demo_users where id=?  ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "중복된 ID입니다.");
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public DefaultTableModel getUserList(DefaultTableModel model, String srch) {
        String query ="";
        model = new DefaultTableModel(
                new String[]{"USER_ID","ID","이름","입사일","QUOTA",
                        "상품여부","퇴사일","관리자"},0);
        try {
            conn = connDB(); //connection 연결 (exception발생)
            if (srch.equals("")){
                query = "select * from demo_users";
            } else{
                query = "select * from demo_users where user_name=?";
            }
            pstmt = conn.prepareStatement(query);
            if (!srch.equals("")) pstmt.setString(1,srch);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] tmpArr ={
                        rs.getInt(1)+"",rs.getString(9),
                        rs.getString(2),rs.getDate(4) +"",rs.getInt(5) +"",
                        rs.getString(6),String.valueOf(rs.getDate(7)),
                        rs.getString(8)
                };
                model.addRow(tmpArr);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model; //내가 받은 model을 돌려줌
    }
}
