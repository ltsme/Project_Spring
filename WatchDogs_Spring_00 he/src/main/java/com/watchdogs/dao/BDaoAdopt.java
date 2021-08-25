package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.BDtoAdopt;

public interface BDaoAdopt {

//.............................................adoptwait 시작 부분
public ArrayList<BDtoAdopt>adoptwait(int startRow, int endRow);

public ArrayList<BDtoAdopt>adoptwait_02(int strid);

public void adoptapply(String dogid);

//.............................................adoptproceeding 시작 부분
public ArrayList<BDtoAdopt> adoptproceeding(int startRow, int endRow);

public ArrayList<BDtoAdopt>adoptproceeding_02(int strid);

//.............................................adoptcomplete 시작 부분
public ArrayList<BDtoAdopt> adoptcomplete(int startRow, int endRow);

public ArrayList<BDtoAdopt>adoptcomplete_02(int strid);

//.............................................adopttraining 시작 부분
public ArrayList<BDtoAdopt> adopttraining(int startRow, int endRow); 

public ArrayList<BDtoAdopt>adopttraining_02(int strid);

//.............................................게시물 카운트 시작 부분
public int getcount(String adoptst);


//.............................................검색 시작 부분
public ArrayList<BDtoAdopt> adoptsearch(String search,String searchtype,String dogadoptst);

public int searchcount(String search, String searchtype, String dogadoptst) ;


//public int getcount(String adoptst) { //일반카테고리 카운트
//
//System.out.println("맥스를 구하기위한 테스트입니다");
//
//Connection connection = null;
//PreparedStatement preparedStatement = null;
//ResultSet resultSet = null;
//
//int count = 0;   
//
//try {
//connection = dataSource.getConnection();
//
//String sql = "select count(*) from dog where dogadoptst like '"+adoptst+"';"; 
//
//
//preparedStatement = connection.prepareStatement(sql);
//resultSet = preparedStatement.executeQuery();
//
//if(resultSet.next()){
//	count = resultSet.getInt(1);
//}
//System.out.println(count +"이거는 숫자입니다");
//
//}catch(Exception e) {
//e.printStackTrace();
// 
//}finally {
//
//try {
//	  
//if(resultSet !=null) resultSet.close();
//if(preparedStatement !=null) resultSet.close();
//if(connection !=null) resultSet.close();
//connection.close();
//  
//}catch(Exception e) {
//e.printStackTrace();
//   
//}
//}
//return count;
//}       
//   /////////////////////////////////////////////////////////////////////////////////////
//public int searchcount(String search, String searchtype, String dogadoptst) { //일반카테고리 카운트
//
//System.out.println("맥스를 구하기위한 테스트입니다");
//
//Connection connection = null;
//PreparedStatement preparedStatement = null;
//ResultSet resultSet = null;
//
//int count = 0;   
//
//try {
//connection = dataSource.getConnection();
//
//String sql = "select count(*) from dog where "+searchtype+" like '%"+search +"%' and dogadoptst like '%"+dogadoptst+"%';";
//
//preparedStatement = connection.prepareStatement(sql);
//resultSet = preparedStatement.executeQuery();
//
//if(resultSet.next()){
//	count = resultSet.getInt(1);
//}
//System.out.println(count +"이거는 숫자입니다");
//
//}catch(Exception e) {
//e.printStackTrace();
// 
//}finally {
//
//try {
//	  
//if(resultSet !=null) resultSet.close();
//if(preparedStatement !=null) resultSet.close();
//if(connection !=null) resultSet.close();
//connection.close();
//  
//}catch(Exception e) {
//e.printStackTrace();
//   
//}
//}
//return count;
//}       
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //.....................................................adoptpage 끝부분 부분
   
   
   
   
   
   
}  // ........................................클라스 끝부분
        
