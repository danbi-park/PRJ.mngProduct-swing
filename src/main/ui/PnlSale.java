package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.DaoCustomer;
import dao.DaoProduct;
import org.jdatepicker.JDatePicker;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PnlSale extends JPanel {
    private JComboBox cbCustomer;
    private JComboBox cbCate;
    private JComboBox cbProd;
    private JDatePicker dPic;
    private JTextField tfPrice, tfTotal, tfAmount;
    private JTable table;

    public PnlSale() {
        setLayout(null);
        setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),"매 출 처 리"));
        dPic = new JDatePicker();
        dPic.setTextEditable(true);

        dPic.getFormattedTextField().setLocation(-55, 0);
        dPic.setBounds(90,43,250,24);
        add(dPic);
        DaoProduct daoProduct = new DaoProduct();

        cbCustomer = new JComboBox(new DaoCustomer().getCustAll());
        cbCustomer.setBounds(395, 43, 243, 23);
        add(cbCustomer);


        cbCate = new JComboBox(daoProduct.getCate());
        cbCate.setBounds(22, 88, 131, 24);
        add(cbCate);

        cbProd = new JComboBox(daoProduct.getProdList(cbCate.getSelectedItem().toString()));
        cbProd.setBounds(157, 89, 232, 24);
        add(cbProd);


        cbCate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cateW = cbCate.getSelectedItem().toString();
                Object[] oArr= null;
                cbProd.removeAllItems();
                try {
                    oArr = new DaoProduct().getProdList(cateW);
                } catch (Exception exception) { }
                    if(oArr.length>0)
                        for (int i = 0; i < oArr.length; i++) {
                            cbProd.addItem(oArr[i]);
                }
            }
        });


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


        tfPrice = new JTextField("125");
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

        JLabel lbImage = new JLabel("\uC81C\uD488 \uC774\uBBF8\uC9C0");
        lbImage.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        lbImage.setBounds(746, 89, 75, 19);
        add(lbImage);

        JLayeredPane layerImage = new JLayeredPane();
        layerImage.setBounds(661, 122, 243, 288);
        add(layerImage);

    }
}