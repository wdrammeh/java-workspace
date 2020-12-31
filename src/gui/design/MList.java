package gui.design;

import gui.MFrame;

import javax.swing.*;
import java.awt.*;

public class MList {

	public static void main(String[] args) {
		final JList<String> leftList = new JList<>(new String[]{"Bacon", "Wigs", "Ham", "Beef",
				"moreBacon"});
		leftList.setSelectionBackground(Color.YELLOW);
		leftList.setVisibleRowCount(10);
		leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		final JPanel panel = new JPanel();
		panel.add(new JScrollPane(leftList));

		MFrame.display("JList", panel);
	}
	
}
