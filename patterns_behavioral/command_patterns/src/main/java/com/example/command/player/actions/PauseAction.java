package com.example.command.player.actions;

import com.example.command.player.GPlayer;
import com.example.command.player.IAction;

public class PauseAction implements IAction {
    private final GPlayer gplayer;

    public PauseAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    @Override
    public void execute() {
        gplayer.pause();
    }
}
