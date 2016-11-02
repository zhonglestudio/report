package com.jasreport.jrxml;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.jasreport.web.BaseAction;
  
public class HelloJasperReportAction extends BaseAction {  
  
	private static final long serialVersionUID = 1L;

	/** 
     * @param args 
     * @throws Exception 
     */  
    public void excute() throws Exception {  
        JasperReport jasperReport;  
        JasperPrint jasperPrint; 
        File file = null;
        FileInputStream in = null;
        try {  
//        	in =new FileInputStream(HelloJasperReportAction.class.getResource("/").getFile()+"jrxml/HelloJasperReport.jrxml");
        	
            jasperReport = JasperCompileManager.compileReport(this.getClass().getClassLoader().getResource("document/HelloJasperReport.jrxml").getPath());  
            jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());  
            JasperExportManager.exportReportToPdfFile(jasperPrint, "HelloJasperReport.pdf");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    	
//    	getResponse().sendRedirect(getRequest().getContetPath()+"/jsp/MyJsp.jsp");
//        System.out.println(this.getClass().getResource(".").getPath());
        System.out.println(this.getClass().getClassLoader().getResource("document/HelloJasperReport.jrxml").getPath());
    }  
  
}  