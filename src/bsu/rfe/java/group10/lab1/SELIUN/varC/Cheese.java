package bsu.rfe.java.group10.lab1.SELIUN.varC;

public class Cheese extends Food {

    public Cheese()
    {
        super("Cheese");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден"); //Здесь при выводе this, вызывается автоматически метод toString(), который преобразует данный объект в строку(а именно в ИМЯ)
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj))
        {
            if(obj instanceof Cheese) return true; //Если принадлежит Cheese
            else return false;
        }
        else return false;
    }
}
