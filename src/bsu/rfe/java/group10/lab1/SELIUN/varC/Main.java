package bsu.rfe.java.group10.lab1.SELIUN.varC;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws Exception{
	// write your code here
        boolean sort = false, calories = false; //Отвечают за наличие или отсутстивие специальных параметров

        Food[] breakfast = new Food[20];        //Хранит наш завтрак

        String arg = "";
        for(int i = 0; i < args.length; i++)    //Цикл на определения входных аргументов(и их дополнительных); Создание объектов классов с именем аргументов
        {
            arg = args[i];
            String parts[] = arg.split("/"); //Разбиваем на компоненты

            if(parts.length == 1 && (!calories || !sort)) //Проверяем наличие специальных параметров "-sort" "-calories"
            {
                if(parts[0].equals("-calories"))
                {
                    calories = true;
                    continue;
                }
                else if(parts[0].equals("-sort"))
                {
                    sort = true;
                    continue;
                }
            }

            try
            {
                Class myClass = Class.forName("bsu.rfe.java.group10.lab1.SELIUN.varC." + parts[0]);     //Из библиотеки reflect, мы создаем объект типа Class, имя которого мы ищем в нашем пакете
                if(parts.length == 1) //Если дополнительных параметров нет
                {
                    Constructor constructor = myClass.getConstructor();         //Из библиотеки reflect (Java Reflection API)
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


        if(sort == true) //Если присутствует параметр -sort
        {
            Arrays.sort(breakfast, new Comparator() {           //Используем Arrays(библиотеку), используем Comparator(библиотеку). Для сортировки массива breakfast типа Food
                public int compare(Object f1, Object f2)        //Реализуем анонимный класс(Переопределяем метод compare, сранивающий имена объектов Food, прямо здесь в коде)
                {
                    if (f1 == null) return 1;
                    if (f2 == null) return -1;
                    return (((Food) f1).getName().compareTo(((Food) f2).getName())); //Конкретное сравнение имен с помощью compareTo()
                }
            });
        }

        String[] FoodInBreakfastWithoutPovtoreniy = new String[20];                                //Здесь мы выделяем память под массивы для подсчета еды
        int[] amount_of_Food_in_Breakfast = new int[20];
        SchetchikOfFood(breakfast, FoodInBreakfastWithoutPovtoreniy, amount_of_Food_in_Breakfast); //Вызываем функцию подсчета элементов еды
        NepovtorFoodOUTPUT(FoodInBreakfastWithoutPovtoreniy, amount_of_Food_in_Breakfast);      //Вызываем функцию для вывода результатов
        System.out.println("---------------------------------------------------");

        for(Food item: breakfast) //Создали цикл который создает ссылку типа Food, которая ходит по всему массиву breakfast[20] и вызывает consume()
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

    public static void SchetchikOfFood(Food[] breakfast, String[] FoodInBreakfastWithoutPovtoreniy, int[] amount_of_Food_in_Breakfast)
    {
        for(int i: amount_of_Food_in_Breakfast)
        {
            amount_of_Food_in_Breakfast[i] = 0;
        }
        int amount_of_nepovtor_food = 0; //Отвечает за кол-во вообще имеющихся в завтраке неповторяющихся элементов продуктов
        for(int i = 0; i < breakfast.length; i++)
        {
            if(!(breakfast[i] == null))
            {
                boolean finded = false; //Переменная отвечающая за то, нашли ли мы такой же продукт в массиве неповторяющихся продуктов или нет
                for(int k = 0; FoodInBreakfastWithoutPovtoreniy[k] != null; k++)
                {

                    if(breakfast[i].toString().equals(FoodInBreakfastWithoutPovtoreniy[k])) //Если встретили в завтраке продукт, который уже был, то к кол-ву++, а finded = true
                    {
                        amount_of_Food_in_Breakfast[k]++;
                        finded = true;
                        break;
                    }
                    else finded = false; //Если же не нашли, продолжаем смотреть завтрак
                }
                if(!finded)
                {
                    FoodInBreakfastWithoutPovtoreniy[amount_of_nepovtor_food] = breakfast[i].toString();
                    amount_of_Food_in_Breakfast[amount_of_nepovtor_food]++;

                    amount_of_nepovtor_food++;
                }
                else continue;
            }
            else break;
        }
    }

    public static void NepovtorFoodOUTPUT(String[] Food, int[] amount)
    {
        System.out.println("Кол-во продуктов в завтраке:");
        for(int i = 0; i < Food.length; i++)
        {
            if(Food[i] != null)
            {
                System.out.println(Food[i] +": " + amount[i]);
            }
            else break;
        }
    }
}
