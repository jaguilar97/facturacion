package com.Facturacion.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class CategoriaReportService {
    
    private String reportPath;

    public String generateReport() {
        try {
            File file = ResourceUtils.getFile("classpath:ListadoCategorias.jasper");
            reportPath = file.getParent();
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            Map<String, Object> parameters = new HashMap<>();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/facturacion", "usuario", "clave");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\ListadoCategorias.pdf");
            return reportPath + "\\ListadoCategorias.pdf";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
