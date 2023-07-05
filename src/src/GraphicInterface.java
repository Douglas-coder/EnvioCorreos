import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class GraphicInterface {

    private JFrame frame;
    private JButton btnSelectFile;

    public GraphicInterface() {
        frame = new JFrame("Excel Reader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        btnSelectFile = new JButton("Seleccionar archivo");
        btnSelectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    ExcelReader excelReader = new ExcelReader();
                    try {
                        // Leer el archivo de Excel y obtener los usuarios
                        List<User> users = excelReader.readExcel(filePath);
                        List<User> birthays = excelReader.readExcel(filePath);

                        // Procesar los usuarios obtenidos
                        UserProcessor userProcessor = new UserProcessor();
                        userProcessor.processUser(users, birthays);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.add(btnSelectFile, BorderLayout.CENTER);
    }

    public void start() {
        frame.setVisible(true);
    }


}
