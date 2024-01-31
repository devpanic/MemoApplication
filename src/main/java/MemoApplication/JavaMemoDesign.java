package MemoApplication;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JavaMemoDesign extends JFrame {
    public JavaMemoDesign(){
        super("메모장");

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("파일");
        JMenu formatMenu = new JMenu("서식");
        JMenu helpMenu = new JMenu("도움말");

        JMenuItem newMemoItem = new JMenuItem("새글");
        JMenuItem openMemoItem = new JMenuItem("열기");
        JMenuItem saveMemoItem = new JMenuItem("저장");
        JMenuItem exitMemoItem = new JMenuItem("종료");

        JMenuItem fontItem = new JMenuItem("글꼴");

        JMenuItem memoInfoItem = new JMenuItem("메모장 정보");

        fileMenu.add(newMemoItem);
        fileMenu.addSeparator();
        fileMenu.add(openMemoItem);
        fileMenu.add(saveMemoItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMemoItem);

        formatMenu.add(fontItem);

        helpMenu.add(memoInfoItem);

        menuBar.add(fileMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        JTextArea memoArea = new JTextArea();
        JScrollPane memoScroll = new JScrollPane(memoArea);
        add(memoScroll);

        // memo JTextArea with JScrollPane
        // add Event
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
