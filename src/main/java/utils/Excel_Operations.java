package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import com.poiji.bind.Poiji;

import dataModel.Admiral.Citation;
import dataModel.OD.Profile;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Class is to handle the Excel operations i.e. getting test data from excel and binding to Java object
 * 
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class Excel_Operations {

	/*
	 * This method is to load the excel sheet and it binds to Profiles object and
	 * returns list of profiles
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	public List<Profile> load_ProfilesData_From_ExcelSheet(String fileName, String sheetName) {
		try {
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\testData\\OD\\" + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			List<Profile> profiles = Poiji.fromExcel(sheet, Profile.class);
			return profiles;
		} catch (Exception e) {
			e.printStackTrace();
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
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName);
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
			File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\testData\\OD\\" + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			List<Citation> citations = Poiji.fromExcel(sheet, Citation.class);
			return citations;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
