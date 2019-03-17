package com.example.studentportal;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder>  {

    private List<Bookmark> mBookmarks;

    public BookmarkAdapter(List<Bookmark> mBookmarks) {this.mBookmarks = mBookmarks;
    }

    @NonNull
    @Override
    public BookmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        // Return a new holder instance
        BookmarkAdapter.ViewHolder viewHolder = new BookmarkAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter.ViewHolder viewHolder, int i) {
        Bookmark bookmark = mBookmarks.get(i);
        viewHolder.textView.setText(bookmark.getmBookmarkText());
//        viewHolder.textView.setText(bookmark.getmBookmarkURL());
    }

    @Override
    public int getItemCount() {
        return mBookmarks.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }



}

