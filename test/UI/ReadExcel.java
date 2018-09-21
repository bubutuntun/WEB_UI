package UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		File excelFile=new File("c:/a.xls");
		FileInputStream in=new FileInputStream(excelFile);
		Workbook wb= new HSSFWorkbook(in);
		Sheet sheet=wb.getSheetAt(0);
		/*Row row=sheet.getRow(0);
		System.out.println(row);
		
		Cell cell=row.getCell(0);
		System.out.println(cell.getCellTypeEnum());
		System.out.println(cell.getCellType());
		System.out.println(cell.getRowIndex());
		System.out.println(cell.getNumericCellValue());*/
		
		
		for(int i=0;i<5;i++)
			{
				Row row=sheet.getRow(i);
				for(int j=0;j<5;j++)
					{
						Cell cell=row.getCell(j);
						String cellValue = null;
						switch (cell.getCellType())
						{  
					        case Cell.CELL_TYPE_STRING:     // 文本  
					            cellValue = cell.getRichStringCellValue().getString();  
					            break;  
					       /* case Cell.CELL_TYPE_NUMERIC:    // 数字、日期  
					            if (DateUtil.isCellDateFormatted(cell)) {  
					                cellValue = fmt.format(cell.getDateCellValue());  
					            } else {  
					                cell.setCellType(Cell.CELL_TYPE_STRING);  
					                cellValue = String.valueOf(cell.getRichStringCellValue().getString());  
					            }  
					            break;  */
					        case Cell.CELL_TYPE_BOOLEAN:    // 布尔型  
					            cellValue = String.valueOf(cell.getBooleanCellValue());  
					            break;  
					        case Cell.CELL_TYPE_BLANK: // 空白  
					            cellValue = cell.getStringCellValue();  
					            break;  
					        case Cell.CELL_TYPE_ERROR: // 错误  
					            cellValue = "错误";  
					            break;  
					        case Cell.CELL_TYPE_FORMULA:    // 公式  
					            // 得到对应单元格的公式  
					            //cellValue = cell.getCellFormula() + "#";  
					            // 得到对应单元格的字符串  
					            cell.setCellType(Cell.CELL_TYPE_STRING);  
					            cellValue = String.valueOf(cell.getRichStringCellValue().getString());  
					            break;  
					        default:  
					           break;
				
				
						}
		
							System.out.println(cellValue);
					}
			}
		
	}
}