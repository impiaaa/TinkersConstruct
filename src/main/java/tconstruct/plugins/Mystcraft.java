package tconstruct.plugins;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.TConstruct;

public class Mystcraft implements ICompatPlugin {

    private static String[] fluids = new String[] { "invar.molten", "electrum.molten", "bronze.molten", "aluminumbrass.molten", "manyullyn.molten", "alumite.molten", "cobalt.molten",
                                                    "moltenArdite", "ender", "steel.molten", "platinum.molten" };

    @Override
    public String getModId() {
        return "Mystcraft";
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {
        TConstruct.logger.info("[Mystcraft] Blacklisting Mystcraft fluid symbols.");
        for (String nm : fluids) sendFluidBlacklist(nm);
    }

    @Override
    public void postInit() {

    }

    private void sendFluidBlacklist (String FluidName)
    {
        NBTTagCompound NBTMsg = new NBTTagCompound();
        NBTMsg.setCompoundTag("fluidsymbol", new NBTTagCompound());
        NBTMsg.getCompoundTag("fluidsymbol").setFloat("rarity", 0.0F);
        NBTMsg.getCompoundTag("fluidsymbol").setFloat("grammarweight", 0.0F);
        NBTMsg.getCompoundTag("fluidsymbol").setFloat("instabilityPerBlock", 10000F);// renders creative symbol useless
        NBTMsg.getCompoundTag("fluidsymbol").setString("fluidname", FluidName);
        FMLInterModComms.sendMessage("Mystcraft", "fluidsymbol", NBTMsg);
    }

}
