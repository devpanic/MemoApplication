package MemoApplication;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
                saveWithOtherName();
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
        File tempFile = new File(javaMemoDesign.getTitle());
        if (tempFile.exists()) {    // 열려있는 상태
            // 두 파일 내용 비교
            try {
                FileReader fileReader = new FileReader(tempFile);
                BufferedReader bufReader = new BufferedReader(fileReader);
                String str = "";
                StringBuilder strBuilder = new StringBuilder();

                while ((str = bufReader.readLine()) != null) {
                    strBuilder.append(str);
                }

                if (!strBuilder.equals(javaMemoDesign.getMemoArea().getText())) {
                    savePost();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else { // 새로운 글인 경우
            if (javaMemoDesign.getMemoArea().getText().length() != 0) {
                // 새로운 파일에 저장
                savePost();
            }
        }
        javaMemoDesign.getMemoArea().setText("");
        javaMemoDesign.setTitle("메모장-새글");
    }

    public void openPost() {
        FileDialog fdOpen = new FileDialog(javaMemoDesign, "열기", FileDialog.LOAD);

        fdOpen.setVisible(true);
        setFrameTitle(fdOpen, "열기");
    }

    public void savePost() {
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

    public void saveWithOtherName() {

    }

    public void setFrameTitle(FileDialog fdOpen, String mode) {
        StringBuilder strBuilder = new StringBuilder();

        String path = fdOpen.getDirectory();

        if (path == null) {
            return;
        }

        strBuilder.append(mode).append(" ").append(path).append("/").append(fdOpen.getFile());
        javaMemoDesign.setTitle(strBuilder.toString());
    }

    public void exitProgram() {
        javaMemoDesign.dispose();
    }

    public void openMemoFontDialog() {
        new MenuFontDesign(javaMemoDesign);
    }

    public void openMemoHelpDialog() {
        new MemoHelpDesign(javaMemoDesign);
    }
}
