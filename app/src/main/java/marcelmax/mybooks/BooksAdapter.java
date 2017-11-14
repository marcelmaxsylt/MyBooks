package marcelmax.mybooks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

/**
 * Created by Marcel Laptop on 19.09.2017.
 */

public class BooksAdapter extends ArrayAdapter<Books> {

    public BooksAdapter(Context context, List<Books> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        /*
             Check if there is an existing list item view (called convertView) that we can reuse,
             otherwise, if convertView is null, then inflate a new list item layout
         */
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.books_list_item, parent, false);
        }

        /*
            Find the Book at the given position in the list of Books
         */
        Books currentBook = getItem(position);

        // AUTHOR
        TextView authorView = (TextView) listItemView.findViewById(R.id.tv_author);
        authorView.setText(currentBook.getAuthor());


        //BOOKTITLE
        TextView bookTitleView = (TextView) listItemView.findViewById(R.id.tv_bookTitle);
        bookTitleView.setText(currentBook.getBookTitle());


        //BOOKCOVER
        ImageView bookCoverView = (ImageView) listItemView.findViewById(R.id.iv_book_cover);



        return listItemView;
    }


}
