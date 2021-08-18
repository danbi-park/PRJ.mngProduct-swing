package ui;

import controller.MainController;
import vo.UserVO;

public class MainFrm extends BasicFrm{


    public MainFrm() {
        super(800,600,
                "님 환영합니다.");
        String msg = MainController.getInstance().getSession().getUserName()+ "님 환영합니다.";
        setTitle(msg);
    }

    @Override
    public void init() {

    }

    @Override
    public void arrange() {

    }

    @Override
    public void inflate() {
        super.inflate();
    }
}
