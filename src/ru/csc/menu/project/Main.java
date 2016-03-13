package ru.csc.menu.project;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JV on 09.03.2016.
 */
public class Main {
    public static void main(String[] args){

//        ru.csc.menu.project.Menu menu = new ru.csc.menu.project.Menu(new Date());
//
//        ArrayList<String> tags = new ArrayList<String>();
//        tags.add("meat"); tags.add("fish");
//
//        ArrayList<String> comp = new ArrayList<String>();
//        comp.add("gov"); comp.add("oil");
//
//        menu.addItem("salad", tags, "Bolgarian", 150, 356, 80, comp);
//
//        ru.csc.menu.project.Menu.MenuItem item = menu.getItem(0);
        //System.out.println(item.getCalorie());

        ArrayList<Menu> menus = MenuXmlParser.menuArrayForm("C:\\Users\\--\\IdeaProjects\\Menus_CSC_project\\src\\menu.xml");
        System.out.println(menus.get(0).getItem(0).getPrice());
    }
}
