package methods;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helpers {


    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        String currentDate = dateFormat.format(calendar.getTime());
        return currentDate;

    }

    public String getOldDate(int amount) {
        // returns and old date accourding to the current date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, (amount)*(-1));
        String date = dateFormat.format(calendar.getTime());
        return date;
    }


}
