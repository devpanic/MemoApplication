package MemoApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuItem;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class MenuFontDesign extends JDialog {
    public static final String DEFAULT_FONT_KIND = "맑은 고딕";
    public static final int DEFAULT_FONT_STYLE = Font.BOLD;
    public static final int DEFAULT_FONT_SIZE = 33;

    private JavaMemoDesign parentFrame;

    private JTextField fontKindField;
    private JTextField fontStyleField;
    private JTextField fontSizeField;

    private JList<String> fontKindList;
    private JList<String> fontStyleList;
    private JList<String> fontSizeList;

    private DefaultListModel<String> fontKindModel;
    private DefaultListModel<String> fontStyleModel;
    private DefaultListModel<String> fontSizeModel;

    private JLabel fontPriviewLabel;

    private JButton btnOK;
    private JButton btnCancel;

    public MenuFontDesign(JavaMemoDesign parentFrame) {
        super(parentFrame, "글꼴", true);

        MenuFontEvent fontEvent = new MenuFontEvent(this);
        this.parentFrame = parentFrame;
        setLayout(null);

        addFontKindPanel();
        addFontStylePanel();
        addFontSizePanel();
        addFontPreviewPanel();
        addFontButtonPanel();

        fontKindList.addMouseListener(fontEvent);
        fontStyleList.addMouseListener(fontEvent);
        fontSizeList.addMouseListener(fontEvent);

        btnOK.addActionListener(fontEvent);
        btnCancel.addActionListener(fontEvent);
        setFont(new Font(DEFAULT_FONT_KIND, DEFAULT_FONT_STYLE, 12));
        UIManager.getLookAndFeelDefaults().put("defaultFont", new Font(DEFAULT_FONT_KIND, DEFAULT_FONT_STYLE, 12));
        setSize(560, 470);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public JavaMemoDesign getParentFrame() {
        return parentFrame;
    }

    public JTextField getFontKindField() {
        return fontKindField;
    }

    public JTextField getFontStyleField() {
        return fontStyleField;
    }

    public JTextField getFontSizeField() {
        return fontSizeField;
    }

    public JList<String> getFontKindList() {
        return fontKindList;
    }

    public JList<String> getFontStyleList() {
        return fontStyleList;
    }

    public JList<String> getFontSizeList() {
        return fontSizeList;
    }

    public DefaultListModel<String> getFontKindModel() {
        return fontKindModel;
    }

    public DefaultListModel<String> getFontStyleModel() {
        return fontStyleModel;
    }

    public DefaultListModel<String> getFontSizeModel() {
        return fontSizeModel;
    }

    public JLabel getFontPriviewLabel() {
        return fontPriviewLabel;
    }

    private void addFontKindPanel() {
        JPanel fontKindPanel = new JPanel();
        fontKindPanel.setLayout(null);
        JLabel fontKindLabel = new JLabel("글꼴");
        fontKindField = new JTextField(DEFAULT_FONT_KIND, 10);
        fontKindModel = new DefaultListModel<>();
        fontKindList = new JList<>(fontKindModel);
        JScrollPane fontKindScroll = new JScrollPane(fontKindList);
        fontKindModel.addElement("고딕체");
        fontKindModel.addElement("궁서체");
        fontKindModel.addElement("Consolas");
        fontKindModel.addElement("새굴림");
        fontKindModel.addElement("맑은 고딕");

        fontKindLabel.setBounds(0, 0, 200, 30);
        fontKindField.setBounds(0, 30, 200, 30);
        fontKindScroll.setBounds(0, 60, 200, 120);
        fontKindPanel.add(fontKindLabel);
        fontKindPanel.add(fontKindField);
        fontKindPanel.add(fontKindScroll);

        fontKindPanel.setBounds(20, 10, 200, 200);
        add(fontKindPanel);
    }

    private void addFontStylePanel() {
        JPanel fontStylePanel = new JPanel();
        fontStylePanel.setLayout(null);
        JLabel fontStyleLabel = new JLabel("글꼴 스타일");
        fontStyleField = new JTextField(Integer.toString(DEFAULT_FONT_STYLE), 10);
        fontStyleModel = new DefaultListModel<>();
        fontStyleList = new JList<>(fontStyleModel);
        JScrollPane fontStyleScroll = new JScrollPane(fontStyleList);
        fontStyleModel.addElement("일반");
        fontStyleModel.addElement("굵게");
        fontStyleModel.addElement("기울임꼴");
        fontStyleModel.addElement("굵은 기울임꼴");

        fontStyleLabel.setBounds(0, 0, 130, 30);
        fontStyleField.setBounds(0, 30, 130, 30);
        fontStyleScroll.setBounds(0, 60, 130, 120);
        fontStylePanel.add(fontStyleLabel);
        fontStylePanel.add(fontStyleField);
        fontStylePanel.add(fontStyleScroll);

        fontStylePanel.setBounds(240, 10, 130, 200);
        add(fontStylePanel);
    }

    private void addFontSizePanel() {
        JPanel fontSizePanel = new JPanel();
        fontSizePanel.setLayout(null);
        JLabel fontSizeLabel = new JLabel("크기");
        fontSizeField = new JTextField(Integer.toString(DEFAULT_FONT_SIZE), 10);
        fontSizeModel = new DefaultListModel<>();
        fontSizeList = new JList<>(fontSizeModel);
        JScrollPane fontSizeScroll = new JScrollPane(fontSizeList);
        fontSizeModel.addElement("8");
        fontSizeModel.addElement("9");
        for (int i = 10; i < 81; i += 2) {
            fontSizeModel.addElement(Integer.toString(i));
        }

        fontSizeLabel.setBounds(0, 0, 130, 30);
        fontSizeField.setBounds(0, 30, 130, 30);
        fontSizeScroll.setBounds(0, 60, 130, 120);
        fontSizePanel.add(fontSizeLabel);
        fontSizePanel.add(fontSizeField);
        fontSizePanel.add(fontSizeScroll);

        fontSizePanel.setBounds(390, 10, 130, 200);
        add(fontSizePanel);
    }

    private void addFontPreviewPanel() {
        JPanel fontPrivewPanel = new JPanel();
        fontPrivewPanel.setLayout(null);
        fontPriviewLabel = new JLabel("AabbYyZz");
        fontPriviewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 33));
        fontPriviewLabel.setBounds(45, 20, 180, 100);
        fontPrivewPanel.add(fontPriviewLabel);
        fontPrivewPanel.setBounds(240, 210, 280, 140);
        fontPrivewPanel.setBorder(new TitledBorder("보기"));
        add(fontPrivewPanel);
    }

    private void addFontButtonPanel() {
        JPanel fontButtonPanel = new JPanel();
        fontButtonPanel.setLayout(new GridLayout(1, 2));
        btnOK = new JButton("확인");
        btnCancel = new JButton("취소");
        fontButtonPanel.add(btnOK);
        fontButtonPanel.add(btnCancel);
        fontButtonPanel.setBounds(320, 370, 200, 40);
        add(fontButtonPanel);
    }
}
