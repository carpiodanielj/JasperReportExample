/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jasperreportexample;

import java.io.File;
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
        
        exampleTable();
    }
    
    private static void exampleMain() {
        // TODO code application logic here
        
        String reporteFile = "C:\\Users\\USUARIO\\Documents\\reporte-pdp-osl.jasper";
        String reportePdf = "C:\\Users\\USUARIO\\Documents\\reporte-pdp-osl.pdf";
        
        /* List to hold Items */
        List<Item> listItems = new ArrayList<>();

        /* Create Items */
        Item iPhone = new Item();
//            iPhone.setName("iPhone 6S");
//        iPhone.setPrice(65000.00);
        iPhone.setCodigo("100");
        iPhone.setCant(23);
        iPhone.setUnid("UND");
        iPhone.setDescProducto("Es un iphone");
        iPhone.setValUnit(223.12);
        iPhone.setDscto(223.12);
        iPhone.setValVenta(223.12);

        Item iPad = new Item();
//            iPad.setName("iPad Pro");
//        iPad.setPrice(70000.00);
        iPad.setCodigo("200");
        iPad.setCant(23);
        iPad.setUnid("UND");
        iPad.setDescProducto("Es un ipad");
        iPad.setValUnit(223.12);
        iPad.setDscto(223.12);
        iPad.setValVenta(223.12);

        Item samsung = new Item();
//            iPad.setName("iPad Pro");
//        samsung.setPrice(70000.00);
        samsung.setCodigo("300");
        samsung.setCant(23);
        samsung.setUnid("UND");
        samsung.setDescProducto("Es un samsung");
        samsung.setValUnit(223.12);
        samsung.setDscto(223.12);
        samsung.setValVenta(223.12);

        /* Add Items to List */
        listItems.add(iPhone);
        listItems.add(iPad);
        listItems.add(samsung);

        /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

        
        try {
            // Inicializamos los parametros a enviar
            Map parameters = getParameters();
//            Map parameters = new HashMap();
//            parameters.put("customerName", "PARACAS");
//            parameters.put("customerEmail", "rrhh@paracas.com.pe");
//            parameters.put("invoiceAmount", amount);
//            JasperReport report = JasperCompileManager.compileReport(
//                    "C:\\Users\\USUARIO\\Documents\\reporte1.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(new File(reporteFile));
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
    
    static Map getParameters() {
        // Inicializamos los valores
        double amount = 102.15;
        // Inicializamos los parametros a enviar
        Map parameters = new HashMap();
        parameters.put("customerName", "PARACAS");
        parameters.put("customerEmail", "rrhh@paracas.com.pe");
        parameters.put("invoiceAmount", amount);
        // Datos Cliente
        parameters.put("nomCliente", "TERMINAL PORTUARIO PARACAS");
        parameters.put("rucCliente", "10451004569");
        parameters.put("direccionCliente", "AV. BENAVIDES 565");
        parameters.put("ciudadCliente", "MIRAFLORES - LIMA - LIMA");
        parameters.put("descMoneda", "SOLES");
        parameters.put("igv", "18%");
        // Datos Factura
        parameters.put("numFactura", "F001-00008567");
        parameters.put("fechaEmision", "17-Feb-2022");
        parameters.put("formaPago", "Credito");
        parameters.put("numOrdenCompra", "0010000000094855");
        parameters.put("fechaVencimiento", "02-Abr-2022");
        parameters.put("numGuiaRemision", "");
        // Datos Proveedor
        parameters.put("nomProveedor", "INTERNATIONAL PRIVATE SECURITY");
        parameters.put("rucProveedor", "10456798355");
        parameters.put("direccionProveedor", "CALLE RODOLFO BELTRAN");
        parameters.put("ciudadProveedor", "COMAS - LIMA - LIMA");
        return parameters;
    }
    
    private static void exampleTable() {
        
        String reporteFile = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\JasperReportExample\\src\\jasperreportexample\\templates\\report1.jasper";
        String reportePdf = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\JasperReportExample\\src\\jasperreportexample\\templates\\report1.pdf";
                
        /* List to hold Items */
        List<Article> listItems = new ArrayList<>();

        Article samsung = new Article();
        samsung.setName("iPad Pro");
        samsung.setCodigo("300");

        /* Add Items to List */
        listItems.add(samsung);
        for (int i = 0; i < 100; i++) {
            listItems.add(samsung);  
        }

        /* Convert List to JRBeanCollectionDataSource */
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);
        
        try {
            // Inicializamos los parametros a enviar
//            Map parameters = getParameters();
            Map parameters = new HashMap();
            parameters.put("myDataSource", itemsJRBean);
//            parameters.put("customerEmail", "rrhh@paracas.com.pe");
//            parameters.put("invoiceAmount", amount);
//            JasperReport report = JasperCompileManager.compileReport(
//                    "C:\\Users\\USUARIO\\Documents\\reporte1.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(new File(reporteFile));
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
//            JasperPrint print = JasperFillManager.fillReport(report, parameters, itemsJRBean);
            // Exporta el informe a PDF
            JasperExportManager.exportReportToPdfFile(print, reportePdf);
            //Para visualizar el pdf directamente desde java
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
