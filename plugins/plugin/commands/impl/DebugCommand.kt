package plugin.commands.impl

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.CommandEvent
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.entity.mob.player.PlayerRights
import astraeus.net.packet.out.ServerMessagePacket
import plugin.commands.Command
import plugin.commands.CommandParser

@SubscribesTo(CommandEvent::class)
class DebugCommand : Command() {

    override fun execute(player: Player, parser: CommandParser): Boolean {
        player.attr().toggle(Player.DEBUG_KEY)
        player.send(ServerMessagePacket("[debug= ${player.attr().get(Player.DEBUG_KEY)}]"))
        return true
    }

    override fun test(event: CommandEvent): Boolean {
        when (event.name) {
            "debug" -> return true

            else -> return false
        }
    }

    override val rights: PlayerRights
        get() {
            return PlayerRights.DEVELOPER
        }

}