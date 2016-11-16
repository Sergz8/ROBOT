/**
 * Created by Sergey on 07.11.2016. Project RobotFx1
 */
//Нужен для того чтоб можно было хранить строки в себе

import java.io.BufferedReader;
//Это исключение создается, когда попытка доступа к файлу,
//не существующему на диске, заканчивается неудачей
import java.io.FileNotFoundException;
//Чтоб можно было чиать тектсовой файл
import java.io.FileReader;
//Чтоб можно было записывать в  тексотовой файл
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RobotFx {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        RobotFx io = new RobotFx();
        //Читать из файла
        //Писать в файл
        io.processingFiles();
    }

    private void processingFiles() throws FileNotFoundException, IOException {
        String f1 = "text1.txt";
        String f2 = "text2.txt";
        //Указываю путь на который будет ссылаться объект fr
        FileReader fr = new FileReader(f1);
        //Объект br будет хранить в себе строки на которые ссылается объект fr
        BufferedReader br = new BufferedReader(fr);
        //Переменная str получает содержимое файла
        String str = br.readLine();
        String result = "UTF-8";
        //Пока переменная str не равна нулевой строке из файла text1.txt
        while (str != null) {
            //lineSeparator - Переменная которая будет делать перевод строки
            String lineSeparator = System.getProperty("line.separator");
            //Тогда в перменную result которая изначально равна нулю
            //присвоить эту строку и записать  в эту перменную
            result += lineSeparator + str;
            //Снова прочитать строку
            str = br.readLine();
            //System.out.println();
        }
        //Создается обьект типа FileWriter
        //Его конструктору передается имя файла, чтоб
        //сразу его создать и открыть для записи
        FileWriter fw = new FileWriter(f2);
        //Записываем в текстовой файл text2 содержимое всех строки из файла text2.txt
        fw.write(result);
        //Закрываем потоки
        fw.close();
        fr.close();
        br.close();
    }
}
