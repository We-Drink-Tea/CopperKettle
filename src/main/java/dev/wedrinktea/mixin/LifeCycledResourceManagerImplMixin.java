package dev.wedrinktea.mixin;

import dev.wedrinktea.event.load.LoadEvents;
import net.minecraft.resource.LifecycledResourceManager;
import net.minecraft.resource.LifecycledResourceManagerImpl;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(LifecycledResourceManagerImpl.class)
public abstract class LifeCycledResourceManagerImplMixin implements LifecycledResourceManager {
    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void dynamicPackEarlyReload(ResourceType type, List<ResourcePack> packs, CallbackInfo cir) {
        if (type == ResourceType.CLIENT_RESOURCES) {
            LoadEvents.INSTANCE.getEARLY_RELOAD_CLIENT().invoker().onEarlyReloadClientResources(this);
        }

        if (type == ResourceType.SERVER_DATA) {
            LoadEvents.INSTANCE.getEARLY_RELOAD_SERVER().invoker().onEarlyReloadServerResources(this);
        }
    }
}
