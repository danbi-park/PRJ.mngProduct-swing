package dao;

import controller.MainController;
import vo.UserVO;

import java.sql.SQLException;

public class DaoUser extends DaoSet { //상속받았기 때문에 connection도 얻을 수 있음

    public UserVO checkLogin(String id, String pw){ //참조형 변수를 리턴타입으로 해줄 수 있음
        UserVO user = null;
        try {
            conn = connDB(); //connection 연결 (exception발생)

            String query = "select * from demo_users where id=? and password=?";

            pstmt = conn.prepareStatement(query); //connection이되고 날려야 할 쿼리를 pstmt가 쿼리가 데이터베이스에게 이해할 수 있도록한다.
            pstmt.setString(1,id); //위에 홑따옴표 안넣고 물음표로 넣을라고
            pstmt.setString(2,pw);
            rs = pstmt.executeQuery(); //result set에 들어갔는지 비교
            if (rs.next()) {
                //UserVO 에서 들고와서 객체 인스턴스를 만드는 것임 (활용목적)
                user = new UserVO(   //column 인데스 넘버임! (1부터)
                        rs.getInt(1),        //userId
                        rs.getString(2),     //userName
                        rs.getString(3),     //password
                        rs.getDate(4),       //createOn
                        rs.getInt(5),        //quota
                        rs.getString(6),     //products
                        rs.getDate(7),       //expiresOn
                        rs.getString(8),     //adminUser
                        rs.getString(9)      //id
                );
                MainController.getInstance().setSession(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public boolean registUser(UserVO vo){
        boolean result = false;
        try {
            conn = connDB();
            String sql = "insert into demo_users(user_id, user_name," +
                    "password, created_on, quota, products, expires_on " +
                    "admin_user, id) values(demo_users_seq.nextval,?,?," +
                    "sysdate, null, 'Y', null, 'N', ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getUserId());
            pstmt.setString(2,vo.getUserName());
            pstmt.setString(3,vo.getId());
            int cnt = pstmt.executeUpdate();
            result = cnt>0?true:false;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean duplicateId(String id){
        boolean result = false;
        return result;
    }
}