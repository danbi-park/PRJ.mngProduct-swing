package ui;

import java.awt.*;

import javax.swing.*;

import dao.DaoCustomer;
import dao.DaoProduct;
import org.jdatepicker.JDatePicker;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PnlSaleTest extends JPanel {
    private JComboBox cbCustomer;
    private JComboBox cbCate;
    private JComboBox cbProd;
    private JDatePicker dPic;
    private JTextField tfPrice, tfTotal, tfAmount;
    private JTable table;
    private JLabel lbProdImg, lbProdImgBack;
    private DaoCustomer daoCustomer = new DaoCustomer();
    private DaoProduct daoProduct = new DaoProduct();


    public PnlSaleTest() {
        setLayout(null);
        setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),"매 출 처 리"));
        dPic = new JDatePicker();
        dPic.setTextEditable(true);

        dPic.getFormattedTextField().setLocation(-55, 0);
        dPic.setBounds(90,43,250,24);
        add(dPic);

        String pId = (cbProd.getSelectedItem().toString()).split("/")[0];
        tfPrice = new JTextField(daoProduct.getProdPrice(pId));
        ImageIcon img = daoProduct.getProdImg(pId);
        lbProdImg.setIcon(resizeImg(img));

        cbCustomer = new JComboBox(daoCustomer.getCustAll());
        cbCustomer.setBounds(395, 43, 243, 23);
        add(cbCustomer);

        cbCate = new JComboBox(daoProduct.getCate());
        cbCate.setBounds(22, 88, 131, 24);
        add(cbCate);

        cbProd = new JComboBox(daoProduct.getProdList(cbCate.getSelectedItem().toString()));
        cbProd.setBounds(157, 89, 232, 24);
        add(cbProd);

        SimpleDateFormat mSimpleDateFromat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        Date currentTime= new Date();
        String mTime = mSimpleDateFromat.format(currentTime);

        JLabel lbCustomerName = new JLabel("\uACE0\uAC1D\uBA85");
        lbCustomerName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lbCustomerName.setBounds(355, 43, 57, 24);
        add(lbCustomerName);

        JLabel lbReportinDate = new JLabel("\uC804\uD45C\uC791\uC131\uC77C");
        lbReportinDate.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lbReportinDate.setBounds(22, 43, 75, 24);
        add(lbReportinDate);


        tfPrice.setBounds(413, 88, 69, 24);
        tfPrice.setEditable(false);
        add(tfPrice);
        tfPrice.setColumns(10);


        tfAmount = new JTextField();
        tfAmount.setBounds(485, 88, 75, 24);
        add(tfAmount);
        tfAmount.setColumns(10);

        tfTotal = new JTextField();
        tfTotal.setColumns(10);
        tfTotal.setBounds(563, 88, 75, 24);
        add(tfTotal);

        JLabel lbImage = new JLabel("제품 이미지");
        lbImage.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lbImage.setBounds(733, 89, 75, 19);
        add(lbImage);

        lbProdImg= new JLabel();
        lbProdImg.setBounds(660, 122, 243, 288);



        lbProdImgBack = new JLabel();
        lbProdImgBack.setOpaque(true); //이미지를 올릴 수 있음
        lbProdImgBack.setBackground(Color.WHITE);
        Border bevelBorder = new BevelBorder(BevelBorder.RAISED,
                Color.LIGHT_GRAY,Color.LIGHT_GRAY.darker(),
                Color.LIGHT_GRAY,Color.LIGHT_GRAY.brighter());
        lbProdImgBack.setBorder(bevelBorder);
        lbProdImgBack.setBounds(650, 122, 243, 288);
        add(lbProdImg);
        add(lbProdImgBack);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.DARK_GRAY);
        separator.setBackground(Color.LIGHT_GRAY);
        separator.setBounds(22, 122, 616, 288);
        add(separator);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(22, 408, 627, -284);
        add(scrollPane);

        table = new JTable();
        table.setBounds(23, 409, 626, -285);
        add(table);

        JLabel lbTotal = new JLabel("\uD569\uACC4 :");
        lbTotal.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lbTotal.setBackground(Color.DARK_GRAY);
        lbTotal.setBounds(32, 420, 255, 24);
        add(lbTotal);

        JButton btnAdd = new JButton("\uCD94\uAC00");
        btnAdd.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btnAdd.setBounds(378, 420, 75, 23);
        add(btnAdd);

        JButton btnDelete = new JButton("\uC0AD\uC81C");
        btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btnDelete.setBounds(460, 420, 75, 23);
        add(btnDelete);

        JButton btnPay = new JButton("\uACB0 \uC81C");
        btnPay.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btnPay.setBounds(541, 420, 97, 23);
        add(btnPay);



        cbCate.addActionListener(e -> {
            String cateW = cbCate.getSelectedItem().toString();
            Object[] oArr = null;
            cbProd.removeAllItems();
            try {
                oArr = daoProduct.getProdList(cateW);
            } catch (Exception e1) {
            }
            if (oArr.length > 0) {
                for (int i = 0; i < oArr.length; i++) {
                    cbProd.addItem(oArr[i]);
                }
            }
            String pId1 = cbProd.getSelectedItem().toString().split("/")[0];
            tfPrice.setText(daoProduct.getProdPrice(pId1));
            ImageIcon img1 = daoProduct.getProdImg(pId1);
            lbProdImg.setIcon(resizeImg(img1));
        });

        cbProd.addActionListener(e -> {
            if (cbProd.getSelectedItem() != null) {
                String pId2 = cbProd.getSelectedItem().toString().split("/")[0];
                tfPrice.setText(daoProduct.getProdPrice(pId2));
                ImageIcon img2 = daoProduct.getProdImg(pId2);
                lbProdImg.setIcon(resizeImg(img2));

            }
        });

    }
    private ImageIcon resizeImg(ImageIcon img){
        int imgW = img.getIconWidth();
        int imgH = img.getIconHeight();
        int dynamicH = imgH*230/imgW;
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(230, dynamicH,
                java.awt.Image.SCALE_SMOOTH);
        return img = new ImageIcon(newimg);
    }
}