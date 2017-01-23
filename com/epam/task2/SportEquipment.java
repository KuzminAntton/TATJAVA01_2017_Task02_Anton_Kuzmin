package com.epam.task2;

/**
 * emulate behaviour of sport equipment.
 * have category, title, price;
 */
public class SportEquipment {
    private final String category;
    private final String title;
    private int price;

    public SportEquipment(String category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n" + "SportEquipment : " +
                "category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity";

    }
}