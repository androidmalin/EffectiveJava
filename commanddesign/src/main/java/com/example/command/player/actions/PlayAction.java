package com.example.command.player.actions;


import com.example.command.player.GPlayer;
import com.example.command.player.IAction;

public class PlayAction implements IAction {
    private final GPlayer gplayer;

    public PlayAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    @Override
    public void execute() {
        gplayer.play();
    }
}
