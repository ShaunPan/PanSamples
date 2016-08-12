package cn.pan.slidesample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Author: Pan
 * Date:   2016/8/11
 * Description:
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public DataAdapter( Context context,List<String> list) {
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataViewHolder(mInflater.inflate(R.layout.item_text, null));
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size()-1;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public DataViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}
