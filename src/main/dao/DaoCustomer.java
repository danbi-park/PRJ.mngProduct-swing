package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCustomer extends DaoSet {
    public Object[] getCustAll() {
        Object[] result = null;
        String sql = "select CUSTOMER_ID,CUST_FIRST_NAME,CUST_LAST_NAME from demo_customers order by cust_first_name ";
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql); //sql을 담아 준비하는 곳
            rs = pstmt.executeQuery(); //sql을 실행 !
            while (rs.next()) { //다음에 뭐가 있으면? true 계속 진행(while)
                list.add(rs.getInt(1) + "/" + rs.getString(2) + " " + rs.getString(3)); //열 1,2,3 행이 끝날때까지
            }
            result = list.toArray();
        } catch (SQLException throwables) { }
        return result;
    }

}

