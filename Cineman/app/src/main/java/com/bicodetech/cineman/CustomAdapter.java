package com.bicodetech.cineman;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Result> implements View.OnClickListener{

    private ArrayList<Result> result;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView rating;
        TextView runtime;
        TextView summary;
        ImageView poster;
    }

    public CustomAdapter(ArrayList<Result> result, Context context) {
        super(context, R.layout.result_row, result);
        this.result = result;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Result result=(Result)object;

//        switch (v.getId())
//        {
//            case R.id.result_row:
//                Snackbar.make(v, "Release date " +result.getFeature(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Result result = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View resultV;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.result_row, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.Title);
            viewHolder.rating = (TextView) convertView.findViewById(R.id.Rating);
            viewHolder.runtime = (TextView) convertView.findViewById(R.id.Runtime);
            viewHolder.summary = (TextView) convertView.findViewById(R.id.Summary);
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.Poster);

            resultV=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            resultV=convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
//        lastPosition = position;

        // Get the runtime string
        int hours = result.getRuntime()/60;
        int minuets = result.getRuntime()%60;
        String runtime = hours + "hr " + minuets + "min";

        //get unique stream providers
        //get the id for the Sahara poster

        viewHolder.title.setText(result.getTitle());
        viewHolder.rating.setText(result.getRating());
        viewHolder.runtime.setText(runtime);
        viewHolder.summary.setText(result.getSummary());
        viewHolder.poster.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sahara));
//        viewHolder.info.setOnClickListener(this);
//        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

    private Drawable getProviderImage(int providerId) {
        Drawable result;
        switch (providerId){
            case 2:
                result = mContext.getResources().getDrawable(R.drawable.apple_itunes);
                break;
            case 3:
                result = mContext.getResources().getDrawable(R.drawable.google_play_movies);
                break;
            case 7:
                result = mContext.getResources().getDrawable(R.drawable.vudu);
                break;
            case 9:
                result = mContext.getResources().getDrawable(R.drawable.amazon_prime_video);
                break;
            case 10:
                result = mContext.getResources().getDrawable(R.drawable.amazon_video);
                break;
            case 15:
                result = mContext.getResources().getDrawable(R.drawable.hulu);
                break;
            case 192:
                result = mContext.getResources().getDrawable(R.drawable.youtube_premium);
                break;
            default:
                result = null;
        }
        return result;
    }
}
