package sm.simonr2.plugins;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

	public class BaseClass extends JavaPlugin{
		
		public final Logger logger = Logger.getLogger("Minecraft");
		public static BaseClass plugin;
		
		@Override
		public void onDisable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " Has Been Disabled!");
			}
		
		@Override
		public void onEnable() {
			PluginDescriptionFile pdfFile = this.getDescription();
			this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		}
		
		public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args) {
			Player player = (Player) sender;
			
			float TimeLeft = 0;
			
			
	if(commandLable.equalsIgnoreCase("GenEvent")){
		
		if(args.length == 0 || args.length >= 2){
			sender.sendMessage(ChatColor.AQUA + "Please add a time");
			sender.sendMessage(ChatColor.RED + "/GenEvent (Time)");
		}
		
		else if(args.length < 0){
			sender.sendMessage("Needs to be greater than 0");
		}
		
			TimeLeft = (Float.valueOf(args[0]).floatValue());
			if (TimeLeft >= 0){
			 Bukkit.broadcastMessage(ChatColor.BLUE + "Lag Starting");
		     Bukkit.broadcastMessage(ChatColor.AQUA + "Time Left " + (TimeLeft));
		     TimeLeft --;
		     
		     
		    while (TimeLeft > 0){
		    	try {
		    		Thread.sleep(1000);
		    	} catch(InterruptedException ex) {
		    		Thread.currentThread().interrupt();
		    	}
		    	if(TimeLeft == 10){
		    		Bukkit.broadcastMessage(ChatColor.GOLD + "[Warning] Lag Over in 10 Seconds!");
		    	}
		    	Bukkit.broadcastMessage(ChatColor.AQUA + "Time Left " + (TimeLeft));
		    	TimeLeft --;
		    	
		    }
	    	try {
	    		Thread.sleep(1000);
	    	} catch(InterruptedException ex) {
	    		Thread.currentThread().interrupt();
	    	}
	    	Bukkit.broadcastMessage(ChatColor.AQUA + "Time Left " + (TimeLeft));
		    Bukkit.broadcastMessage(ChatColor.AQUA + "Stop, Lag view Over!");
		   }
        }
	return false;
		}
	}
