package com.music;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("jukebox")
public interface JukeboxConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "playMusic",
		name = "Play Music",
		description = "Toggle the Jukebox music"
	)
	default boolean playMusic()
	{
		return false;
	}
}
