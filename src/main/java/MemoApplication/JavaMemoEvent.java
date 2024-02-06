package MemoApplication;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class JavaMemoEvent extends WindowAdapter implements ActionListener {
    private JavaMemoDesign javaMemoDesign;

    public JavaMemoEvent(JavaMemoDesign javaMemoDesign) {
        this.javaMemoDesign = javaMemoDesign;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "새글":
                newPost();
                break;
            case "열기":
                openPost();
                break;
            case "저장":
                savePost();
                break;
            case "다른 이름으로 저장":
                savePostDialog();
                break;
            case "종료":
                exitProgram();
                break;
            case "글꼴":
                openMemoFontDialog();
                break;
            case "메모장 정보":
                openMemoHelpDialog();
                break;
        }
    }

    public void newPost() {
        File tempFile = new File(getFilePath());
        if (tempFile.exists()) {
            try {
                FileReader fReader = new FileReader(tempFile);
                BufferedReader bufReader = new BufferedReader(fReader);

                String str = "";
                StringBuilder strBuilder = new StringBuilder();

                while ((str = bufReader.readLine()) != null) {
                    strBuilder.append(str + "\n");
                }

                if (!strBuilder.substring(0, strBuilder.length() - 1).equals(javaMemoDesign.getMemoArea().getText())) {
                    if (JOptionPane.showConfirmDialog(null, "파일을 저장하시겠습니까?") == JOptionPane.OK_OPTION) {
                        savePostDialog();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (javaMemoDesign.getMemoArea().getText().length() != 0) {
                savePostDialog();
            }
        }
        javaMemoDesign.getMemoArea().setText("");
        javaMemoDesign.setTitle("메모장-새글");
    }

    public void openPost() {
        File tempFile = new File(getFilePath());

        if (tempFile.exists()) {
            try {
                FileReader fReader = new FileReader(tempFile);
                BufferedReader bufReader = new BufferedReader(fReader);

                String str = "";
                StringBuilder strBuilder = new StringBuilder();

                while ((str = bufReader.readLine()) != null) {
                    strBuilder.append(str + "\n");
                }

                if (!strBuilder.substring(0, strBuilder.length() - 1).equals(javaMemoDesign.getMemoArea().getText())) {
                    if (JOptionPane.showConfirmDialog(null, "파일을 저장하시겠습니까?") == JOptionPane.OK_OPTION) {
                        savePostDialog();
                    }
                }
                fReader.close();
                bufReader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (javaMemoDesign.getMemoArea().getText().length() != 0) {
                savePostDialog();
            }
        }

        FileDialog fdOpen = new FileDialog(javaMemoDesign, "열기", FileDialog.LOAD);
        fdOpen.setVisible(true);
        File newFile = new File(fdOpen.getDirectory() + fdOpen.getFile());

        try {
            FileReader fReader = new FileReader(newFile);
            BufferedReader bufReader = new BufferedReader(fReader);

            String str = "";
            StringBuilder strBuilder = new StringBuilder();

            while ((str = bufReader.readLine()) != null) {
                strBuilder.append(str);
            }

            javaMemoDesign.setTitle(newFile.getCanonicalPath());
            javaMemoDesign.getMemoArea().setText(strBuilder.toString());

            fReader.close();
            bufReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setFrameTitle(fdOpen, "열기");
    }

    public String getFilePath() {
        String[] title = javaMemoDesign.getTitle().split(" ");

        if (title.length == 1) {
            return "";
        }

        return title[1];
    }

    public void savePost() {
        File tempFile = new File(getFilePath());

        if (tempFile.exists()) {
            try {
                FileWriter fWriter = new FileWriter(tempFile);
                fWriter.write(javaMemoDesign.getMemoArea().getText());
                fWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            savePostDialog();
        }
    }

    public void savePostDialog() {
        FileDialog fdOpen = new FileDialog(javaMemoDesign, "저장", FileDialog.SAVE);
        fdOpen.setVisible(true);

        File newFile = new File(fdOpen.getDirectory() + fdOpen.getFile());
        try {
            FileWriter fWriter = new FileWriter(newFile);
            fWriter.write(javaMemoDesign.getMemoArea().getText());
            fWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setFrameTitle(fdOpen, "저장");
    }

    public void setFrameTitle(FileDialog fdOpen, String mode) {
        StringBuilder strBuilder = new StringBuilder();

        String path = fdOpen.getDirectory();

        if (path == null) {
            return;
        }

        strBuilder.append(mode).append(" ").append(path).append(fdOpen.getFile());
        javaMemoDesign.setTitle(strBuilder.toString());
    }

    public void exitProgram() {
        File fontInfo = new File("./font.txt");
        Font tempFont = javaMemoDesign.getMemoArea().getFont();
        try {
            FileWriter fWriter = new FileWriter(fontInfo);
            fWriter.write(tempFont.getFontName() + " ");
            fWriter.write(tempFont.getStyle() + " ");
            fWriter.write(tempFont.getSize() + " ");
            fWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        javaMemoDesign.dispose();
    }

    public void openMemoFontDialog() {
        new MenuFontDesign(javaMemoDesign);
    }

    public void openMemoHelpDialog() {
        new MemoHelpDesign(javaMemoDesign);
    }
}
