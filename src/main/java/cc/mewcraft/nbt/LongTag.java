package cc.mewcraft.nbt;

import cc.mewcraft.version.NmsVersion;
import me.lucko.shadow.Shadow;
import me.lucko.shadow.Static;
import me.lucko.shadow.bukkit.BukkitShadowFactory;
import me.lucko.shadow.bukkit.Mapping;
import me.lucko.shadow.bukkit.NmsClassTarget;
import me.lucko.shadow.bukkit.ObfuscatedTarget;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;

@NmsClassTarget("nbt.LongTag")
@DefaultQualifier(NonNull.class)
public interface LongTag extends Shadow, NumberTag {

    static LongTag valueOf(long value) {
        return BukkitShadowFactory.global().staticShadow(LongTag.class).longValueOf(value);
    }

    @ObfuscatedTarget({
            @Mapping(value = "valueOf", version = NmsVersion.v1_20_R4),
            @Mapping(value = "a", version = NmsVersion.v1_20_R3)
    })
    @Static
    LongTag longValueOf(long value);

}
