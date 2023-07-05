import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    public void createExcel(List<User> users, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Usuarios");

        // Crear la fila de encabezado
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nombre");
        headerRow.createCell(1).setCellValue("Correo");
        headerRow.createCell(2).setCellValue("Fecha de Nacimiento");

        // Agregar los datos de los usuarios
        int rowNum = 1;
        for (User user : users) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getEmail());
            row.createCell(2).setCellValue(user.getBirthday());
        }

        // Ajustar el ancho de las columnas
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Guardar el archivo de Excel
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
}
