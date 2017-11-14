package marcelmax.mybooks;

import android.media.Image;
import android.view.ViewDebug;

/**
 * Created by Marcel Laptop on 19.09.2017.
 */

public class Books {

    private String author;

    private String bookTitle;

    private String bookCover;

    private String urlPreview;

    // CONSTRUCTOR
    /*
    Constructs a new Link {@Link Earthquake} object
    @param author is the authors Name
    @param bookTitle is the book title of the book
    @param bookCover is the cover of the book
    */
    public Books(String author, String bookTitle) {
        this.author = author;
        this.bookTitle = bookTitle;
    }

    public Books(String author, String bookTitle, String bookCover) {
        this.author = author;
        this.bookTitle = bookTitle;
        this.bookCover = bookCover;
    }

    public Books(String author, String bookTitle, String bookCover, String urlPreview) {
        this.author = author;
        this.bookTitle = bookTitle;
        this.bookCover = bookCover;
        this.urlPreview = urlPreview;
    }

    //GETTER
    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookCover() {
        return bookCover;
    }

    public String getUrlPreview() {
        return urlPreview;
    }

    @Override
    public String toString(){
        return "Author: " + this.getAuthor() + "\nTitle: " + this.bookTitle + "\nCover: "
                + this.bookCover + "\nUrl: " + this.urlPreview + "";
    }
}
