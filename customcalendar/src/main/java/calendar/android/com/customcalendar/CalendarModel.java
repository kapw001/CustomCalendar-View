package calendar.android.com.customcalendar;

import java.util.Date;

/**
 * Created by yasar on 18/4/18.
 */

public class CalendarModel {

    private Date date;

    private int color;

    private boolean isChecked = false;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
