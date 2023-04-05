package com.music;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface JukeboxConfig extends Config
{
	@ConfigItem(
		keyName = "testKey",
		name = "Jukebox",
		description = "The message to show to the user when they login"
	)
	default String greeting()
	{
		return "The beginning of Jukebox!";
	}
}
