package ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class PnlCustomer extends JPanel {
    private JTextField tfId;
    private JTextField tfFName;
    private JTextField tfStreetOne;
    private JTextField tfStreetTwo;
    private JTextField tfState;
    private JTextField tfCity;
    private JTextField tfLName;
    private JTextField tfPh1;
    private JTextField tfPh2;
    private JLabel lbCredit;
    private JTextField tfCredit;
    private JLabel lbEmail;
    private JTextField tfEmail;
    private JTextField tfSearchId;
    private JTable table;
    private JTextField tfPostalCode;

    public PnlCustomer() {
        setLayout(null);

        /* ------------- 고객 등록 ------------- */
        JLabel lbRegistTitle = new JLabel("고객 등록");
        lbRegistTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lbRegistTitle.setBounds(12, 10, 124, 27);
        add(lbRegistTitle);

        JLabel lbId = new JLabel("ID");
        lbId.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbId.setBounds(71, 47, 62, 27);
        add(lbId);

        tfId = new JTextField("");
        tfId.setPreferredSize(new Dimension(136, 21));
        tfId.setColumns(10);
        tfId.setBounds(145, 47, 106, 27);
        add(tfId);

        JLabel lbName = new JLabel("Name");
        lbName.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbName.setBounds(71, 89, 62, 27);
        add(lbName);

        CustomTextField tfFName = new CustomTextField(10);
        tfFName.setPreferredSize(new Dimension(136, 21));
        tfFName.setPlaceholder("First name");
        tfFName.setBounds(145, 89, 106, 27);
        add(tfFName);

        CustomTextField tfLName = new CustomTextField(10);
        tfLName.setPreferredSize(new Dimension(136, 21));
        tfLName.setPlaceholder("Last name");
        tfLName.setBounds(263, 89, 106, 27);
        add(tfLName);


        JLabel lbPhone = new JLabel("Phone");
        lbPhone.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbPhone.setBounds(71, 135, 62, 27);
        add(lbPhone);


        String cmbPhItem[]= {"010","011","016"};
        JComboBox cmbPh = new JComboBox(cmbPhItem);
        cmbPh.setBounds(145, 138, 67, 27);
        add(cmbPh);


        tfPh1 = new JTextField("");
        tfPh1.setPreferredSize(new Dimension(136, 21));
        tfPh1.setColumns(10);
        tfPh1.setBounds(223, 138, 81, 27);
        add(tfPh1);

        tfPh2 = new JTextField("");
        tfPh2.setPreferredSize(new Dimension(136, 21));
        tfPh2.setColumns(10);
        tfPh2.setBounds(312, 138, 81, 27);
        add(tfPh2);

        lbEmail = new JLabel("Email");
        lbEmail.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbEmail.setBounds(71, 185, 62, 27);
        add(lbEmail);

        tfEmail = new JTextField("");
        tfEmail.setPreferredSize(new Dimension(136, 21));
        tfEmail.setColumns(10);
        tfEmail.setBounds(145, 185, 112, 27);
        add(tfEmail);

        JLabel atSign = new JLabel("@");
        atSign.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        atSign.setBounds(263, 185, 29, 27);
        add(atSign);

        String cmbEmailItem[]= {"naver.com","daum.net","gmail.com"};
        JComboBox cmbEmail = new JComboBox(cmbEmailItem);
        cmbEmail.setBounds(287, 185, 106, 27);
        add(cmbEmail);


        JLabel lbAddress = new JLabel("Address");
        lbAddress.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbAddress.setBounds(71, 235, 81, 27);
        add(lbAddress);

        CustomTextField tfStreetOne = new CustomTextField(10);
        tfStreetOne.setPreferredSize(new Dimension(136, 21));
        tfStreetOne.setPlaceholder("Street 1");
        tfStreetOne.setBounds(71, 272, 139, 27);
        add(tfStreetOne);

        CustomTextField tfStreetTwo = new CustomTextField(10);
        tfStreetTwo.setPreferredSize(new Dimension(136, 21));
        tfStreetTwo.setPlaceholder("Street 2");
        tfStreetTwo.setBounds(226, 272, 96, 27);
        add(tfStreetTwo);

        CustomTextField tfCity = new CustomTextField(10);
        tfCity.setPreferredSize(new Dimension(136, 21));
        tfCity.setPlaceholder("City Name");
        tfCity.setBounds(71, 309, 139, 27);
        add(tfCity);

        CustomTextField tfState = new CustomTextField(10);
        tfState.setPreferredSize(new Dimension(136, 21));
        tfState.setPlaceholder("State");
        tfState.setBounds(226, 309, 78, 27);
        add(tfState);

        CustomTextField tfPostalCode = new CustomTextField(10);
        tfPostalCode.setPreferredSize(new Dimension(136, 21));
        tfPostalCode.setPlaceholder("Post Code");
        tfPostalCode.setBounds(318, 309, 96, 27);
        add(tfPostalCode);


        lbCredit = new JLabel("Credit limit");
        lbCredit.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbCredit.setBounds(71, 360, 104, 27);
        add(lbCredit);

        tfCredit = new JTextField("");
        tfCredit.setPreferredSize(new Dimension(136, 21));
        tfCredit.setColumns(10);
        tfCredit.setBounds(187, 360, 117, 27);
        add(tfCredit);


        JButton btnRegist = new JButton("\uB4F1\uB85D");
        btnRegist.setBackground(Color.LIGHT_GRAY);
        btnRegist.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnRegist.setBounds(114, 420, 96, 27);
        add(btnRegist);

        JButton btnCancel = new JButton("\uCDE8\uC18C");
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setBounds(241, 420, 96, 27);
        add(btnCancel);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(455, 10, 2, 452);
        add(separator);

        /* ------------- 고객 검색  ------------- */
        JLabel lbSearchTitle = new JLabel("고객 검색");
        lbSearchTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lbSearchTitle.setBounds(480, 10, 124, 27);
        add(lbSearchTitle);

        JLabel lbSearchId = new JLabel("ID");
        lbSearchId.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbSearchId.setBounds(539, 47, 62, 27);
        add(lbSearchId);

        tfSearchId = new JTextField("");
        tfSearchId.setPreferredSize(new Dimension(136, 21));
        tfSearchId.setColumns(10);
        tfSearchId.setBounds(593, 47, 106, 27);
        add(tfSearchId);

        JButton btnSearch = new JButton("\uAC80\uC0C9");
        btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnSearch.setBounds(711, 47, 96, 27);
        add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(480, 89, 404, 297);
        add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnEdit = new JButton("\uC218\uC815");
        btnEdit.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnEdit.setBackground(Color.LIGHT_GRAY);
        btnEdit.setBounds(668, 402, 96, 27);
        add(btnEdit);

        JButton btnDelete = new JButton("\uC0AD\uC81C");
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnDelete.setBackground(Color.LIGHT_GRAY);
        btnDelete.setBounds(776, 402, 96, 27);
        add(btnDelete);



    }
}
