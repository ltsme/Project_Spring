package com.watchdogs.command.review;


import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.ReviewDao;
import com.watchdogs.dto.ReviewDto;

public class ReviewModifyCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		System.out.println("ReviewModifyCommand 완료");
//		Map<String, Object> map = model.asMap();//map : 포장지  // form/action 
//		//getParameter를 포장한 하나의 보안장치 jsp -> asmap -> request를 풀어야지 .....
//		HttpServletRequest request = (HttpServletRequest) map.get("request"); // 이때부터 getParameter 쓸 수 있음
		
		Map<String, Object> map = model.asMap();//map : 포장지  // form/action 
		//getParameter를 포장한 하나의 보안장치 jsp -> asmap -> request를 풀어야지 .....
		MultipartHttpServletRequest multirequest = (MultipartHttpServletRequest) map.get("multirequest"); // 이때부터 getParameter 쓸 수 있음
		
		// 업로드 되는 저장 위치를 잡아주는것 !
		String root_path = httpSession.getServletContext().getRealPath("/");
		String attach_path = "resources/review/";
		String uploadPath = root_path + attach_path;
		// * * * * * * * * * * * * * * 
		
		// 업로드 위치에 폴더가 없으면 만들어주기 !
		if(! new File(uploadPath).exists()) {
			new File(uploadPath).mkdirs();
		}
		
		String saveFilename = null;
	
		MultipartFile mf = multirequest.getFile("uploadFile");
		
		// 첨부하는 이미지파일의 원래 파일명 
		String originFileName = mf.getOriginalFilename();
		// 첨부하는 이미지파일의 크기 가져오기
		long fileSize = mf.getSize();
		
		// file upload check
        if(fileSize != 0) {
	        saveFilename = System.currentTimeMillis() + originFileName; // 저장될 파일명
	        String saveFile = uploadPath + saveFilename;
	        
	        try {
	        	mf.transferTo(new File(saveFile));
	        }catch (IllegalStateException e) {
	        	e.printStackTrace();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	        
        } else {
        	saveFilename = multirequest.getParameter("oldFilePath");
        }
		
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		dao.review_modify(Integer.parseInt(multirequest.getParameter("reid")), 
										   multirequest.getParameter("retitle"), 
										   multirequest.getParameter("recontent"), 
										   saveFilename);
	
		
		
		
		
		
		
		
		
	}//execute

	
	
	
		
		
		

//		/*/
//		 * 2021.05.18 권효은
//		 * 후기 수정 
//		 * 수정을 위해 입력되어있는 값 가져오기
//		 */
//		//input tag에 있는 값들을 받아오기 -->이미지로 불러올려면 multipart 사용
//		
//		/*/
//		 * 2021.05.23 권효은
//		 * 이미지 수정
//		 */
//		
//		//세션을 이용해 파일패스를 받고 저장
//		HttpSession session = request.getSession();
//	    String path = request.getSession().getServletContext().getRealPath("review"); 
//	    System.out.println(path);
//	    System.out.println("Modify img path 받기 완료");
//	    
//	    int size = 1024 * 1024 * 10; // 업로드 할 최대 파일 크기 (몇 메가바이트까지인지)
//	    String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
//	    String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름 (옛날께 이름바꿨다고 삭제 되지 않게)
//
//	    // 실제 파일 업로드하는 과정
//	    try{
//	        MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
//			//실제 path, max size, defaulFileRenamePolicy : 오리지날파일 어떻게 하겠느냐 : 파일뒤에 1,2 3 붙음 (덮어씌우기 방지 )
//			//String doc
//			String retitle = multi.getParameter("retitle");
//			String recontent = multi.getParameter("recontent");
//			String reid = multi.getParameter("reid") ;
//
//			
//			
//		
//			Enumeration<String> files = multi.getFileNames();
//			String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장 str = file
//			file = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴->요거만 있어도 될듯?
//			originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴
//			session.setAttribute("filepath", file); // name을 session에 저장
//			System.out.println("detailView&수정전img 불러오기 성공");
//			
//			//Dao 연결
//			ReviewDao dao = new ReviewDao();
//			//2줄추가 다시 정보 불러오기
//			ReviewDto dto = dao.reviewDetail(reid);	
//			request.setAttribute("reviewdetail", dto);
//			//파일 이름 가져오기
//			
//			//dao로 정보 다 보내서 write실행
//			dao.reviewModify(reid, retitle, recontent, file);
//			
//
//	        
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    
//		
//		
//		
//		
//		
	

}//end
