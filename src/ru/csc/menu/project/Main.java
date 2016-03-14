package ru.csc.menu.project;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JV on 09.03.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Menu> menus = MenuXmlParser.parseMenu("C:\\Users\\--\\IdeaProjects\\Menus_CSC_project\\src\\menu.xml");
        for (int i = 0; i < menus.size(); ++i) {
            for (int j = 0; j < menus.get(i).numberOfItems(); ++j) {
                System.out.print(menus.get(i).getItem(j).getPrice() + " ");
            }
            System.out.println();
        }
    }
}
