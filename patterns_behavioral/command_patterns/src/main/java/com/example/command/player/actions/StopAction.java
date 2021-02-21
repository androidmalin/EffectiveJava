package com.example.command.player.actions;

import com.example.command.player.GPlayer;
import com.example.command.player.IAction;

public class StopAction implements IAction {
    private final GPlayer gplayer;

    public StopAction(GPlayer gplayer) {
        this.gplayer = gplayer;
    }

    @Override
    public void execute() {
        gplayer.stop();
    }
}
