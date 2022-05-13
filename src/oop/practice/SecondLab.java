/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.practice;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Neru
 */
public class SecondLab {
    private static Scanner input = null;
    
    public static void startFirstPart() throws IOException, ClassNotFoundException {
        //Загальне завдання
        //Розробити клас, що серіалізується, для зберігання параметрів і результатів
        //обчислень.
        //Використовуючи агрегування, розробити клас для знаходження рішення
        //задачі.
        //Розробити клас для демонстрації в діалоговому режимі збереження та
        //відновлення стану об'єкта, використовуючи серіалізацію. Показати особливості
        //використання transient полів.
        //Розробити клас для тестування коректності результатів обчислень та
        //серіалізації/десеріалізації.
        //Використовувати докладні коментарі для автоматичної генерації
        //документації засобами javadoc.
        
        System.out.println(
        "====================\n" +
        "LAB 2. PART 1. START\n" +
        "====================\n");
        
        System.out.println("CREATE A POINT OBJECT");
        
        input = new Scanner(System.in);
        System.out.println("Input x: ");
        int x = input.nextInt();
        System.out.println("Input y: ");
        int y = input.nextInt();
        
        Point p1 = new Point(x, y);                 //object to serialize
        System.out.println("POINT: " + p1);
        
        Point.serialize(p1, "save");                //serialization
        System.out.println("SERIALIZATION...");
        
        Point p2 = Point.deserialize("save");       //deserialization
        System.out.println("DESERIALIZATION...");
        
        
        System.out.println("DESERIALIZATED POINT: " + p2);  //deserialized object
        
        System.out.println(
        "====================\n" +
        "LAB 2. PART 1 END\n" +
        "====================\n");
    }
    
    public static void startSecondPart() {
        //2.3 Індивідуальне завдання
        //Определить количество единиц в двоичном представлении целой части
        //среднего арифметического значения функции 1000*sin(α) для четырех
        //произвольных аргументов.
        
        System.out.println(
        "====================\n" +
        "LAB 2. PART 2. START\n" +
        "====================\n");
        
        //сумма 4 значений функций 100*sin(n)
        int n = 0;
        for (int i = 0; i < 4;) {
            System.out.printf("ENTER " + ++i + " NUMBER: ");
            n += 1000 * Math.sin(input.nextInt());
        }
        
        //среднее арифметическое 
        n /= 4;
        System.out.println(n);

        //подсчет к-ва единиц в двоичном числе
        int amount = 0;
        while (n >= 1)
        {
        if (n % 2 == 1) amount++;
        n /= 2;
        }
        System.out.println("AMOUNT OF NUMBERS \'1\' in number: " + amount);
        
        System.out.println(
        "====================\n" +
        "LAB 2. PART 2 END\n" +
        "====================\n");
    }
}