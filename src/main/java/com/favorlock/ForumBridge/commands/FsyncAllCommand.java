package com.favorlock.ForumBridge.commands;

import org.bukkit.entity.Player;

import com.favorlock.ForumBridge.ForumBridgeFunctions;
import com.favorlock.ForumBridge.ForumBridge;

public class FsyncAllCommand extends BaseCommand
{

    public FsyncAllCommand()
    {
        this.command.add("fsyncall");
        this.helpDescription = "Force sync all accounts";
        this.permFlag = "bbb.forceall";
        this.senderMustBePlayer = false;
    }

    public void perform()
    {
        Player[] players = ForumBridge.p.getServer().getOnlinePlayers();
        for (Player p : players)
        {
        	if (ForumBridgeFunctions.hasAccount(p.getName()))
        	{
        		ForumBridgeFunctions.syncPlayer(p.getName(), p.getWorld().getName());
        	}
        }
        sendMessage("All players with saved accounts has been synced!");
    }

}
