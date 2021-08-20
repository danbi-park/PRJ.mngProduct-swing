package ui;

import com.sun.xml.internal.bind.v2.model.core.ID;
import dao.DaoUser;
import vo.UserVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private DefaultTableModel model;


    public PnlUser() {
        setLayout(null);
        DaoUser dao = new DaoUser();
        model = new DefaultTableModel(
                new String[]{"USER_ID","ID","이름","입사일","QUOTA",
                "상품여부","퇴사일","관리자"},0);


        JLabel lbTitle1 = new JLabel("\uC0AC\uC6A9\uC790 \uAD00\uB9AC");
        lbTitle1.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));
        lbTitle1.setBounds(98, 60, 185, 58);
        add(lbTitle1);

        JLabel lbName = new JLabel("\uC774\uB984");
        lbName.setFont(new Font("한컴 윤고딕 250", Font.PLAIN, 20));
        lbName.setBounds(108, 128, 108, 27);
        add(lbName);

        JLabel lbId = new JLabel("ID");
        lbId.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
        lbId.setBounds(108, 180, 108, 27);
        add(lbId);

        JLabel lbPass = new JLabel("Password");
        lbPass.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
        lbPass.setBounds(108, 233, 108, 27);
        add(lbPass);

        JLabel lbRePass = new JLabel("RePass");
        lbRePass.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
        lbRePass.setBounds(108, 288, 108, 27);
        add(lbRePass);

        tfName = new JTextField();
        tfName.setBounds(237, 128, 141, 27);
        add(tfName);
        tfName.setColumns(10);

        tfId = new JTextField();
        tfId.setColumns(10);
        tfId.setBounds(237, 180, 141, 27);
        add(tfId);

        pfPw = new JPasswordField();
        pfPw.setBounds(237, 233, 141, 27);
        add(pfPw);

        rePw = new JPasswordField();
        rePw.setBounds(237, 290, 141, 27);
        add(rePw);

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
                   tfName.requestFocus();
                   return;
               }
               if (id.equals("")){
                   JOptionPane.showMessageDialog(null,"아이디를 입력해주세요");
                   tfId.requestFocus();
                   return;
               }
               if (pw.equals("")) {
                   JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요");
                   pfPw.requestFocus();
                   return;
               }
               if (rePass.equals("")) {
                   JOptionPane.showMessageDialog(null,"비밀번호 재확인을 해주세요");
                   rePw.requestFocus();
                   return;
               }
               if(!pw.equals(rePass)) {
                   JOptionPane.showMessageDialog(null,"비밀번호가 맞지 않습니다.");
                   pfPw.setText(""); rePw.setText("");
                   pfPw.requestFocus();
                   return;
               }
               dao.registUser(new UserVO(name, id, pw));
            }
        });
        btnRegist.setBounds(123, 353, 235, 35);
        add(btnRegist);

        JLabel lbTitle2 = new JLabel("\uC0AC\uC6A9\uC790 \uBAA9\uB85D");
        lbTitle2.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));
        lbTitle2.setBounds(522, 57, 185, 58);
        add(lbTitle2);

        tfSearch = new JTextField();
        tfSearch.setColumns(10);
        tfSearch.setBounds(532, 125, 163, 27);
        add(tfSearch);


        table = new JTable(new DefaultTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(532, 162, 311, 226);
        add(scrollPane);

        JButton btnSearch = new JButton("\uC870\uD68C");
        btnSearch.addActionListener(e-> {
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
            while(table.getRowCount()>0){
                model.removeRow(0);
            }
            String srch = tfSearch.getText();
            model = dao.getUserList(model,srch); //
            table.setModel(model);
            model.fireTableDataChanged();
        });
        btnSearch.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
        btnSearch.setBounds(703, 125, 108, 27);
        add(btnSearch);

    }
}