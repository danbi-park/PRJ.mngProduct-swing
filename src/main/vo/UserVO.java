package vo;

import java.util.Date;

public class UserVO {
    //은닉성이 확보되어 초기화를 ,setter와 생성자를 통해 한다.
    private int userId;
    private String userName;
    private String password;
    private Date createOn; //참조형 변수
    private int quota;
    private String products;
    private Date expiresOn;
    private String adminUser;
    private String  id;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    //user의 모든 정보를 들고 와서 담을 때
    public UserVO(int userId, String userName, String password,
                  Date createOn, int quota, String products,
                  Date expiresOn, String adminUser, String id) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createOn = createOn;
        this.quota = quota;
        this.products = products;
        this.expiresOn = expiresOn;
        this.adminUser = adminUser;
        this.id = id;
    }

    //demo_user을 insert할 때 사용
    public UserVO(String userName, String password, String id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }


}

