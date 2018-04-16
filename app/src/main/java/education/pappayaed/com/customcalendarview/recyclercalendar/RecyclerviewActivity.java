package education.pappayaed.com.customcalendarview.recyclercalendar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import calendar.android.com.customcalendar.CalendarCustomViewRecycler;
import calendar.android.com.customcalendar.CalendarUtils;
import calendar.android.com.customcalendar.EventHighlight;
import calendar.android.com.customcalendar.EventObjects;
import calendar.android.com.customcalendar.onItemClick;
import education.pappayaed.com.customcalendarview.R;

public class RecyclerviewActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerviewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        CalendarCustomViewRecycler calendarCustomViewRecycler = (CalendarCustomViewRecycler) findViewById(R.id.custom_calendar);

        calendarCustomViewRecycler.setEventHighlight(EventHighlight.CIRCLE);


        final List<EventObjects> mEvents = new ArrayList<>();

        EventObjects eventObjects = new EventObjects("Test", CalendarUtils.convertStringToDate("14-04-2018"), Color.RED);

        mEvents.add(eventObjects);

        EventObjects eventObjects1 = new EventObjects("Test Another", CalendarUtils.convertStringToDate("14-04-2018"), Color.RED);

        mEvents.add(eventObjects1);

        EventObjects eventObjects2 = new EventObjects("sdfsdfsest", CalendarUtils.convertStringToDate("13-04-2018"), Color.BLUE);

        mEvents.add(eventObjects2);

        EventObjects eventObjects3 = new EventObjects("sdfsdfsest ok", CalendarUtils.convertStringToDate("13-04-2018"), Color.BLUE);

        mEvents.add(eventObjects3);

        calendarCustomViewRecycler.setEvents(mEvents);


        calendarCustomViewRecycler.setOnItemClick(new onItemClick() {
            @Override
            public void onItemClick(View view, int position, Object o) {

                Date mDate = ((Date) o);

                List<EventObjects> mList = CalendarUtils.getParticularDateEvents(mDate, mEvents);


                for (EventObjects objects : mList
                        ) {

                    Log.e(TAG, "onItemClick: " + objects.getMessage());
                }


//                Toast.makeText(view.getContext(), "Main " + ((Date) o).getDate(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
