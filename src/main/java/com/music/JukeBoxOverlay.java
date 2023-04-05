package com.music;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;


class JukeBoxOverlay extends Overlay
{
	private Client client;
	private JukeboxConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	private JukeBoxOverlay(Client client, JukeboxConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		panelComponent.getChildren().clear();

		String overlayTitle = "Current Song";

		// Build overlay title
		panelComponent.getChildren().add(TitleComponent.builder()
			.text(overlayTitle)
			.color(Color.GREEN)
			.build());

		// Set the size of the overlay (width)
		panelComponent.setPreferredSize(new Dimension(
			graphics.getFontMetrics().stringWidth(overlayTitle) + 30, 0
		));

		// Add a line on the overlay for song title
		panelComponent.getChildren().add(LineComponent.builder()
			.left("Song:")
			.build());

		// {...}

		return panelComponent.render(graphics);
	}


}
