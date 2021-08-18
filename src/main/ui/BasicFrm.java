package ui;

import javax.swing.*;
import java.awt.*;

public abstract class BasicFrm extends JFrame {
    private int width,height;

    //super가 얘네들을 호출함
    public BasicFrm(int width, int height, String title)  {
        super("login");
        this.width = width;
        this.height = height;

        //초기화(선생님이 임의로 만든 거임) 할 때마다 다르기 때문에 추상메서드를 써야함
        init();
        arrange();

        //실행
        inflate();

//        this.title = title; title은 슈퍼로 바로 보내면 됨
    }

    /* 추상메서드 */
    public abstract  void init();
    public abstract  void arrange();

    public void inflate(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x를 누르면 실행도 멈춤
    setSize(width,height);
    setLocationRelativeTo(this); //자동적으로 가운데 띄움 위의 setSize와 함께!
    setVisible(true); //창을 보이게 함
    }
}
