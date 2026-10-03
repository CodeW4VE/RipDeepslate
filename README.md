# RipDeepslate

Makes **deepslate mine exactly like stone** with a netherite pickaxe. With the same
setup that lets you insta-mine stone (**Efficiency V + Haste II**), deepslate goes
instant too. No more grinding through deepslate one slow crack at a time.

Part of the [W4VE](https://github.com/CodeW4VE) family (Code Ware 4 Vanilla Experience).

## How it works

Deepslate's hardness is `3.0`, exactly twice stone's `1.5`. RipDeepslate simply
doubles the block-breaking speed of deepslate when you hold a netherite pickaxe, so
the game treats it as if it had stone's hardness. That's it. No changes to blast
resistance, drops, or anything else, and it only affects deepslate (not cobbled
deepslate, tiles, bricks, or ores).

### Why it has to be on both sides

The mod runs on **client and server**. That is the whole trick:

- In vanilla Minecraft the **client** predicts block breaking locally. If only the
  server thinks deepslate is fast, the client keeps playing the slow crack animation
  and fights the server, giving you ghost blocks and stutter.
- With RipDeepslate on **both** sides, the client does the exact same math the server
  does. It breaks the block locally and instantly, no crack animation, no ghosting,
  no desync. Smooth, like stone should be.

## Requirements

- Minecraft **1.21 / 1.21.1, 26.2 or 26.3**, using the matching jar
- **Fabric Loader** (0.19.5+ for Minecraft 26.3)
- Java 21 for Minecraft 1.21, Java 25 for Minecraft 26.x
- A netherite pickaxe (and Efficiency V + Haste II if you want it fully instant)

No Fabric API or other dependencies. Single jar.

## Installation

Drop `ripdeepslate-x.y.z+<minecraft-version>.jar` into your `mods/` folder. The `+1.21` jar also supports 1.21.1. Download a separate jar for 26.2 or 26.3.

- **Players:** put it in `.minecraft/mods/` (or your instance's mods folder).
- **Server:** put it in the server's `mods/` folder.

Both the server **and** every player who wants smooth deepslate mining need it
installed. A player without the mod just mines deepslate at vanilla speed.

## License

MIT. See [LICENSE](LICENSE).
