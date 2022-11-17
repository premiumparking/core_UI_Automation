package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import com.poiji.bind.Poiji;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dataModel.Profile;

/*
 * Class is to handle the Excel operations i.e. getting test data from excel and binding to Java object
 * 
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class Excel_Operations {

	/*
	 * This method is to load the excel sheet
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void loadExcelData1() {
		try {
			File file = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\AnnapolisResidentPermits_2022_2023.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheet("Original");
			XSSFRow row = sheet.getRow(1);
			System.out.println("***********************");
			System.out.println(row.getCell(0));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method is to load the excel sheet and it binds to Profiles object and
	 * returns list of profiles
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	public List<Profile> load_ProfilesData_From_ExcelSheet(String filename) {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename);
		List<Profile> profiles = Poiji.fromExcel(file, Profile.class);
		return profiles;

	}

}
