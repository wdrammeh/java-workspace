package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class ToolTip {

  public static void main(String[] args) {
//    override the createToolTip()
    final JButton button = new JButton("Hover me") {
      public JToolTip createToolTip() {
        final JToolTip myTip = new JToolTip();
        myTip.setBackground(Color.BLACK);
        myTip.setForeground(Color.WHITE);
        myTip.setFont(new Font("Arial", Font.BOLD, 15));
        return myTip;
      }
    };
//    activate the tooltip
    button.setToolTipText("You've just hover over me");
//    specify the initial delay (milli-secs)
    ToolTipManager.sharedInstance().setInitialDelay(100);
//    specify the dismiss (milli-secs)
    ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);

    MFrame.display("ToolTip Sample", button);
  }

}
