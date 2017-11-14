package marcelmax.mybooks;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity { //implements LoaderManager.LoaderCallbacks<List<Books>>


    /**
     * URL for books data from Google Books API
     * "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1";
     * "https://www.googleapis.com/books/v1/volumes?orderBy=relevance&q=computer+science+deutsch";
     * "https://www.googleapis.com/books/v1/volumes?&q=";
     */

    public static String BOOKS_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1";

    private Button btnSearch;
    private EditText editText;
    private BooksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find a reference to the {@link ListView} in the layout
        ListView booksListView = (ListView) findViewById(R.id.list);

        mAdapter = new BooksAdapter(this, new ArrayList<Books>());

        booksListView.setAdapter(mAdapter);

        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Books currentBook = mAdapter.getItem(position);

                Uri bookURI = Uri.parse(currentBook.getUrlPreview());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookURI);

                startActivity(websiteIntent);
            }
        });

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.loadingSpinner);
        progressBar.setVisibility(View.GONE);
        BooksAsyncTask task = new BooksAsyncTask();
        task.execute(BOOKS_REQUEST_URL);

        ///////////////
        btnSearch = (Button) findViewById(R.id.btn_Search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Searchbutton","is clicked");

            }
        });


    }


    private class BooksAsyncTask extends AsyncTask <String,Void,List<Books>>{

        @Override
        protected List<Books> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Books> result = QueryUtils.fetchBooksData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Books> data) {
            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }


    }



}
    /*
    Sie können diesen Schlüssel in Ihrer Anwendung einsetzen, indem Sie ihn als Parameter key=API_KEY festlegen.
     Mein Api Schlüssel AIzaSyBBKgLpWNQVfDi5E00zTWKxAR-EGGSkldo
https://console.developers.google.com/apis/credentials?project=my-books-180313
    serverAddress = new URL("http://maps.google.com/maps/geo?q="
                    + Double.toString(loc.getLatitude()) + ","
                    + Double.toString(loc.getLongitude())
                    + "&output=xml&oe=utf8&sensor=true&key="
                    + R.string.GOOGLE_MAPS_API_KEY);

     */