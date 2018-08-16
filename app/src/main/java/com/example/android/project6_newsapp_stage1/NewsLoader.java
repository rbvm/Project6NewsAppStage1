package com.example.android.project6_newsapp_stage1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    String newsUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        newsUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (newsUrl == null) {
            return null;
        }
        List<News> result = QueryUtils.fetchNewsItemsData(newsUrl);
        return result;
    }
}
