package org.parentinc.wfm.controller;

import org.parentinc.wfm.core.BarcodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("v1/wfm")
public class MainController {

    @Autowired
    BarcodeGenerator barcodeGenerator;

    @GetMapping("/health")
    public String health(){
        return "UP";
    }

    @GetMapping("/company/{companyID}/employee/{employeeID}/download")
    public ResponseEntity<byte[]> getBarcode (@PathVariable("employeeID") String employeeID) throws Exception{
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(employeeID);
        if(!m.matches()){
            throw new Exception("Currently we support only numeric values for Employee ID.");
        }
        int numericEmployeeId ;
        while(employeeID.length() < 12) employeeID = employeeID + "0";
        System.out.println(employeeID);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(barcodeGenerator.generateEAN13BarcodeImage(employeeID), "jpg", bos);
        return ResponseEntity
                .ok()
                .body(bos.toByteArray());
    }
}
