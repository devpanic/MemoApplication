package MemoApplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JList;

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
        int tempInt = 0;

        switch (e.getActionCommand()) {
            case "확인":
                switch (fontDesign.getFontStyleList().getSelectedValue()) {
                    case "일반":
                        tempInt = Font.PLAIN;
                        break;
                    case "굵게":
                        tempInt = MenuFontDesign.DEFAULT_FONT_STYLE;
                        break;
                    case "기울임꼴":
                        tempInt = Font.ITALIC;
                        break;
                    case "굵은 기울임꼴":
                        tempInt = MenuFontDesign.DEFAULT_FONT_STYLE | Font.ITALIC;
                        break;
                }
                applyFont(fontDesign.getFontKindField().getText(), tempInt,
                        Integer.parseInt(fontDesign.getFontSizeField().getText()));
                break;
        }

        closeFontDialog();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String tempStr = "";
        int tempInt = 0;
        JList<String> fontKindList = fontDesign.getFontKindList();
        JList<String> fontStyleList = fontDesign.getFontStyleList();
        JList<String> fontSizeList = fontDesign.getFontSizeList();

        if (e.getSource() == fontDesign.getFontKindList()) {
            tempStr = fontKindList.getSelectedValue();
            fontDesign.getFontKindField().setText(tempStr);
            setPreview(tempStr, MenuFontDesign.DEFAULT_FONT_STYLE, MenuFontDesign.DEFAULT_FONT_SIZE);
        } else if (e.getSource() == fontDesign.getFontStyleList()) {
            switch (fontStyleList.getSelectedValue()) {
                case "일반":
                    tempInt = Font.PLAIN;
                    break;
                case "굵게":
                    tempInt = MenuFontDesign.DEFAULT_FONT_STYLE;
                    break;
                case "기울임꼴":
                    tempInt = Font.ITALIC;
                    break;
                case "굵은 기울임꼴":
                    tempInt = MenuFontDesign.DEFAULT_FONT_STYLE | Font.ITALIC;
                    break;
            }
            tempStr = fontStyleList.getSelectedValue();
            fontDesign.getFontStyleField().setText(tempStr);
            setPreview(MenuFontDesign.DEFAULT_FONT_KIND, tempInt, MenuFontDesign.DEFAULT_FONT_SIZE);
        } else if (e.getSource() == fontDesign.getFontSizeList()) {
            tempStr = fontSizeList.getSelectedValue();
            fontDesign.getFontSizeField().setText(tempStr);
            setPreview(MenuFontDesign.DEFAULT_FONT_KIND, MenuFontDesign.DEFAULT_FONT_STYLE, Integer.parseInt(tempStr));
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

    public void setPreview(String fontKind, int fontStyle, int fontSize) {
        fontDesign.getFontPriviewLabel().setFont(new Font(fontKind, fontStyle, fontSize));
    }

    public void applyFont(String fontKind, int fontStyle, int fontSize) {
        fontDesign.getParentFrame().getMemoArea().setFont(new Font(fontKind, fontStyle, fontSize));
    }

    public void closeFontDialog() {
        fontDesign.dispose();
    }
}
