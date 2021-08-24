package controller;

import ui.LoginFrm;
import ui.MainFrm;
import vo.ProductVO;
import vo.UserVO;

//프로그램의 흐름을 좌지우지하는 controller
public class MainController {
    public static void main(String[] args) {
        MainController.forwardControl("Login"); //개발자가 파일명을 정확히 몰라도 됨
    }
    //자기자신이 변수
    private static MainController mainController; //복수개로 생성 안하도록 함
    private UserVO session; //private외부접근 불가

    private MainController(){} //생성자 못 불러오도록 막음
    public static MainController getInstance(){
        if (mainController == null) mainController = new MainController();
        return mainController; //singleton pattern 오직 1개의 인스턴스만 활용
    }

    //계정이 하나인 것 처럼 session도 하나이다.
    public UserVO getSession() { return session;} //데이터 가져오는 것
    public void setSession(UserVO session) {this.session = session;} //데이터 저장하는 것



    public static void forwardControl(String cmd){
        if (cmd.equals("Login")) {
            new LoginFrm();
        } else if (cmd.equals("Main")) {
            new MainFrm(); //진행을 위해서
        } else if (cmd.equals("Join")) {

        }

    }

}
