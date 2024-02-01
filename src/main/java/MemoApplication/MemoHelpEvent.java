package MemoApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class MemoHelpEvent extends WindowAdapter implements ActionListener {
    private MemoHelpDesign memoHelpDesign;

    public MemoHelpEvent(MemoHelpDesign memoHelpDesign) {
        this.memoHelpDesign = memoHelpDesign;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        memoHelpDesign.dispose();
    }
}
