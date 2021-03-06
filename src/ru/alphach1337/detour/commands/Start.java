package ru.alphach1337.detour.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.alphach1337.detour.Detour;
import ru.alphach1337.detour.Settings;
import ru.alphach1337.detour.Title;
import ru.alphach1337.detour.managers.DetourManager;

import java.util.List;

public class Start implements Command{
    public String getPermission(){
        return "detour.manage";
    }

    @Override
    public String getHelp() {
        return null;
    }

    @Override
    public void execute(CommandSender commandSender, org.bukkit.command.Command command, String[] args) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Только игроки могут использовать эту команду!");
            return;
        }

        if(!DetourManager.getInstance().getIsDetour()) {
            DetourManager.getInstance().start();
            DetourManager.getInstance().party.add(commandSender.getName());

            Title title = new Title(Settings.Started1, Settings.onStartSubtitle);
            title.setSubtitleColor(ChatColor.YELLOW);
            title.broadcast();
            Bukkit.broadcastMessage(Settings.Started1);
            Bukkit.broadcastMessage(Settings.Started2);
        }else{
            commandSender.sendMessage(Settings.alreadyStarted);
        }
    }

    @Override
    public void ExecuteConsole(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {

    }
}
