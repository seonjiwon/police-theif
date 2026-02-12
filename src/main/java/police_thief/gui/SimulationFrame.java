package police_thief.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import police_thief.police.Police;
import police_thief.thief.Thief;
import police_thief.vault.Vault;

public class SimulationFrame extends JFrame {
	public SimulationFrame(Vault vault, List<Thief> thieves, List<Police> polices) {
		super("Police vs Thief Simulation");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		MapPanel mapPanel = new MapPanel(vault, thieves, polices);
		InfoPanel infoPanel = new InfoPanel(vault, thieves, polices);

		add(mapPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.EAST);

		pack();
		setLocationRelativeTo(null);

		// 0.2초마다 화면/정보 갱신
		new Timer(200, e -> {
			infoPanel.refresh();
			mapPanel.repaint();
		}).start();
	}
}
