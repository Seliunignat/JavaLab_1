package bsu.rfe.java.group10.lab1.SELIUN.varC;

import java.util.Objects;

public class Apple extends Food{
    private String size;
    private static final int CALORIES_SMALL = 44;
    private static final int CALORIES_MEDIUM = 48;
    private static final int CALORIES_BIG = 52;

    public Apple(String size) {
        super("Яблоко");
        this.size = size;
        super.setAmountOfParams(1);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public void consume() {
        System.out.println(this + " съедено"); //Здесь при выводе this, вызывается автоматически метод toString(), который преобразует данный объект в строку(а именно в ИМЯ)
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj))
        {
            if(!(obj instanceof Apple)) return false;
            return size.equals(((Apple) obj).size);
        }
        else return false;
    }

    @Override
    public int calculateCalories() {
        switch (this.size.toUpperCase())
        {
            case "МАЛОЕ": return CALORIES_SMALL;
            case "СРЕДНЕЕ": return CALORIES_MEDIUM;
            case "БОЛЬШОЕ": return CALORIES_BIG;
            default: return 0;
        }

    }
}
