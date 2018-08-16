package com.example.android.project6_newsapp_stage1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<com.example.android.project6_newsapp_stage1.News> {

    /**
     * Construct a new (@link NewsAdapter).
     *
     * @param context of the app
     * @param news    is the list of news, which is the data source from the adapter
     */
    public NewsAdapter(Context context, List<com.example.android.project6_newsapp_stage1.News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);
        String date = currentNews.getArticleDate();
        String author = currentNews.getArticleAuthor();

        //Set the section in the Section TextView
        TextView sectionTextView = listItemView.findViewById(R.id.article_category);
        sectionTextView.setText(currentNews.getArticleCategory());

        //Set the title TextView with the headline.
        TextView titleTextView = listItemView.findViewById(R.id.article_title);
        titleTextView.setText(currentNews.getArticleTitle());

        //Set the date TextView by checking its availability and adjust layout accordingly
        TextView dateTextView = listItemView.findViewById(R.id.article_date);
        getDateTextView(dateTextView, date);

        //Set the author TextView by checking its availability and adjust layout accordingly
        TextView authorTextView = listItemView.findViewById(R.id.article_author);
        getAuthorTextView(authorTextView, author);

        return listItemView;

    }

    //This will check if the author is available and set it.
    //If it is not, then take out the whole author TextView from the list_item
    private void getAuthorTextView(TextView authorTextView, String author) {
        if (author == null) {
            authorTextView.setVisibility(View.GONE);
        } else {
            authorTextView.setVisibility(View.VISIBLE);
            authorTextView.setText(author);
        }
    }

    //This will check if the date is available and set it.
    //If it is not, then take out the whole date TextView from the list_item
    private void getDateTextView(TextView dateTextView, String date) {
        if (date == null) {
            dateTextView.setVisibility(View.GONE);
        } else {
            dateTextView.setVisibility(View.VISIBLE);

            //The following to set underline on the date text and set it to the date TextView
            SpannableString finalDate = new SpannableString(date);
            finalDate.setSpan(new UnderlineSpan(), 0, finalDate.length(), 0);
            dateTextView.setText(finalDate);
        }
    }
}