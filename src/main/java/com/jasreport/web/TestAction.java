package com.jasreport.web;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jasreport.domain.JavaBeanPerson;

public class TestAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4566903014123125802L;

	
	public void getSome(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("result", "123231");
		map.put("result1", "11111");
		resultSuccess(map);
	}
	
    /** 
     * 返回iReport报表视图 
     * @param model 
     * @return 
     */  
//    @RequestMapping(value = "/report", method = RequestMethod.GET)  
    public String report(Model model) {  
        // 报表数据源  
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(JavaBeanPerson.getList());  
              
        // 动态指定报表模板url  
        model.addAttribute("url", "/WEB-INF/classes/jasper/report3.jasper");  
        model.addAttribute("format", "pdf"); // 报表格式  
        model.addAttribute("jrMainDataSource", jrDataSource);  
              
        return "iReportView"; // 对应jasper-defs.xml中的bean id  
    }  
	/**
	 * 功能：公共方法用于响应前台请求
	 * 
	 * @param response
	 * @param data
	 */
	private void printData(HttpServletResponse response, String data) {
		try {
			// System.out.println(data);
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));
			out.println(data);
			out.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
