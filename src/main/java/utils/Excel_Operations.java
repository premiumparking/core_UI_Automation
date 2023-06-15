package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.poiji.bind.Poiji;

import dataModel.Admiral.Citation;
import dataModel.OD.Profile_Bulk;
import dataModel.OD.PromoCode_Bulk;
import reports.Extent_Reports;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Class is to handle the Excel operations i.e. getting test data from excel and binding to Java object
 * 
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class Excel_Operations extends Extent_Reports {

	/*
	 * This method is to load the excel sheet and it binds to Profiles object and
	 * returns list of profiles
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	public List<Profile_Bulk> load_ProfilesData_From_ExcelSheet(String fileName, String sheetName) {
		try {
			//File file = new File("\\src\\test\\java\\testData\\OD\\" + fileName);
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\WestHavenPlatelist.xlsx");
			//File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\OD"+fileName);
			
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			List<Profile_Bulk> profiles = Poiji.fromExcel(sheet, Profile_Bulk.class);
			return profiles;
		} catch (Exception e) {
			failStep(e.getMessage());
			return null;
		}
	}

	/*
	 * This method is to get the number of sheets from excel sheet
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	public List<String> get_Total_Sheets(String fileName) {
		try {
			List<String> sheets = new ArrayList<String>();
			File file = new File(System.getProperty("user.dir") + "//src//test//resources//" + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));

			int no_of_Sheets = workbook.getNumberOfSheets();

			for (int i = 0; i < no_of_Sheets; i++) {
				sheets.add(workbook.getSheetName(i));
			}
			return sheets;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * This method is to load the excel sheet and it binds to Citation object and
	 * returns list of citations
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	public List<Citation> load_CitationData_From_ExcelSheet(String fileName, String sheetName) {
		try {
			File file = new File(System.getProperty("user.dir") + "//src//test//java//testData//OD//" + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			List<Citation> citations = Poiji.fromExcel(sheet, Citation.class);
			return citations;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * This method is to load the excel sheet and it binds to PromoCode_Bulk object
	 * and returns list of citations
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	public List<PromoCode_Bulk> load_BulkPromoCodes_From_ExcelSheet(String fileName, String sheetName) {
		try {
			File file = new File(System.getProperty("user.dir") + "//src//test//java//testData//OD//" + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			List<PromoCode_Bulk> promoCodes = Poiji.fromExcel(sheet, PromoCode_Bulk.class);
			return promoCodes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
