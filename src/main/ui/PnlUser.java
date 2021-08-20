package ui;

import dao.DaoUser;
import vo.UserVO;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlUser extends JPanel {
    private JTextField tfName;
    private JTextField tfId;
    private JTextField tfSearch;
    private JTable table;
    private JPasswordField pfPw;
    private JPasswordField rePw;
    public PnlUser() {
        setLayout(null);
        DaoUser dao = new DaoUser();

        JLabel lblNewLabel = new JLabel("\uC0AC\uC6A9\uC790 \uAD00\uB9AC");
        lblNewLabel.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));
        lblNewLabel.setBounds(31, 27, 185, 58);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
        lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(41, 95, 108, 27);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(47, 147, 108, 27);
        add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Password");
        lblNewLabel_3.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(41, 200, 108, 27);
        add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("RePass");
        lblNewLabel_4.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(41, 250, 108, 27);
        add(lblNewLabel_4);

        tfName = new JTextField();
        tfName.setBounds(170, 95, 141, 27);
        add(tfName);
        tfName.setColumns(10);

        tfId = new JTextField();
        tfId.setColumns(10);
        tfId.setBounds(170, 147, 141, 27);
        add(tfId);

        JButton btnRegist = new JButton("\uB4F1\uB85D");
        btnRegist.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        btnRegist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tfId.getText();
                String name = tfName.getText();
                String pw = new String(pfPw.getPassword());
                String rePass = new String(rePw.getPassword());
               if (name.equals("")) {
                   JOptionPane.showMessageDialog(null,"이름을 입력해주세요");
                   return;
               }
               if (id.equals("")){
                   JOptionPane.showMessageDialog(null,"아이디를 입력해주세요");
                   return;
               }
               if (pw.equals("")) {
                   JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요");
                   return;
               }
               if (rePass.equals("")) {
                   JOptionPane.showMessageDialog(null,"비밀번호 재확인을 해주세요");
                   return;
               }
               if(!pw.equals(rePass)) {
                   JOptionPane.showMessageDialog(null,"아이디를 입력해주세요");
                   pfPw.setText(""); rePw.setText("");
                   return;
               }
                dao.registUser(new UserVO(name, id, pw));

            }
        });
        btnRegist.setBounds(56, 320, 235, 35);
        add(btnRegist);

        JLabel lblNewLabel_5 = new JLabel("\uC0AC\uC6A9\uC790 \uBAA9\uB85D");
        lblNewLabel_5.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));
        lblNewLabel_5.setBounds(336, 27, 185, 58);
        add(lblNewLabel_5);

        tfSearch = new JTextField();
        tfSearch.setColumns(10);
        tfSearch.setBounds(346, 95, 163, 27);
        add(tfSearch);

        JButton btnSearch = new JButton("\uC870\uD68C");
        btnSearch.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        btnSearch.setBounds(517, 95, 108, 27);
        add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(346, 132, 311, 226);
        add(scrollPane);

        table = new JTable();
        scrollPane.setColumnHeaderView(table);

        pfPw = new JPasswordField();
        pfPw.setBounds(170, 200, 141, 27);
        add(pfPw);

        rePw = new JPasswordField();
        rePw.setBounds(170, 257, 141, 27);
        add(rePw);
    }
}