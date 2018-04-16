package education.pappayaed.com.customcalendarview.recyclercalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import education.pappayaed.com.customcalendarview.R;

public class RecyclerviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        CalendarCustomViewRecycler calendarCustomViewRecycler = (CalendarCustomViewRecycler) findViewById(R.id.custom_calendar);

        calendarCustomViewRecycler.setEventHighlight(EventHighlight.CIRCLE);

    }
}
