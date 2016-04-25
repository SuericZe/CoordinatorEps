package suericze.coordinatoreps.appbarlayout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import suericze.coordinatoreps.R;

/**
 * Description:RecyclerView 适配器
 */

public class MyCusRecyclerAdapter extends RecyclerView.Adapter<MyCusRecyclerAdapter.MyViewHolder> {


    private Context context;
    private String[] items;

    public MyCusRecyclerAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.title.setText(items[position]);

    }

    @Override
    public int getItemCount() {
        return null == items ? 0 : items.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view;
        }
    }

}
