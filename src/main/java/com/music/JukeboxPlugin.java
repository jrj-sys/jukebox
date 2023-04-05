package com.music;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Jukebox",
	description = "A jukebox plugin for Runescape music.",
	tags = {"music"},
	loadWhenOutdated = true
)
public class JukeboxPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private JukeboxConfig config;

	@Inject private JukeBoxOverlay overlay;

	@Inject private OverlayManager overlayManager;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "", null);
		}
	}

	@Provides
	JukeboxConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(JukeboxConfig.class);
	}
}
