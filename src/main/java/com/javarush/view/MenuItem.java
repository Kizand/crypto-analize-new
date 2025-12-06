package com.javarush.view;

public class MenuItem {
    public final String code;
    public final int number;
    public final MenuQuest[] quests;

    public MenuItem(String code, int number) {
        this(code, number, null);
    }

    public MenuItem(String code, int number, MenuQuest[] quests) {
        this.code = code;
        this.number = number;
        this.quests = quests;
    }
}