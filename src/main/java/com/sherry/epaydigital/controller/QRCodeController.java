package com.sherry.epaydigital.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sherry.epaydigital.bussiness.domain.QRCodeDomain;
import com.sherry.epaydigital.bussiness.domain.QRDetails;
import com.sherry.epaydigital.bussiness.service.CustomerService;
import com.sherry.epaydigital.bussiness.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Controller

public class QRCodeController {
    CustomerService customerService;
    QRCodeService qrCodeService;

    @Autowired
    public QRCodeController(CustomerService customerService, QRCodeService qrCodeService) {
        this.customerService = customerService;
        this.qrCodeService = qrCodeService;
    }
    private static final String QR_CODE_PATH = "F:\\demo\\epaydigital\\src\\main\\resources\\static\\images\\QRCodeImages\\";

    @RequestMapping("/qrCode")
    public ModelAndView generateQRCodeImage(Model model , HttpSession session) throws IOException, WriterException {
        if (session.getAttribute("email") != null){
            ModelAndView modelAndView = new ModelAndView("/pages/qrCode/qrCodeImage");
            long customerId = customerService.getCustomerId(session.getAttribute("email").toString());
            QRDetails qrDetails = customerService.getCustomerDetailsForQRCode(customerId);
            String text  = qrDetails.getSellerName() + "\n" +
                    qrDetails.getBankName() + "\n" +
                    qrDetails.getAccountNumber() + "\n" +
                    qrDetails.getCountry();
            System.out.println(text + "checking g gg g  g");
            String filePath = QR_CODE_PATH + qrDetails.sellerName +
                    customerId + "QRCode.png";
            System.out.println(filePath + "file path path path ");
            QRCodeDomain qrCodeDomain = new QRCodeDomain();
            makeQRCodeImage(text , filePath);
            qrCodeDomain.setQrCodeImage( qrDetails.sellerName +
                    customerId + "QRCode.png");
            qrCodeService.addQRCodeToDb(qrCodeDomain , customerId);
            model.addAttribute("QRCodeDomain" , qrCodeDomain);
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");

    }

    private void makeQRCodeImage(String text, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text , BarcodeFormat.QR_CODE,
                350, 350);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix , "PNG" ,path);
    }
}
