package com.knightcube.samples.booklistingapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Book> books;
    private static EditText userInput;
    private ProgressDialog pD;
    private BookAdapter bookAdapter;
    private TextView mEmptyStateTextView;
    private ListView lv;
    private ImageButton searchButton;
    private String url = "https://www.googleapis.com/books/v1/volumes?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        searchButton = (ImageButton) findViewById(R.id.search_btn);
        userInput = (EditText) findViewById(R.id.user_input);
        lv = (ListView) findViewById(R.id.book_list);
        books = new ArrayList<Book>();
        lv.setEmptyView(mEmptyStateTextView);

        changeUiIfNetworkNotAvailable();
    }

    public void getResults(View view) {
        changeUiIfNetworkNotAvailable();
        url = url + "q=" + userInput.getText().toString().replaceAll("\\s+", "");
        GetBooks getBooks = new GetBooks();
        getBooks.execute();
        books.clear();
        hideKeyboard();
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((findViewById(R.id.relative_layout)).getWindowToken(), 0);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void changeUiIfNetworkNotAvailable() {
        if (!isNetworkAvailable()) {
            mEmptyStateTextView.setText(R.string.no_internet_message);
            searchButton.setEnabled(false);
            userInput.setEnabled(false);
        } else {
            mEmptyStateTextView.setText(R.string.default_text);
            searchButton.setEnabled(true);
            userInput.setEnabled(true);
        }

    }

    private class GetBooks extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pD = new ProgressDialog(MainActivity.this);
            pD.setMessage("Please wait...");
            pD.setCancelable(false);
            pD.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {

            HttpHandler handler = new HttpHandler();
            String jsonStr = handler.makeServiceCall(url);

            if (jsonStr != null) {
                try {

                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray itemsJsonArray = null;
                    itemsJsonArray = jsonObject.getJSONArray("items");
                    String bookTitle;
                    String bookAuthor;
                    String bookDescription;
                    for (int i = 0; i < itemsJsonArray.length(); i++) {
                        JSONObject bookJsonObject = itemsJsonArray.getJSONObject(i);
                        JSONObject bookVolumeInfo = bookJsonObject.getJSONObject("volumeInfo");
                        if (bookVolumeInfo.has("title"))
                            bookTitle = bookVolumeInfo.getString("title");
                        else
                            bookTitle = "Unknown";

                        if (bookVolumeInfo.has("authors"))
                            bookAuthor = bookVolumeInfo.getString("authors");
                        else
                            bookAuthor = "Unknown";

                        if (bookVolumeInfo.has("description"))
                            bookDescription = bookVolumeInfo.getString("description");
                        else
                            bookDescription = "Unknown";

                        bookAuthor = bookAuthor.replace('[', '-');
                        bookAuthor = bookAuthor.replace('\"', ' ');
                        bookAuthor = bookAuthor.replace(']', ' ');
                        books.add(new Book(bookTitle, bookAuthor, bookDescription));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return books;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (pD.isShowing())
                pD.dismiss();
            if (books.size() == 0)
                mEmptyStateTextView.setText("No Books Found!");
            ListView bookListView = (ListView) findViewById(R.id.book_list);
            BookAdapter bookAdapter = new BookAdapter(MainActivity.this, books);
            bookListView.setAdapter(bookAdapter);
            url = "https://www.googleapis.com/books/v1/volumes?";
        }
    }
}
