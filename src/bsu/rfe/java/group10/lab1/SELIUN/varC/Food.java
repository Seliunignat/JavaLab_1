package bsu.rfe.java.group10.lab1.SELIUN.varC;

import java.util.Objects;

public class Food implements Consumable, Nutritious {
    protected int amountOfParams;
    private String name = null;

    public Food(String name)
    {
        this.name = name;
        amountOfParams = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getAmountOfParams() {
        return amountOfParams;
    }

    public void setAmountOfParams(int amountOfParams) {
        this.amountOfParams = amountOfParams;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Food)) return false; //Если объект obj не является объектом класса Food или его потомков
        if(name==null || ((Food)obj).name == null) return false; //Проверка на то, полностью ли сконструированны объекты this или obj
        return name.equals(((Food)obj).name); //Возвращает true или false, если есть совпадение имени или нет, соответственно
    }

    @Override
    public void consume()
    {
    }

    @Override
    public int calculateCalories() {
        return 0;
    }
}
