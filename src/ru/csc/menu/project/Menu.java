package ru.csc.menu.project;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JV on 09.03.2016.
 */
public class Menu {
    private Date date;
    private ArrayList<MenuItem> items;

    Menu(Date date) {
        this.date = date;
        items = new ArrayList<MenuItem>();
    }

    void addItem(String type,
                 String tags,
                 String name,
                 double weight,
                 double calorie,
                 double price,
                 ArrayList<String> composition
    ){
        items.add(new MenuItem(type, tags, name, weight, calorie, price, composition));
    }

    MenuItem getItem(int index){
        return items.get(index);
    }

    Date getDate(){
        return date;
    }

    public class MenuItem{

        private String type;
        private String tags;
        private String name;
        private double weight;
        private double calorie;
        private double price;
        private ArrayList<String> composition;

        MenuItem (String type,
                  String tags,
                  String name,
                  double weight,
                  double calorie,
                  double price,
                  ArrayList<String> composition
                  )
        {
            this.type = type;
            this.tags = tags;
            this.name = name;
            this.weight = weight;
            this.calorie = calorie;
            this.price = price;
            this.composition = composition;
        }

        public String getType() {
            return type;
        }

        public String getTags() {
            return tags;
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }

        public double getCalorie() {
            return calorie;
        }

        public double getPrice() {
            return price;
        }

        public ArrayList<String> getComposition() {
            return composition;
        }
    }
}
