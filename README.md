#**Hunt for treasure!**

Spawn treasure chests in random locations and search for them with a map!

Features
- Choose when and where treasure chests spawn
- Automatically spawn chests in a world
- Spawn under water or lava
- Require minimum players online
- Announce when treasure chests are disappearing
- Create custom treasure chest types
- Create custom treasure items
- Customize the chance that items get picked
- Treasure chest protection
- UUID support
- Extensive customization


​
##Commands

    /th - View all commands that you have permission for.
        Aliases: /treasurehunt
    /th help - View treasure hunt help.
        Aliases: /th ?
    /th list - Show available treasure chests.
        Aliases: /th chest, /th chests
    /th top - Show top treasure hunters.
        Aliases: /th rank, th ranks
    /th start - Start a treasure hunt.
        Aliases: /th spawn
    /th despawn - Despawn all treasure chests.
        Aliases: /th remove

##Permissions
TreasureHunt has the following permissions:

    treasurehunt.item - Use the treasure hunt item.
        Enabled for everyone by default
        Use "-treasurehunt.item" to remove
    treasurehunt.command.help - View treasure hunt help.
        Enabled for everyone by default
        Use "-treasurehunt.command.help" to remove
    treasurehunt.command.list - Show available treasure chests.
        Enabled for everyone by default
        Use "-treasurehunt.command.list" to remove
    treasurehunt.command.top - Show top treasure hunters.
        Enabled for everyone by default
        Use "-treasurehunt.command.top" to remove
    treasurehunt.command.start - Start a treasure hunt.
    treasurehunt.command.despawn - Despawn all treasure chests.

##Config
Click the links below to view the configuration files:  
**[config.yml](https://pastebin.com/TBgXYzGU)**  
**[language.yml](https://pastebin.com/R4jsKgML)**  

##Customizing Treasure
TreasureHunt provides a default set of treasure tiers and items. If you'd like to customize any treasures, continue following this section.

Inside your main "TreasureHunt" folder you'll find a "treasure" sub-folder. Here you'll find treasure tier files, one for each tier of treasure (common, legendary, epic, etc). You can copy one of these files to create your own custom tier of treasure, or edit the existing files to customize the items. You can also delete these files if you don't want a certain tier.

Here's an example treasure tier file.

At the top of the tier files you'll find the following:

    name: The display name of the tier of treasure.
        Supports color codes.
        Example: &bCommon
    weight: How likely the tier is to be selected.
        Higher numbers mean that tier is more likely to be selected.
        This is not a percentage, but you can calculate how likely a tier is to be drawn by doing (tier weight)/(total weight of all tiers).
        Example: 60
    value: How valuable the tier is.
        TreasureHunt will randomly select items from the tier, adding up the item values until the total is close enough to the tier value.
        Example: 500
    items: A list of items to randomly choose from.
        See the above example treasure tier file.

Under the "items" of the tier, you'll find a list of items, each with the following:

    name: The type of item.
        This is actually a Spigot "Material". You can find a list of possible items here.
        In older versions of TreasureHunt, you'll need to supply the item ID instead.
        Example: PUMPKIN

    amount**: How many of each item should be grouped together.
        **This is optional, will default to 1 item if not provided.
        This is good for items like coal or leather, items that make better rewards when grouped together.
        Example: 32
    value: How valuable the item (or the group of items) is.
        TreasureHunt will randomly select items from the tier, adding up the item values until the total is close enough to the tier value.
        This should be less than the total value of the tier.
        Example: 40
    weight**: How likely the item is to be selected.
        **This is optional, will default to 100 if not provided.
        Higher numbers mean that item is more likely to be selected.
        This is not a percentage, but you can calculate how likely an item is to be drawn by doing (item weight)/(total weight of all items in the tier).
        This is useful for things with lots of variations, like terracotta. You can give each variation a lower chance of being selected.
        Example: 10
