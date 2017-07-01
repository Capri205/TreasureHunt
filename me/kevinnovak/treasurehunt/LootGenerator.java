package me.kevinnovak.treasurehunt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class LootGenerator {
	List<TreasureChestType> treasureChestTypes = new ArrayList<TreasureChestType>();
	
	LootGenerator(File[] files) {
		this.setTreasureChestTypes(files);
	}
	
	List<TreasureChestType> getTreasureChestTypes() {
		return this.treasureChestTypes;
	}
	
	void setTreasureChestTypes(List<TreasureChestType> treasureChestTypes) {
		this.treasureChestTypes = treasureChestTypes;
	}
	
	void setTreasureChestTypes(File[] files) {
		for (File file : files) {
			if (file.exists()) {
				FileConfiguration data = YamlConfiguration.loadConfiguration(file);
				if (data.isSet("name") && data.isSet("weight") && data.isSet("value") && data.isSet("items")) {
					String name = data.getString("name");
					int weight = data.getInt("weight");
					int value = data.getInt("value");
					
					List<ItemStack> items = new ArrayList<ItemStack>();
					// Add items
					
					TreasureChestType treasureChestType = new TreasureChestType(name, weight, value, items);
					treasureChestTypes.add(treasureChestType);
				}
			}
		}
	}
}