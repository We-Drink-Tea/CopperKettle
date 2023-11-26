package dev.wedrinktea.mixin;

import dev.wedrinktea.event.LoadEvents;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.VanillaDataPackProvider;
import net.minecraft.resource.VanillaResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(VanillaResourcePackProvider.class)
public abstract class VanillaResourcePackProviderMixin implements ResourcePackProvider {
    @Inject(method = "register", at = @At("RETURN"))
    public void register(Consumer<ResourcePackProfile> profileAdder, CallbackInfo ci) {
        if (!((ResourcePackProvider) this instanceof VanillaDataPackProvider))
            return;

        LoadEvents.INSTANCE.getLOAD_SERVER_RESOURCES().invoker().loadServerResources(profileAdder);
    }
}