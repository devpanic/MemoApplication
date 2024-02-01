package MemoApplication;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MenuFontDesign extends JDialog {
    public static final String DEFAULT_FONT_KIND = "맑은 고딕";
    public static final String DEFAULT_FONT_STYLE_STRING = "굵게";
    public static final int DEFAULT_FONT_STYLE = Font.BOLD;
    public static final int DEFAULT_FONT_SIZE = 33;

    private JavaMemoDesign parentFrame;

    private JTextField kindField;
    private JTextField styleField;
    private JTextField sizeField;

    private JList<String> kindList;
    private JList<String> styleList;
    private JList<String> sizeList;

    private JLabel previewLabel;

    private JButton okBtn;
    private JButton cancelBtn;

    public MenuFontDesign(JavaMemoDesign parentFrame) {
        super(parentFrame, "글꼴", true);

        this.parentFrame = parentFrame;
        setLayout(null);

        addKindPanel();
        addStylePanel();
        addSizePanel();
        addPreviewPanel();
        addButtonPanel();

        addListeners();

        setBounds(parentFrame.getX() + 25, parentFrame.getY() + 65, 550, 470);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public JavaMemoDesign getParentFrame() {
        return parentFrame;
    }

    public JTextField getKindField() {
        return kindField;
    }

    public JTextField getStyleField() {
        return styleField;
    }

    public JTextField getSizeField() {
        return sizeField;
    }

    public JList<String> getKindList() {
        return kindList;
    }

    public JList<String> getStyleList() {
        return styleList;
    }

    public JList<String> getSizeList() {
        return sizeList;
    }

    public JLabel getPreviewLabel() {
        return previewLabel;
    }

    private void addKindPanel() {
        JLabel kindLabel = new JLabel("글꼴");
        kindField = new JTextField(DEFAULT_FONT_KIND);

        DefaultListModel<String> kindModel = new DefaultListModel<>();
        kindList = new JList<>(kindModel);
        JScrollPane kindScroll = new JScrollPane(kindList);
        kindModel.addElement("고딕체");
        kindModel.addElement("궁서체");
        kindModel.addElement("Consolas");
        kindModel.addElement("새굴림");
        kindModel.addElement("맑은 고딕");

        kindLabel.setBounds(0, 0, 200, 30);
        kindField.setBounds(0, 30, 200, 30);
        kindScroll.setBounds(0, 60, 200, 120);

        JPanel kindPanel = new JPanel();
        kindPanel.setLayout(null);

        kindPanel.add(kindLabel);
        kindPanel.add(kindField);
        kindPanel.add(kindScroll);

        kindPanel.setBounds(20, 10, 200, 200);
        add(kindPanel);
    }

    private void addStylePanel() {
        JLabel styleLabel = new JLabel("글꼴 스타일");
        styleField = new JTextField(DEFAULT_FONT_STYLE_STRING);

        DefaultListModel<String> styleModel = new DefaultListModel<>();
        styleList = new JList<>(styleModel);
        JScrollPane styleScroll = new JScrollPane(styleList);
        styleModel.addElement("일반");
        styleModel.addElement("굵게");
        styleModel.addElement("기울임꼴");
        styleModel.addElement("굵은 기울임꼴");

        styleLabel.setBounds(0, 0, 170, 30);
        styleField.setBounds(0, 30, 170, 30);
        styleScroll.setBounds(0, 60, 170, 120);

        JPanel stylePanel = new JPanel();
        stylePanel.setLayout(null);

        stylePanel.add(styleLabel);
        stylePanel.add(styleField);
        stylePanel.add(styleScroll);

        stylePanel.setBounds(240, 10, 170, 200);
        add(stylePanel);
    }

    private void addSizePanel() {
        JLabel sizeLabel = new JLabel("크기");
        sizeField = new JTextField(Integer.toString(DEFAULT_FONT_SIZE));

        DefaultListModel<String> sizeModel = new DefaultListModel<>();
        sizeList = new JList<>(sizeModel);
        JScrollPane sizeScroll = new JScrollPane(sizeList);
        sizeModel.addElement("8");
        sizeModel.addElement("9");
        for (int i = 10; i < 81; i += 2) {
            sizeModel.addElement(Integer.toString(i));
        }

        sizeLabel.setBounds(0, 0, 80, 30);
        sizeField.setBounds(0, 30, 80, 30);
        sizeScroll.setBounds(0, 60, 80, 120);

        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(null);

        sizePanel.add(sizeLabel);
        sizePanel.add(sizeField);
        sizePanel.add(sizeScroll);

        sizePanel.setBounds(430, 10, 80, 200);
        add(sizePanel);
    }

    private void addPreviewPanel() {
        previewLabel = new JLabel("AabbYyZz");
        previewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 33));
        previewLabel.setBounds(45, 20, 180, 100);

        JPanel previewPanel = new JPanel();
        previewPanel.setLayout(null);
        previewPanel.add(previewLabel);

        previewPanel.setBounds(240, 210, 270, 140);
        previewPanel.setBorder(new TitledBorder("보기"));

        add(previewPanel);
    }

    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        okBtn = new JButton("확인");
        cancelBtn = new JButton("취소");

        buttonPanel.add(okBtn);
        buttonPanel.add(cancelBtn);

        buttonPanel.setBounds(320, 370, 190, 40);

        add(buttonPanel);
    }

    private void addListeners() {
        MenuFontEvent fontEvent = new MenuFontEvent(this);

        kindList.addMouseListener(fontEvent);
        styleList.addMouseListener(fontEvent);
        sizeList.addMouseListener(fontEvent);

        okBtn.addActionListener(fontEvent);
        cancelBtn.addActionListener(fontEvent);
    }
}
