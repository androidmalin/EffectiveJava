package com.example.command.player;

import com.example.command.player.actions.PauseAction;
import com.example.command.player.actions.PlayAction;
import com.example.command.player.actions.SpeedAction;
import com.example.command.player.actions.StopAction;

public class Test {
    public static void main(String[] args) {

        GPlayer player = new GPlayer();
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        controller.addAction(new PauseAction(player));
        controller.addAction(new PlayAction(player));
        controller.addAction(new StopAction(player));
        controller.addAction(new SpeedAction(player));
        controller.executes();
    }
}
