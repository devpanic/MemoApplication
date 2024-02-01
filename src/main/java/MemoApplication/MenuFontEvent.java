package MemoApplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JList;
import javax.swing.JTextField;

public class MenuFontEvent extends WindowAdapter implements ActionListener, MouseListener {
    private MenuFontDesign fontDesign;

    public MenuFontEvent(MenuFontDesign fontDesign) {
        this.fontDesign = fontDesign;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        closeFontDialog();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fontInfoKind = "";
        int fontInfoSize = 0;
        int fontInfoStyle = 0;

        switch (e.getActionCommand()) {
            case "확인":
                fontInfoKind = fontDesign.getKindField().getText();
                fontInfoStyle = checkFontStyle(fontDesign.getStyleField().getText());
                fontInfoSize = Integer.parseInt(fontDesign.getSizeField().getText());
                applyFont(fontInfoKind, fontInfoStyle, fontInfoSize);
        }

        closeFontDialog();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String tempStr = "";
        int tempInt = 0;
        JList<String> kindList = fontDesign.getKindList();
        JList<String> styleList = fontDesign.getStyleList();
        JList<String> sizeList = fontDesign.getSizeList();
        Object eventSource = e.getSource();

        if (eventSource == kindList) {
            applyFieldContent(fontDesign.getKindField(), kindList.getSelectedValue());
            applyPreviewFont(tempStr, MenuFontDesign.DEFAULT_FONT_STYLE, MenuFontDesign.DEFAULT_FONT_SIZE);
        } else if (eventSource == styleList) {
            applyFieldContent(fontDesign.getStyleField(), styleList.getSelectedValue());
            tempInt = checkFontStyle(styleList.getSelectedValue());
            applyPreviewFont(MenuFontDesign.DEFAULT_FONT_KIND, tempInt, MenuFontDesign.DEFAULT_FONT_SIZE);
        } else if (eventSource == sizeList) {
            applyFieldContent(fontDesign.getSizeField(), sizeList.getSelectedValue());
            applyPreviewFont(MenuFontDesign.DEFAULT_FONT_KIND, MenuFontDesign.DEFAULT_FONT_STYLE,
                    Integer.parseInt(tempStr));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int checkFontStyle(String fontStyle) {
        switch (fontStyle) {
            case "일반":
                return Font.PLAIN;
            case "굵게":
                return MenuFontDesign.DEFAULT_FONT_STYLE;
            case "기울임꼴":
                return Font.ITALIC;
            default:    // case "굵은 기울임꼴"
                return MenuFontDesign.DEFAULT_FONT_STYLE | Font.ITALIC;
        }
    }

    public void applyFieldContent(JTextField textField, String content) {
        textField.setText(content);
    }

    public void applyPreviewFont(String fontKind, int fontStyle, int fontSize) {
        fontDesign.getPreviewLabel().setFont(new Font(fontKind, fontStyle, fontSize));
    }

    public void applyFont(String fontKind, int fontStyle, int fontSize) {
        fontDesign.getParentFrame().getMemoArea().setFont(new Font(fontKind, fontStyle, fontSize));
    }

    public void closeFontDialog() {
        fontDesign.dispose();
    }
}
