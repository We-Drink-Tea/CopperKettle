package dev.wedrinktea.mixin.client;

import dev.wedrinktea.event.load.LoadEvents;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.resource.DefaultClientResourcePackProvider;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.VanillaResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
@Mixin(VanillaResourcePackProvider.class)
public abstract class VanillaResourcePackProviderMixin implements ResourcePackProvider {
    @Inject(method = "register", at = @At("RETURN"))
    public void register(Consumer<ResourcePackProfile> profileAdder, CallbackInfo ci) {
        if (!((ResourcePackProvider) this instanceof DefaultClientResourcePackProvider))
            return;

        LoadEvents.INSTANCE.getLOAD_CLIENT_RESOURCES().invoker().loadClientResources(profileAdder);
    }
}
