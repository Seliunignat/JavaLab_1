package bsu.rfe.java.group10.lab1.SELIUN.varC;

public class Dessert extends Food{
    private String component1, component2;


    public Dessert(String component1, String component2) {
        super("Десерт");
        this.component1 = component1;
        this.component2 = component2;
    }

    public String getComponent1() {
        return component1;
    }
    public String getComponent2() {
        return component2;
    }
    public void setComponent1(String component1) {
        this.component1 = component1;
    }
    public void setComponent2(String component2) {
        this.component2 = component2;
    }

    @Override
    public String toString() {
        return super.toString() + " с " + component1.toUpperCase() + " и " + component2.toUpperCase();
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден"); //Здесь при выводе this, вызывается автоматически метод toString(), который преобразует данный объект в строку(а именно в ИМЯ)
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj))
        {
            if(!(obj instanceof Dessert)) return false;
            return (component1.equals(((Dessert) obj).component1) && component2.equals(((Dessert) obj).component2));
        }
        else return false;
    }

}
