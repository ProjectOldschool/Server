package astraeus.net.packet.in;

import astraeus.game.event.impl.WidgetContainerFirstOptionEvent;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.codec.ByteModification;
import astraeus.net.codec.game.ByteBufReader;
import astraeus.net.packet.IncomingPacket;
import astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;
import astraeus.net.packet.Receivable;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_1)
public final class WidgetContainerFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();

    final int widgetId = reader.readShort(ByteModification.ADDITION);
    final int itemSlot = reader.readShort(ByteModification.ADDITION);
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new WidgetContainerFirstOptionEvent(widgetId, itemId, itemSlot));
  }

}
