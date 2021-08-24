package vo;
import javax.swing.*;
import java.io.InputStream;
import java.util.Date;
import java.util.function.BinaryOperator;


public class ProductVO {
        private int prodId;
        private String prodName;
        private String prodDesc;
        private String category;
        private String prodAvail;
        private int price;
        private String prodImg;
        private String mimeType;
        private String fileName;
        private Date imgLstDate;


        //모든 정보를 불러올때 사용
        public ProductVO(int prodId, String prodName, String prodDesc, String category, String prodAvail,
                         int price, String prodImg, String mimeType,String fileName, Date imgLstDate){
            this.prodId = prodId;
            this.prodName = prodName;
            this.prodDesc = prodDesc;
            this.category = category;
            this.prodAvail = prodAvail;
            this.price = price;
            this.prodImg = prodImg;
            this.mimeType = mimeType;
            this.fileName = fileName;
            this.imgLstDate = imgLstDate;
        }

}

