package MemoApplication;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MemoHelpDesign extends JDialog {
    public MemoHelpDesign(JavaMemoDesign parentFrame){
        super(parentFrame, "메모장 정보");
        String infoStr = "Java 메모장 Version 1.0\n이 메모장은 SHPL(SuHyun Public License)로서 아무나 가져다 변환 및 배포 가능합니다. 편하게 가져다 사용해주세요.";

        JLabel infoLabel = new JLabel(infoStr);
        add("Center", infoLabel);

        JButton closeBtn = new JButton("닫기");
        add("South", closeBtn);

        setSize(200,200);
        setVisible(true);
    }
}
