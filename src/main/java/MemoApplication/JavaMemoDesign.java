package MemoApplication;

import java.awt.Font;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JavaMemoDesign extends JFrame {
    private JTextArea memoArea;

    public JavaMemoDesign() {
        super("메모장");

        addMenuComponents();
        addTextArea();

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextArea getMemoArea() {
        return memoArea;
    }

    public void addMenuComponents() {
        JavaMemoEvent memoEvent = new JavaMemoEvent(this);
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("파일");
        JMenu formatMenu = new JMenu("서식");
        JMenu helpMenu = new JMenu("도움말");

        JMenuItem newMemoItem = new JMenuItem("새글");
        JMenuItem openMemoItem = new JMenuItem("열기");
        JMenuItem saveMemoItem = new JMenuItem("저장");
        JMenuItem exitMemoItem = new JMenuItem("종료");
        JMenuItem saveOtherNameMemoItem = new JMenuItem("다른 이름으로 저장");

        JMenuItem fontItem = new JMenuItem("글꼴");

        JMenuItem memoInfoItem = new JMenuItem("메모장 정보");

        newMemoItem.addActionListener(memoEvent);
        openMemoItem.addActionListener(memoEvent);
        saveMemoItem.addActionListener(memoEvent);
        exitMemoItem.addActionListener(memoEvent);
        saveOtherNameMemoItem.addActionListener(memoEvent);
        fontItem.addActionListener(memoEvent);
        memoInfoItem.addActionListener(memoEvent);

        fileMenu.add(newMemoItem);
        fileMenu.addSeparator();
        fileMenu.add(openMemoItem);
        fileMenu.add(saveMemoItem);
        fileMenu.add(saveOtherNameMemoItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMemoItem);

        formatMenu.add(fontItem);

        helpMenu.add(memoInfoItem);

        menuBar.add(fileMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    public void addTextArea() {
        memoArea = new JTextArea();
        memoArea.setFont(createFontInfo());
        JScrollPane memoScroll = new JScrollPane(memoArea);
        add(memoScroll);
    }

    public Font createFontInfo() {
        ObjectInputStream fontInputStream = null;
        File fontConfigFile = new File("./font.txt");

        if(fontConfigFile.exists()){
            Font fontConfig = null;

            try{
                fontInputStream = new ObjectInputStream(new FileInputStream("./font.txt"));
                fontConfig = (Font)fontInputStream.readObject();

                if(fontInputStream != null){
                    fontInputStream.close();
                }
                return fontConfig;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return new Font("맑은 고딕", Font.BOLD, 16);
    }
}
