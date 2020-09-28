package bsu.rfe.java.group10.lab1.SELIUN.varC;
import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        Food[] breakfast = new Food[20];

        String arg = "";
        for(int i = 0; i < args.length; i++)
        {
            arg = args[i];
            String parts[] = arg.split("/"); //Разбиваем на компоненты

            try
            {
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.SELIUN.varC." + parts[0]);     //Из библиотеки reflect, мы создаем объект типа Class, имя которого мы ищем в нашем пакете
                if(parts.length == 1) //Если дополнительных параметров нет
                {
                    Constructor constructor = myClass.getConstructor();         //Из библиотеки reflect
                    breakfast[i] = (Food)constructor.newInstance();
                }
                else if(parts.length == 2) //Есть дополнительный параметр в parts[1]
                {
                    Constructor constructor = myClass.getConstructor(String.class);         //Создаем конструктор, в который потом отправлять будем один аргумент
                    breakfast[i] = (Food)constructor.newInstance(parts[1]);         //Создаем объект типа Food, преобразованный от типа Constructor(с аругментом из parts[1])
                }
            }
            catch (ClassNotFoundException e)
            {
                continue;
            }
            catch (NoSuchMethodException e)
            {
                System.out.println("ОШИБКА: Не найден нужный метод!");
            }
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
