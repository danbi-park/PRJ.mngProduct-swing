package ui;

import controller.MainController;
import dao.DaoUser;
import vo.UserVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginFrm extends BasicFrm implements ActionListener{

    public LoginFrm() {
        super(300,150,"Login");
    }


    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JLabel id, pw;

    private JTextField tfId;
    private JPasswordField pfpw;
    private JButton btnLogin, btnCancel, btnSignIn;


    @Override
    public void init() {
        setResizable(false);
        pnlNorth = new JPanel();
        pnlCenter = new JPanel();
        pnlSouth = new JPanel();
        btnLogin = new JButton("로그인");
        btnSignIn = new JButton("회원가입");
        btnCancel = new JButton("취소");
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        btnSignIn.addActionListener(this);

        id = new JLabel("ID      ");
        id.setFont(new Font("consolas",Font.BOLD,20));
        tfId = new JTextField(10);
        pfpw = new JPasswordField(10);
        tfId.setText("ADMIN");
        pfpw.setText("1");
        pw = new JLabel("password");
        pw.setFont(new Font("consolas",Font.BOLD,20));

    }

    @Override
    public void arrange() {
        pnlNorth.add(id);
        pnlNorth.add(tfId);
        pnlCenter.add(pw);
        pnlCenter.add(pfpw);
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnCancel);
        pnlSouth.add(btnSignIn);

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String id = tfId.getText();
        String pw = new String(pfpw.getPassword()); //암호화되있기 때문에 이렇게 가져와야함
        if (e.getSource() == btnLogin) {
            if (id == null || id.equals("")) {
                JOptionPane.showMessageDialog(null, "id를 입력해주세요");
                tfId.requestFocus();
                return;
            }
            if (pw == null || pw.equals("")) {
                JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요");
                pfpw.requestFocus();
                return;
            }
            UserVO userVO = new DaoUser().checkLogin(id,pw); //UserVO가 넘어옴 !! Daouser의 리턴타입이 UserVO라서
            //id와 pw가 있으면 id,pw 없으면 null!
            if (userVO == null) {
                JOptionPane.showMessageDialog(null,"존재하지 않는 ID입니다.");
                tfId.setText(""); pfpw.setText("");
                tfId.requestFocus();
                return;
            }
                dispose(); //자신은 창을 닫음
            MainController.forwardControl("Main");

        } else if (e.getSource() == btnCancel) {
        } else if (e.getSource() == btnSignIn) {
        }

    }
}