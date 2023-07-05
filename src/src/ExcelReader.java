import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public List<User> readExcel(String filePath) throws IOException {
        List<User> users = new ArrayList<>();

        File f = new File(filePath);
        InputStream inp = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);

        /*FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);*/

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String name = row.getCell(0).getStringCellValue();
            String email = row.getCell(1).getStringCellValue();
            String birthday = row.getCell(2).getStringCellValue();

            users.add(new User(name, email, birthday));
        }

        wb.close();
        inp.close();

        return users;
    }


}
