package ui;

import java.awt.Font;
import javax.swing.*;

import javafx.scene.control.IndexRange;
import org.jdatepicker.JDatePicker;

import java.awt.Color;

import dao.DaoProduct;

public class PnlProduct extends JPanel {
    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfPrice;
    private JDatePicker dPic;
    private JTextField tfFileName;
    private JTextField tfProductId;
    private JTable table;

    public PnlProduct() {
        setLayout(null);
        DaoProduct daoProduct = new DaoProduct();


        JLabel lbRegistTitle = new JLabel("\uC81C\uD488 \uB4F1\uB85D");
        lbRegistTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lbRegistTitle.setBounds(12, 10, 124, 27);
        add(lbRegistTitle);

        JLabel lbId = new JLabel("ID");
        lbId.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbId.setBounds(80, 48, 62, 27);
        add(lbId);

//        JComboBox cmbId = new JComboBox(daoProduct.getID());
//        cmbId.setBounds(177, 51, 74, 27);
//        cmbId.setEnabled(false);
//        add(cmbId);


        tfId = new JTextField();
        tfId.setBounds(177, 51, 74, 27);
        add(tfId);
        tfId.setColumns(10);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lblName.setBounds(80, 124, 62, 27);
        add(lblName);

        tfName = new JTextField();
        tfName.setColumns(10);
        tfName.setBounds(177, 127, 133, 27);
        add(tfName);


        JLabel lbCategory = new JLabel("Category");
        lbCategory.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbCategory.setBounds(80, 87, 85, 27);
        add(lbCategory);

        String cmbCateItem[] = {"Women","mens","Accessories"};
        JComboBox cmbCate = new JComboBox(cmbCateItem);
        cmbCate.setBounds(177, 88, 133, 26);
        add(cmbCate);

        JLabel lbDescription = new JLabel("Description");
        lbDescription.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 17));
        lbDescription.setBounds(80, 161, 108, 27);
        add(lbDescription);

        JTextArea taDesc = new JTextArea();
        taDesc.setBounds(80, 191, 297, 93);
        add(taDesc);

        JLabel lbPrice = new JLabel("Price");
        lbPrice.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbPrice.setBounds(80, 294, 56, 27);
        add(lbPrice);

        tfPrice = new JTextField();
        tfPrice.setColumns(10);
        tfPrice.setBounds(130, 294, 85, 27);
        add(tfPrice);

        JLabel lbAvail = new JLabel("Avail");
        lbAvail.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbAvail.setBounds(238, 294, 56, 27);
        add(lbAvail);

        JRadioButton rdbtnY = new JRadioButton("Y");
        rdbtnY.setSelected(true);
        rdbtnY.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        rdbtnY.setBounds(289, 294, 42, 27);
        add(rdbtnY);

        JRadioButton rdbtnN = new JRadioButton("N");
        rdbtnN.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        rdbtnN.setBounds(335, 294, 42, 27);
        add(rdbtnN);

        JLabel lbmage = new JLabel("Image");
        lbmage.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbmage.setBounds(80, 331, 56, 27);
        add(lbmage);

        dPic = new JDatePicker();
        dPic.getFormattedTextField().setEditable(true);
        dPic.setVisible(true);
        dPic.setBounds(160,374,171,30);
        add(dPic);

        JLabel lbUpdate = new JLabel("Update");
        lbUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbUpdate.setBounds(80, 368, 74, 27);
        add(lbUpdate);

        String CmbMimeItem[] = {"image/jpeg"};
        JComboBox cmbMime = new JComboBox(CmbMimeItem);
        cmbMime.setBounds(278, 331, 99, 28);
        add(cmbMime);

        tfFileName = new JTextField(".jpg");
        tfFileName.setColumns(10);
        tfFileName.setBounds(160, 331, 108, 27);
        add(tfFileName);

        JButton btnRegist = new JButton("\uB4F1\uB85D");
        btnRegist.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnRegist.setBackground(Color.LIGHT_GRAY);
        btnRegist.setBounds(109, 414, 96, 27);
        add(btnRegist);

        JButton btnCancel = new JButton("\uCDE8\uC18C");
        btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setBounds(236, 414, 96, 27);
        add(btnCancel);


        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(455, 10, 2, 452);
        add(separator);

        /* ------------- 제품 검색  ------------- */
        JLabel lbSearchTitle = new JLabel("\uC81C\uD488 \uAC80\uC0C9");
        lbSearchTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lbSearchTitle.setBounds(480, 10, 124, 27);
        add(lbSearchTitle);

        tfProductId = new JTextField();
        tfProductId.setColumns(10);
        tfProductId.setBounds(618, 48, 74, 27);
        add(tfProductId);

        JLabel lbProductId = new JLabel("Product ID");
        lbProductId.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        lbProductId.setBounds(511, 48, 124, 27);
        add(lbProductId);

        JButton btnSearch = new JButton("\uAC80\uC0C9");
        btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnSearch.setBounds(700, 48, 96, 27);
        add(btnSearch);

        JScrollPane tbProductInfo = new JScrollPane();
        tbProductInfo.setBounds(480, 87, 404, 79);
        add(tbProductInfo);

        table = new JTable();
        tbProductInfo.setViewportView(table);

        JLabel lbImage = new JLabel("");
        lbImage.setBounds(480, 183, 404, 258);
        add(lbImage);
    }
}
