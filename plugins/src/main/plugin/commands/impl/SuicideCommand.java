package plugin.commands.impl;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.CommandEvent;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.PlayerRights;
import astraeus.game.model.entity.mob.player.skill.Skill;
import plugin.commands.Command;
import plugin.commands.CommandParser;
@SubscribesTo(CommandEvent.class)
public class SuicideCommand extends Command{

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		player.getSkills().setLevel(Skill.HITPOINTS, 0);
		return false;
	}

	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("kms") || event.getName().equalsIgnoreCase("suicide");
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}

}
