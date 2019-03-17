package com.example.studentportal;

import android.os.Parcel;
import android.os.Parcelable;

public class Bookmark implements Parcelable {

    String mBookmarkText;
    String mBookmarkURL;

    public String getmBookmarkURL() {
        return mBookmarkURL;
    }

    public void setmBookmarkURL(String mBookmarkURL) {
        this.mBookmarkURL = mBookmarkURL;
    }


//    @Override
//    public String toString() {    return mBookmarkText ;  }

    public String getmBookmarkText() {
        return mBookmarkText;
    }

    public void setmBookmarkText(String mBookmarkText) {
        this.mBookmarkText = mBookmarkText;
    }

    public Bookmark(String mBookmarkText, String mBookmarkURL) {
        this.mBookmarkURL = mBookmarkURL;
        this.mBookmarkText = mBookmarkText;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mBookmarkURL);
        dest.writeString(this.mBookmarkText);
    }

    protected Bookmark(Parcel in) {
        this.mBookmarkURL = in.readString();
        this.mBookmarkText = in.readString();
    }

    public static final Parcelable.Creator<Bookmark> CREATOR = new Parcelable.Creator<Bookmark>() {
        @Override
        public Bookmark createFromParcel(Parcel source) {
            return new Bookmark(source);
        }

        @Override
        public Bookmark[] newArray(int size) {
            return new Bookmark[size];
        }
    };
}
