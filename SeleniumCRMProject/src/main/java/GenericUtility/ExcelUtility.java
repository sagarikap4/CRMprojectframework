package GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * Method is used to get sheetname,row,col
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Exception
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Exception
	{
		
		FileInputStream fis1=new FileInputStream("./SeleniumCRMProject/ExcelFile/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheetname = wb.getSheet(sheetName);
		String data=sheetname.getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;	
	}
	/**
	 * Method is used to get last roe in the sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowcount(String sheetName) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./SeleniumCRMProject/ExcelFile/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheetname = wb.getSheet(sheetName);
		int rowNum = sheetname.getLastRowNum();
		wb.close();
		return rowNum;	
	}
	/**
	 * Method is used to write data in the sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./SeleniumCRMProject/ExcelFile/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetname = wb.getSheet(sheetName);
	    sheetname.getRow(rowNum).createCell(celNum);
	    
	    FileOutputStream fos=new  FileOutputStream("./AppTestData/TestDataVtigerApp.xlsx");
	    wb.write(fos);
	    wb.close();
	    
	}

}
