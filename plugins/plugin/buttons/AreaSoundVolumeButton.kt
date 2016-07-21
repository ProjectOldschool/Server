package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.sound.Volume
import astraeus.net.packet.out.SetWidgetConfigPacket

@SubscribesTo(ButtonActionEvent::class)
class AreaSoundVolumeButton : ButtonClick() {

    override fun execute(player: Player, event: ButtonActionEvent) {
        when (event.button) {
            19150 -> {
                player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.SILENT)
                player.send(SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).code))
            }

            19151 -> {
                player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.QUIET)
                player.send(SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).code))
            }

            19152 -> {
                player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.NORMAL)
                player.send(SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).code))
            }

            19153 -> {
                player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.HIGH)
                player.send(SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).code))
            }

            19154 -> {
                player.attr().put(Player.AREA_SOUND_VOLUME_KEY, Volume.LOUD)
                player.send(SetWidgetConfigPacket(170, player.attr().get(Player.AREA_SOUND_VOLUME_KEY).code))
            }
        }
    }

    override fun test(event: ButtonActionEvent): Boolean {
        return event.button == 19150 || event.button == 19151 || event.button == 19152 || event.button == 19153 || event.button == 19154;
    }


}