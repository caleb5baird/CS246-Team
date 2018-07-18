package com.bicodetech.cineman;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import java.util.HashMap;

public class CustomAdapter extends ArrayAdapter<Result> {

    private ArrayList<Result> result;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView rating;
        TextView runtime;
        TextView summary;
        ImageView poster;
        ImageView sp1;
        ImageView sp2;
        ImageView sp3;
        ImageView sp4;
        ImageView rp1;
        ImageView rp2;
        ImageView rp3;
    }

    public CustomAdapter(ArrayList<Result> result, Context context) {
        super(context, R.layout.result_row, result);
        this.result = result;
        this.mContext=context;

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
            viewHolder.sp1 = (ImageView) convertView.findViewById(R.id.streamProvider1);
            viewHolder.sp2 = (ImageView) convertView.findViewById(R.id.streamProvider2);
            viewHolder.sp3 = (ImageView) convertView.findViewById(R.id.streamProvider3);
            viewHolder.sp4 = (ImageView) convertView.findViewById(R.id.streamProvider4);
            viewHolder.rp1 = (ImageView) convertView.findViewById(R.id.rentProvider1);
            viewHolder.rp2 = (ImageView) convertView.findViewById(R.id.rentProvider2);
            viewHolder.rp3 = (ImageView) convertView.findViewById(R.id.rentProvider3);

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

        String imgURL = result.getImage();
        imgURL = imgURL.substring(0, imgURL.length() - 9);
        imgURL = "https://images.justwatch.com" + imgURL + "s592";

        //get unique stream providers
        HashMap<String, Boolean> isDisplayed = new HashMap<String, Boolean>();
        isDisplayed.put("apple", false);
        isDisplayed.put("google", false);
        isDisplayed.put("vudu", false);
        isDisplayed.put("amazonPrime", false);
        isDisplayed.put("amazon", false);
        isDisplayed.put("hulu", false);
        isDisplayed.put("youtube", false);
        isDisplayed.put("netflix", false);
        int streamId = 1;
        int rentId = 1;


        viewHolder.title.setText(result.getTitle());
        viewHolder.rating.setText(result.getRating());
        viewHolder.runtime.setText(runtime);
        viewHolder.summary.setText(result.getSummary());
        new DownloadImageTask(viewHolder.poster).execute(imgURL);
        for (Provider provider : result.getProviders()) {
            Drawable icon = getProviderImage(provider.getProviderId(), isDisplayed);
            if (icon != null){
                if (provider.getMonotizationType().equals("flatrate")) {
                    switch (streamId++) {
                        case 1:
                            viewHolder.sp1.setImageDrawable(icon);
                            break;
                        case 2:
                            viewHolder.sp2.setImageDrawable(icon);
                            break;
                        case 3:
                            viewHolder.sp3.setImageDrawable(icon);
                            break;
                        case 4:
                            viewHolder.sp4.setImageDrawable(icon);
                            break;
                    }
                } else {
                    switch (rentId++) {
                        case 1:
                            viewHolder.rp1.setImageDrawable(icon);
                            break;
                        case 2:
                            viewHolder.rp2.setImageDrawable(icon);
                            break;
                        case 3:
                            viewHolder.rp3.setImageDrawable(icon);
                            break;
                    }
                }
            }
        }

        // Return the completed view to render on screen
        return convertView;
    }

    private Drawable getProviderImage(int providerId, HashMap<String, Boolean> isDisplayed) {
        Drawable result = null;
        switch (providerId){
            case 2:
                if (!isDisplayed.get("apple")) {
                    result = mContext.getResources().getDrawable(R.drawable.apple_itunes);
                    isDisplayed.put("apple", true);
                }
                break;
            case 3:
                if (!isDisplayed.get("google")){
                    result = mContext.getResources().getDrawable(R.drawable.google_play_movies);
                    isDisplayed.put("google", true);
                }
                break;
//            case 7:
//                if (!isDisplayed.get("vudo")){
//                    result = mContext.getResources().getDrawable(R.drawable.vudu);
//                    isDisplayed.put("vudo", true);
//                }
//                break;
            case 8:
                if (!isDisplayed.get("netflix")){
                    result = mContext.getResources().getDrawable(R.drawable.netflix);
                    isDisplayed.put("netflix", true);
                }
                break;
            case 9:
                if (!isDisplayed.get("amazonPrime")){
                    result = mContext.getResources().getDrawable(R.drawable.amazon_prime_video);
                    isDisplayed.put("amazonPrime", true);
                }
                break;
            case 10:
                if (!isDisplayed.get("amazon")){
                    result = mContext.getResources().getDrawable(R.drawable.amazon_video);
                    isDisplayed.put("amazon", true);
                }
                break;
            case 15:
                if (!isDisplayed.get("hulu")){
                    result = mContext.getResources().getDrawable(R.drawable.hulu);
                    isDisplayed.put("hulu", true);
                }
                break;
            case 192:
                if (!isDisplayed.get("youtube")){
                    result = mContext.getResources().getDrawable(R.drawable.youtube_premium);
                    isDisplayed.put("youtube", true);
                }
                break;
        }
        return result;
    }
}
