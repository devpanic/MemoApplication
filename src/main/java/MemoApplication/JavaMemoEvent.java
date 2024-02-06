package MemoApplication;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

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
        javaMemoDesign.getMemoArea().setText("");
    }

    public void openPost() {
        FileDialog fdOpen = new FileDialog(javaMemoDesign, "열기", FileDialog.LOAD);

        fdOpen.setVisible(true);
        setFrameTitle(fdOpen, "열기");
    }

    public void savePost() {
        FileDialog fdOpen = new FileDialog(javaMemoDesign, "저장", FileDialog.SAVE);
        fdOpen.setVisible(true);

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
