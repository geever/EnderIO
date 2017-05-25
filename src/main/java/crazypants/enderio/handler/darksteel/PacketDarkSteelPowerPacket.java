package crazypants.enderio.handler.darksteel;

import crazypants.enderio.item.darksteel.ItemDarkSteelArmor;
import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDarkSteelPowerPacket implements IMessage, IMessageHandler<PacketDarkSteelPowerPacket, IMessage> {

  private int powerUse;
  private EntityEquipmentSlot armorType;

  public PacketDarkSteelPowerPacket() {
  }

  public PacketDarkSteelPowerPacket(int powerUse, EntityEquipmentSlot armorType) {
    this.powerUse = powerUse;
    this.armorType = armorType;
  }

  @Override
  public void toBytes(ByteBuf buffer) {
    buffer.writeInt(powerUse);
    buffer.writeShort((short)armorType.ordinal());
  }

  @Override
  public void fromBytes(ByteBuf buffer) {
    powerUse = buffer.readInt();
    armorType = EntityEquipmentSlot.values()[buffer.readShort()];
  }

  @Override
  public IMessage onMessage(PacketDarkSteelPowerPacket message, MessageContext ctx) {
    DarkSteelController.instance.usePlayerEnergy(ctx.getServerHandler().playerEntity, ItemDarkSteelArmor.forArmorType(message.armorType), message.powerUse);
    ctx.getServerHandler().playerEntity.fallDistance = 0;
    return null;
  }

}