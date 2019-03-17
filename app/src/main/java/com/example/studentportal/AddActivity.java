package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity  {

    //instance variables
    private Button button;
    private List<Bookmark> mBookmarks;
    private BookmarkAdapter mAdapter;

    private EditText mBookmarkView;
    private EditText mBookmarkViewURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialize the instance variables
        mBookmarkView = findViewById(R.id.editText_add);
        mBookmarkViewURL = findViewById(R.id.editURL_add);
        mBookmarks = new ArrayList<>();

        mBookmarkViewURL.setText("https://");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mBookmarkView.getText().toString();
                String url = mBookmarkViewURL.getText().toString();
                Bookmark newBookmark = new Bookmark(title, url);
                //Check if some text has been added
                if (!(TextUtils.isEmpty(title))) {
                    mBookmarks.add(newBookmark);

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(MainActivity.EXTRA_BOOKMARK, newBookmark);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    //Show a message to the user if the textfield is empty
                    Snackbar.make(view, "Please enter some text in the textfield", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
