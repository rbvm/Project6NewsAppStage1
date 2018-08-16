package com.example.android.project6_newsapp_stage1;

public class News {

    private String mArticleCategory;

    private String mArticleTitle;

    private String mArticleAuthor;

    private String mArticleDate;

    private final String mArticleUrl;

    /**
     * Create a new News object.
     *
     * @param articleCategory is the category of the article
     * @param articleTitle    is the title of the article
     * @param articleAuthor   is the author of the article
     * @param articleDate     is the author of the article
     * @param articleUrl      is the web address of the article
     */
    public News(String articleCategory, String articleTitle, String articleAuthor, String articleDate, String articleUrl) {
        mArticleCategory = articleCategory;
        mArticleTitle = articleTitle;
        mArticleAuthor = articleAuthor;
        mArticleDate = articleDate;
        mArticleUrl = articleUrl;
    }

    /**
     * Returns the article category
     */
    public String getArticleCategory() {
        return mArticleCategory;
    }

    /**
     * Returns the article title
     */
    public String getArticleTitle() {
        return mArticleTitle;
    }

    /**
     * Returns the article author
     */
    public String getArticleAuthor() {
        return mArticleAuthor;
    }

    /**
     * Returns the article date
     */
    public String getArticleDate() {
        return mArticleDate;
    }

    /**
     * Returns the article url
     */
    public String getArticleUrl() {
        return mArticleUrl;
    }

}
