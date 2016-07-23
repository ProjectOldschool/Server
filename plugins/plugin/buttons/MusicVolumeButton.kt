package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.sound.Volume
import astraeus.net.packet.out.SetWidgetConfigPacket

@SubscribesTo(ButtonActionEvent::class)
class MusicVolumeButton : ButtonClick() {

    override fun execute(player: Player, event: ButtonActionEvent) {
        when (event.button) {
            930 -> {
                player.attr().put(Player.MUSIC_VOLUME_KEY, Volume.SILENT)
                player.queuePacket(SetWidgetConfigPacket(168, player.attr().get(Player.MUSIC_VOLUME_KEY).code))
            }

            931 -> {
                player.attr().put(Player.MUSIC_VOLUME_KEY, Volume.QUIET)
                player.queuePacket(SetWidgetConfigPacket(168, player.attr().get(Player.MUSIC_VOLUME_KEY).code))
            }

            932 -> {
                player.attr().put(Player.MUSIC_VOLUME_KEY, Volume.NORMAL)
                player.queuePacket(SetWidgetConfigPacket(168, player.attr().get(Player.MUSIC_VOLUME_KEY).code))
            }

            933 -> {
                player.attr().put(Player.MUSIC_VOLUME_KEY, Volume.HIGH)
                player.queuePacket(SetWidgetConfigPacket(168, player.attr().get(Player.MUSIC_VOLUME_KEY).code))
            }

            934 -> {
                player.attr().put(Player.MUSIC_VOLUME_KEY, Volume.LOUD)
                player.queuePacket(SetWidgetConfigPacket(168, player.attr().get(Player.MUSIC_VOLUME_KEY).code))
            }
        }
    }

    override fun test(event: ButtonActionEvent): Boolean {
        return event.button == 930 || event.button == 931 || event.button == 932 || event.button == 933 || event.button == 934;
    }

}