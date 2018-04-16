package education.pappayaed.com.customcalendarview.recyclercalendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import education.pappayaed.com.customcalendarview.EventObjects;
import education.pappayaed.com.customcalendarview.R;

/**
 * Created by yasar on 13/4/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolders> {

    private List<Date> monthlyDates;
    private Calendar currentDate;
    private List<EventObjects> allEvents;
    private Context context;
    private EventHighlight eventHighlight;

    public RecyclerAdapter(Context context, List<Date> monthlyDates, Calendar currentDate, List<EventObjects> allEvents, EventHighlight eventHighlight) {

        this.monthlyDates = monthlyDates;
        this.currentDate = currentDate;
        this.allEvents = allEvents;
        this.context = context;
        this.eventHighlight = eventHighlight;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_cell_layout, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {


        Date mDate = monthlyDates.get(position);
        Calendar dateCal = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        dateCal.setTime(mDate);


        int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCal.get(Calendar.MONTH) + 1;
        int displayYear = dateCal.get(Calendar.YEAR);

        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        int currentYear = currentDate.get(Calendar.YEAR);
        holder.calendar_date.setText(String.valueOf(dayValue));

        if (dayValue == c.get(Calendar.DAY_OF_MONTH) && displayMonth == c.get(Calendar.MONTH) + 1 && displayYear == dateCal.get(Calendar.YEAR)) {
            holder.calendar_date.setTextColor(Color.BLUE);
        }

        int day = dateCal.get(Calendar.DAY_OF_WEEK);

        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            holder.itemView.setBackgroundColor(Color.parseColor("#d4d4d4"));
            holder.calendar_date.setAlpha(.5f);
        }

        if (displayMonth == currentMonth && displayYear == currentYear) {
//            view.setBackgroundColor(Color.parseColor("#FF5733"));
        } else {
//            view.setBackgroundColor(Color.parseColor("#cccccc"));
            holder.calendar_date.setText("");
        }

        Calendar eventCalendar = Calendar.getInstance();

//        Log.e(TAG, "getView: " + allEvents.size());

        holder.event.setVisibility(View.GONE);

        for (int i = 0; i < allEvents.size(); i++) {
            eventCalendar.setTime(allEvents.get(i).getDate());
            if (dayValue == eventCalendar.get(Calendar.DAY_OF_MONTH) && displayMonth == eventCalendar.get(Calendar.MONTH) + 1
                    && displayYear == eventCalendar.get(Calendar.YEAR)) {
//                holder.event.setBackgroundColor(allEvents.get(i).getColor());


                switch (eventHighlight) {
                    case CIRCLE:
                        setCircleColor(holder.event, allEvents.get(i).getColor());
                        holder.event.setVisibility(View.VISIBLE);
                        break;
                    case RECTANGLE:
                        holder.itemView.setBackgroundColor(allEvents.get(i).getColor());
                        holder.calendar_date.setTextColor(Color.WHITE);
                        break;
                }


            }
        }

//        holder.event.setText(itemList.get(position).getPhoto());
    }


    private void setCircleColor(View view, @ColorInt int color) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.OVAL);
        shape.setColor(color);
        shape.setStroke(2, color);
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(shape);
        } else {
            view.setBackground(shape);
        }
    }

    @Override
    public int getItemCount() {
        return this.monthlyDates.size();
    }


    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView calendar_date;
        public View event;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            calendar_date = (TextView) itemView.findViewById(R.id.calendar_date_id);
            event = (View) itemView.findViewById(R.id.event_id);
        }

        @Override
        public void onClick(View view) {

//            switch (eventHighlight) {
//                case CIRCLE:
//                    event.setVisibility(View.VISIBLE);
//                    break;
//                case RECTANGLE:
//                    itemView.setBackgroundColor(Color.BLUE);
//                    break;
//            }

            Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}