import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import lang.Main.main;

public class LanguageManager {

	
      public main main;

      public LanguageManager(main main) {
        this.main = main;
      }

      public File enfile = new File("plugins/Language", "en_US.yml");
      public FileConfiguration encfg = YamlConfiguration.loadConfiguration(enfile);

      public File defile = new File("plugins/Language", "de_DE.yml");
      public FileConfiguration decfg = YamlConfiguration.loadConfiguration(defile);

      public File curFile;
      public FileConfiguration curCFG;


      public void LoadConfig() {

        if(!enfile.exists()) {

            try {
              encfg.save(enfile);
              Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§aDie Datei '§6en_US.yml§a' wurde Erstellt!");

              createStandartENConfig();

            } catch (IOException e) {
              e.printStackTrace();
              Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§cERROR Die Datei konnte nicht erstellt werden PATH: §6" + enfile.getPath());
              return;
            }



        } else {
          Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§aDie Datei '§6en_US.yml§a' wurde Geladen!");
        }

        if(!defile.exists()) {

          try {
            decfg.save(defile);
            Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§aDie Datei '§6de_DE.yml§a' wurde Erstellt!");

            createStandartDEConfig();

          } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§cERROR Die Datei konnte nicht erstellt werden PATH: §6" + defile.getPath());
            return;
          }



      } else {
        Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§aDie Datei '§6de_DE.yml§a' wurde Geladen!");
        }
      }

      public void createStandartDEConfig() {

        decfg.options().copyDefaults(true);

        decfg.set("Message_1", "&aHallo Kumpel!");



        try {
          decfg.save(defile);
        } catch (IOException e) {
          e.printStackTrace();
        }

      }

      public void createStandartENConfig() {

        encfg.options().copyDefaults(true);

        encfg.set("Message_1", "&aHello Budy!");




        try {
          encfg.save(enfile);
        } catch (IOException e) {
          e.printStackTrace();
        }

      }

      public void checkIfLangFileinConfigExits() {

        String lang = main.sprache.replace(".yml", " ").trim();
        String langFile = main.sprache;

        Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§aCurrent Language File:§6 " + lang);

        this.curFile = new File("plugins/Language", langFile);

        this.curCFG = YamlConfiguration.loadConfiguration(curFile);

        if(curFile.exists()) {
          Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§aDie angegebene datei '§6" + langFile + "§a' wurde geladen!");
        } else {
          Bukkit.getConsoleSender().sendMessage(main.Prefix() + "§cDie angegebene datei '§6" + langFile + "§c' konnte nicht gefunden werden!");
          return;
        }

      }

      public String getMessage(String path) {
        return ChatColor.translateAlternateColorCodes('&', curCFG.getString(path));
      }

      public int getInt(String path) {
        return curCFG.getInt(path);
      }
	
}
