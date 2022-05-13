package oop.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Neru
 */
public class Point implements Serializable{
    
    private int x;
    private int y;
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * 
     * @return возвращает координату точки на оси X
     */
    public int getX() { return x; }
    
    /**
     * 
     * @return вовзращает координату точки на оси Y
     */
    public int getY() { return y; }
    
    /**
     * 
     * @return возвращает координаты точки представлены строкой
     */
    public String toString() {
        return "x:" + x + ", y:" + y;
    }
    
    /**
     * 
     * @param other точка до которой нужно расчитать расстояние
     * @return возвращает double расстояние до точки other
     */
    public double distance(Point other) {
        return
        Math.sqrt(
            Math.pow(this.getX() - other.getX(), 2) +
            Math.pow(this.getY() - other.getY(), 2)
        );
    }
    
    /**
     * 
     * @param point обьект класса Point который нужно преобразовать в последовательность байт
     * @param filename строка в которой нужно указать путь и имя сохраняемого файла
     * @throws IOException 
     */
    static void serialize(Point point, String filename) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filename);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(point);
        } finally {
            if (oos != null) oos.close();
            if (fos != null) fos.close();
        }
    }
    
    /**
     * 
     * @param filename путь и имя файла преобразованного в последовательность байт
     * @return обьект класса Point
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    static Point deserialize(String filename) throws IOException, ClassNotFoundException{
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            return (Point)ois.readObject();
        } finally {
            if (ois != null) ois.close();
            if (fis != null) fis.close();
        }
    }
}
