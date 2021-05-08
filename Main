package lang.Main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import lang.Manager.LanguageManager;

public class main extends JavaPlugin {

	LanguageManager lm = new LanguageManager(this);
	
	public String sprache = this.getConfig().getString("Language");
	
      @Override
      public void onEnable() {

        lm.LoadConfig();
        lm.checkIfLangFileinConfigExits();
        loadConfig();


      }

      @Override
      public void onDisable() {



      }

      public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
      }
  }
