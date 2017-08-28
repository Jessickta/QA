package Bench_Project.PHP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.*;

public class Testing {
	
	boolean score;
	
	@Test
	public void read() throws IOException {
	
		File file = new File("/Users/Jessica/Documents/workspace/PHP/src/test/java/Bench_Project/PHP/Test.xlsx");

		FileInputStream stream = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(stream);
		XSSFSheet sheet1 = book.getSheetAt(0);
		
		System.out.println(sheet1.getRow(1).getCell(0).getStringCellValue());
		System.out.println(sheet1.getRow(1).getCell(1).getNumericCellValue());
		
		double score1 = (sheet1.getRow(1).getCell(1).getNumericCellValue());
		double score2 = (sheet1.getRow(2).getCell(1).getNumericCellValue());
		double score3 = (sheet1.getRow(3).getCell(1).getNumericCellValue());
		double score4 = (sheet1.getRow(4).getCell(1).getNumericCellValue());
		double score5 = (sheet1.getRow(5).getCell(1).getNumericCellValue());

		double[] scores = {score1, score2, score3, score4, score5};
		
		for (int i=0; i<scores.length; i++) {
			score = scores[i]>=35;
			System.out.println(scores[i]);
			
			sheet1.getRow(i+1).createCell(3).setCellValue(score);
		}
		
		System.out.println(score);
		
		sheet1.getRow(0).createCell(3).setCellValue("Pass?");
		
		FileOutputStream out = new FileOutputStream(file);
		
		book.write(out);
		out.close();
		stream.close();
		book.close();
		
	}
}
