package com.watchdogs.command.adopt;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.BDaoAdopt;

public class BAdoptimginsertcommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model,HttpSession httpSessionl) {
		// TODO Auto-generated method stub
	
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("adoptcomplete");
		
		HttpSession session = request.getSession();
		
		String path = request.getSession().getServletContext().getRealPath("dog");	
	    System.out.println(path);
	    
	    System.out.println("fileFolder 접근완료");
	    
	    int size = 1024*1024*10;
	    
	    String file = "";
	    String originalFile= "";
	    
//	    try {
//	    	MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
//	    	String dogname = multi.getParameter("dogname");
//	    	String dogmf = multi.getParameter("dogmf");
//	    	String dogage = multi.getParameter("dogage");
//	    	String dogtype = multi.getParameter("dogtype");
//	    	String dogtraincomm = multi.getParameter("dogtraincomm");
//	    	String dogadopttst = multi.getParameter("dogadoptst");
//	    	System.out.println("인서트 커맨드 성공 ");
//	    
//	    	BDaoAdopt dao = new BDaoAdopt();
//	    	
//	    	Enumeration<String> files = multi.getFileNames();
//	    	String str = (String)files.nextElement();
//	    	file = multi.getFilesystemName(str);
//	    	originalFile = multi.getOriginalFileName(str);
//	    	
//	    	session.setAttribute("filepath", file);
//	    	
//	    	dao.dogimginsert(dogname, dogmf, dogage,dogtype, dogtraincomm,dogadopttst,file);
//	       
//	    
//	    
//	    }catch(Exception e) {
//	    	e.printStackTrace();
//	    }
	    
	}

}
