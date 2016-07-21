package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.player.Player
import astraeus.net.packet.out.SetWidgetConfigPacket

@SubscribesTo(ButtonActionEvent::class)
class ToggleAcceptAidButton : ButtonClick() {

    override fun execute(player: Player, event: ButtonActionEvent) {
        player.attr().toggle(Player.ACCEPT_AID_KEY);
        player.send(SetWidgetConfigPacket(427, player.attr().get<Boolean>(Player.ACCEPT_AID_KEY)))
    }

    override fun test(event: ButtonActionEvent): Boolean {
        return event.button == 12464;
    }

}