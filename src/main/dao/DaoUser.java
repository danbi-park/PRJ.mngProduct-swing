package dao;

import controller.MainController;
import vo.UserVO;

import java.sql.SQLException;

public class DaoUser extends DaoSet { //상속받았기 때문에 connection도 얻을 수 있음

    public UserVO checkLogin(String id, String pw){ //참조형 변수를 리턴타입으로 해줄 수 있음
        UserVO user = null;
        try {
            conn = connDB(); //connection 연결 (exception발생)

            String query = "select * from demo_users where id='"
                    +id +"'and password='"+pw +"'";

            pstmt = conn.prepareStatement(query); //connection이되고 날려야 할 쿼리를 pstmt가 쿼리가 데이터베이스에게 이해할 수 있도록한다.
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

}
