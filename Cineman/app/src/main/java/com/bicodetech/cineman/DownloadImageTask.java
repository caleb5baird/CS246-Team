/**
 * Searches for and downloads movie images from JustWatch API
 *
 * @author Caleb Baird
 */


package com.bicodetech.cineman;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;

    /**
     * Inputs imageView into local variable
     *
     * @param imageView sets imageView to this variable.
     */
    public DownloadImageTask(ImageView imageView){
        this.imageView = imageView;
    }

    /*
        doInBackground(Params... params)
            Override this method to perform a computation on a background thread.
     */

    /**
     * Searches for movie image at defined URL destination.
     *
     * @param urls urls of movie images to be retrieved.
     * @return logo bitmap of movie image returned.
     * @throws Exception If image cannot be returned throws
     *                   throws exception.
     */
    protected Bitmap doInBackground(String...urls){
        String urlOfImage = urls[0];
        Bitmap logo = null;
        try{
            InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
            logo = BitmapFactory.decodeStream(is);
        }catch(Exception e){ // Catch the download exception
            e.printStackTrace();
        }
        return logo;
    }

    /*
        onPostExecute(Result result)
            Runs on the UI thread after doInBackground(Params...).
     */

    /**
     * Inputs image data into user view.
     *
     * @param result data to be updated in view
     */
    protected void onPostExecute(Bitmap result){
        imageView.setImageBitmap(result);
    }
}
