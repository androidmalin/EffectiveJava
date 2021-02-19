package com.example.composite.demo.safe;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Direcotry {
    private final List<Direcotry> dirs;
    private final Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<>();
    }

    public void show() {
        System.out.println(this.name);
        for (Direcotry c : dirs) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < this.level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            c.show();
        }
    }

    public boolean add(Direcotry dir) {
        return this.dirs.add(dir);
    }

    public boolean remove(Direcotry dir) {
        return this.dirs.remove(dir);
    }

    public Direcotry get(int index) {
        return this.dirs.get(index);
    }

    public void list() {
        for (Direcotry dir : dirs) {
            System.out.println(dir.name);
        }
    }
}
