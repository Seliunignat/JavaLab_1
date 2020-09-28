package bsu.rfe.java.group10.lab1.SELIUN.varC;
import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        Food[] breakfast = new Food[20];

        int itemSoFar = 0;
        String arg = "";
        for(int i = 0; i < args.length; i++)
        {
            arg = args[i];
            String parts[] = arg.split("/");
            if(parts[0].equals("Cheese"))
            {
                breakfast[itemSoFar] = new Cheese(); //У сыра нет дополнительных аргументов
            }
            else if(parts[0].equals("Apple"))
            {
                breakfast[itemSoFar] = new Apple(parts[1]); //У яблока один дополнительный аргумент
            }//Добавить анализ других продуктов для завтрака
            itemSoFar++;
        }

        for(Food item: breakfast) //Создали цикл который создает ссылку типа Food, которая ходит по всему массиву breakfast[20]
        {
            if(item!=null) //Если элемент не null - употребляем продукт
            {
                item.consume();
            }
            else //Если же дошли до null, значит дошли до конца имеющихся в завтраке продуктов
                break;
        }

        /*for(int i =0; i< args.length; i++) //Цикл на вывод всех аргументов
        {
            System.out.println(args[i]);
        }*/

        System.out.println("Всего хорошего!");
    }
}
