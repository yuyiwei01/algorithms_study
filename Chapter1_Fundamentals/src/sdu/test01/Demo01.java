package sdu.test01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        //System.out.println(simpleDateFormat.format(new Date()));

        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println(format);
    }
}
