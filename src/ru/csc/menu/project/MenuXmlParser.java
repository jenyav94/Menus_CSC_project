package ru.csc.menu.project;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JV on 09.03.2016.
 */
public class MenuXmlParser {

    private static final String MENU = "menu";
    private static final String DATE = "date";
    private static final String ITEM = "item";
    private static final String NAME = "name";
    private static final String COMPOSITION = "composition";
    private static final String INGREDIENT = "ingredient";
    private static final String WEIGHT = "weight";
    private static final String CALORIES = "calorie";
    private static final String PRICE = "price";
    private static final String TYPE = "type";
    private static final String TAGS = "tags";

    private static Document getDocument(String filePath) throws Exception {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();

        return builder.parse(new File(filePath));
    }

    public static ArrayList<Menu> menuArrayForm(String filePath){

        ArrayList<Menu> menus = new ArrayList<Menu>();

        try {
            Document doc = getDocument(filePath);
            NodeList menusList = doc.getElementsByTagName(MENU);

            for (int menuInd = 0; menuInd < menusList.getLength(); ++menuInd) {

                Element menuElement = (Element) menusList.item(menuInd);
                String date = menuElement.getAttribute(DATE);
                Menu menu = new Menu(date);

                NodeList itemList = menuElement.getElementsByTagName(ITEM);

                for (int itemInd = 0; itemInd < itemList.getLength(); ++itemInd) {

                    Element element = (Element) itemList.item(itemInd);

                    String name = element.getElementsByTagName(NAME).item(0).getTextContent();
                    String weight = element.getElementsByTagName(WEIGHT).item(0).getTextContent();
                    String calorie = element.getElementsByTagName(CALORIES).item(0).getTextContent();
                    String price = element.getElementsByTagName(PRICE).item(0).getTextContent();
                    String type = element.getAttribute(TYPE);
                    String tags = element.getAttribute(TAGS);

                    Element composition = (Element) element.getElementsByTagName(COMPOSITION).item(0);
                    ArrayList<String> ingredients = null;
                    if (composition != null) {
                        NodeList ingredientsList = composition.getElementsByTagName(INGREDIENT);
                        ingredients = new ArrayList<String>();
                        for (int ingredientInd = 0; ingredientInd < ingredientsList.getLength(); ++ingredientInd) {
                            ingredients.add(ingredientsList.item(ingredientInd).getTextContent());
                        }
                    }

                    menu.addItem(type, tags, name, Double.parseDouble(weight), Double.parseDouble(calorie),
                            Double.parseDouble(price), ingredients);
                }

                menus.add(menu);
            }

            return menus;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
