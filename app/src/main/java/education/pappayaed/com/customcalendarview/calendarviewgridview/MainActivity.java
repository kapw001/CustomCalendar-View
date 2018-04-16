package education.pappayaed.com.customcalendarview.calendarviewgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import education.pappayaed.com.customcalendarview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarCustomView mView = (CalendarCustomView)findViewById(R.id.custom_calendar);
    }
}
