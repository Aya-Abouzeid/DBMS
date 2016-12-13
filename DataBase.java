package eg.edu.alexu.csd.oop.DBMS;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.crypto.CipherInputStream;

import org.apache.commons.io.FileUtils;

public class DataBase {
	private String databasepath = "";
	private String writerType ="";
	protected ITable writer= null;
	public  DataBase() {
		
	}
	public  DataBase( String databasepath,String writerType ) {
		this.databasepath = databasepath;
		this.writerType = writerType;
		if ( writerType.equals("xmldb")){
			writer = new XmlTable();
		}else if (writerType.equals("jsondb")){
			writer= new JsonTable();
			
		}
	}
	public  DataBase(String writerType) {
		this.writerType = writerType;
		if ( writerType.equals("xmldb")){
			writer = new XmlTable();
		}else if (writerType.equals("jsondb")){
			writer= new JsonTable();
			
		}
	}
	public void creatTable(String databaseName, String tableName, String[] properties) {
		// TODO Auto-generated method stub                                                   
		
		writer.creatTable(databaseName, tableName, properties);
	}


	public int insertRow(String databaseName, String tableName, String[] properties) {
		// TODO Auto-generated method stub
		return writer.insertRow(databaseName, tableName, properties);
		
		
	}

	
	public int update(String databaseName, String tableName, String[] condition, String[] updateStatment) {
		// TODO Auto-generated method stub
		return writer.update(databaseName, tableName, condition, updateStatment);
		
	}

	
	public int updateWhitoutWhere(String databaseName, String tableName, String[] updateStatment) {
		// TODO Auto-generated method stub
		return writer.updateWhitoutWhere(databaseName, tableName, updateStatment);
		
	}


	public int insertSub(String databaseName, String tableName, String[] columSend, String[] properties) {
		// TODO Auto-generated method stub

		return writer.insertSub(databaseName, tableName, columSend, properties);
		
	}


	public int deleteTable(String databaseName, String tableName) {
		// TODO Auto-generated method stub
		return writer.deleteTable(databaseName, tableName);
	
	}


	public int deleteSubTable(String databaseName, String tableName, String[] condition) {
		// TODO Auto-generated method stub
		return writer.deleteSubTable(databaseName, tableName, condition);
	
		
	}


	public String[][] selectColumnsWithCondition(String databaseName, String tableName, String[] columntitles,
			String[] Condition) {
		// TODO Auto-generated method stub;
		return writer.selectColumnsWithCondition(databaseName, tableName, columntitles, Condition);
		
	}


	public String[][] selectColumns(String databaseName, String tableName, String[] columntitles) {
		// TODO Auto-generated method stub
	  return writer.selectColumns(databaseName, tableName, columntitles);
	}

	
	public String[][] selectAllColumns(String databaseName, String tableName) {
		// TODO Auto-generated method stub
		return  writer.selectAllColumns(databaseName, tableName);
	}

	
	public String[][] selectAllWithCondition(String databaseName, String tableName, String[] Condition) {
		// TODO Auto-generated method stub
		return  writer.selectAllWithCondition(databaseName, tableName, Condition);
	}

	
	public void dropTable(String databaseName, String tableName) {
		// TODO Auto-generated method stub
		writer.dropTable(databaseName, tableName);
	}

	
	public void CreateDtDFile(String databaseName, String tableName, String[] dtd, String[] type) {
		// TODO Auto-generated method stub
		//dtdObject.CreateDtDFile(databaseName, tableName, dtd, type);	                 monaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	}

	
    
	public int addAlter(String databaseName, String tableName ,String type,String columName) {
		return writer.addAlter(databaseName, tableName, type, columName);
		
	}
    public int deleteAlter(String databaseName, String tableName ,String columName) {
		return writer.deleteAlter(databaseName, tableName, columName);
    	
    }
    public String[][] distinct(String databaseName, String tableName ,String[] columsName) {
		return writer.distinct(databaseName, tableName, columsName);
	}
	protected void ListTables(String DataBase){
	   	 File tables = new File(System.getProperty("user.home") + File.separator + DataBase);
	   String[] x =tables.list();	
	   for(int i =0; i<x.length;i++ ){
      	System.out.println(x[i]);

	   }
		
	}
}