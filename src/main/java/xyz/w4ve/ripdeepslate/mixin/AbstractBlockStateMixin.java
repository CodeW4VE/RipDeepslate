package xyz.w4ve.ripdeepslate.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public class AbstractBlockStateMixin {

    // Deepslate hardness (3.0) is exactly 2x stone's (1.5). Doubling the block-
    // breaking delta makes a netherite pickaxe mine deepslate exactly like stone,
    // so it goes instant under the very same conditions stone does (Efficiency V +
    // Haste II) with no special enchantment/effect checks needed.
    //
    // This mixin runs on BOTH sides (see fabric.mod.json environment "*"). That is
    // the whole point: the client predicts the break locally with the same math the
    // server uses, so there is no crack animation, no ghost blocks and no desync.
    // A server-only version cannot do this because the vanilla client still thinks
    // deepslate is slow and fights the server's instant break.
    @Inject(method = "getDestroyProgress", at = @At("RETURN"), cancellable = true)
    private void ripdeepslate$mineLikeStone(Player player, BlockGetter world, BlockPos pos, CallbackInfoReturnable<Float> cir) {
        BlockState state = (BlockState) (Object) this;
        if (!state.is(Blocks.DEEPSLATE)) {
            return;
        }
        if (!player.getMainHandItem().is(Items.NETHERITE_PICKAXE)) {
            return;
        }
        cir.setReturnValue(cir.getReturnValue() * 2.0F);
    }
}
