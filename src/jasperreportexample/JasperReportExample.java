/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jasperreportexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USUARIO
 */
public class JasperReportExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello World...");
        
        String reporteFile = "C:\\Users\\USUARIO\\Documents\\reporte-pdp-osl.jasper";
        String reportePdf = "C:\\Users\\USUARIO\\Documents\\reporte-pdp-osl.pdf";
        
        /* List to hold Items */
        List<Item> listItems = new ArrayList<>();

        /* Create Items */
        Item iPhone = new Item();
//            iPhone.setName("iPhone 6S");
        iPhone.setPrice(65000.00);
        iPhone.setItemNo("100");
        iPhone.setProductName("Es un iphone");
        iPhone.setQty(23);
        iPhone.setLineTotal(223.12);

        Item iPad = new Item();
//            iPad.setName("iPad Pro");
        iPad.setPrice(70000.00);
        iPad.setItemNo("200");
        iPad.setProductName("Es un ipad");
        iPad.setQty(34);
        iPad.setLineTotal(455.90);

        Item samsung = new Item();
//            iPad.setName("iPad Pro");
        samsung.setPrice(70000.00);
        samsung.setItemNo("200");
        samsung.setProductName("Es un samsung");
        samsung.setQty(45);
        samsung.setLineTotal(87.18);

        /* Add Items to List */
        listItems.add(iPhone);
        listItems.add(iPad);
        listItems.add(samsung);

        /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

        
        try {
            // Inicializamos los valores
            double amount = 102.15;
            // Inicializamos los parametros a enviar
            Map parameters = new HashMap();
            parameters.put("customerName", "PARACAS");
            parameters.put("customerEmail", "rrhh@paracas.com.pe");
            parameters.put("invoiceAmount", amount);
//            JasperReport report = JasperCompileManager.compileReport(
//                    "C:\\Users\\USUARIO\\Documents\\reporte1.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(reporteFile);
//            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            JasperPrint print = JasperFillManager.fillReport(report, parameters, itemsJRBean);
            // Exporta el informe a PDF
            JasperExportManager.exportReportToPdfFile(print, reportePdf);
            //Para visualizar el pdf directamente desde java
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
