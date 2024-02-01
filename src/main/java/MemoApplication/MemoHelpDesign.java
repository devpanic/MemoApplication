package MemoApplication;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoHelpDesign extends JDialog {
    public static final String MEMO_HELP_INFO = "<html>Java 메모장 Version 1.0 이 메모장은 SHPL(SuHyun Public License)로서 아무나 가져다 변환 및 배포 가능합니다. 편하게 가져다 사용해주세요.</html>";

    public MemoHelpDesign(JavaMemoDesign parentFrame) {
        super(parentFrame, "메모장 정보");

        JLabel infoLabel = new JLabel(MEMO_HELP_INFO);
        add("Center", infoLabel);

        JPanel closePanel = new JPanel();
        JButton closeBtn = new JButton("닫기");
        closeBtn.addActionListener(new MemoHelpEvent(this));
        closePanel.add(closeBtn);
        add("South", closePanel);

        setBounds(parentFrame.getX() + 200, parentFrame.getY() + 200, 200, 200);
        setVisible(true);
    }
}
