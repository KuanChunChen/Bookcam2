package five.project.bookcam.bookcam.mvc.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import five.project.bookcam.bookcam.R;

/**
 * Created by user on 2018/3/19.
 */

public class FourTab01Adapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<String> list_sell;

    public FourTab01Adapter(Context context, List<String> list_sell){
        layoutInflater = LayoutInflater.from(context);
        this.list_sell=list_sell;
    }

    @Override
    public int getCount() {
        return list_sell.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list_sell.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return list_sell.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //文字的物件
        ViewHolder holder = null;

        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder(
                    (TextView) convertView.findViewById(R.id.topic),
                    (TextView) convertView.findViewById(R.id.detail),
                    (ImageView) convertView.findViewById(R.id.ivImage)
            );
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

       /* int color_title[] = {Color.WHITE,Color.WHITE,Color.YELLOW};
        int color_time[] = {Color.WHITE,Color.WHITE,Color.YELLOW};
        int color_back[] = {Color.BLACK,Color.BLUE,Color.BLACK};
        int time_vis[] = {View.VISIBLE,View.GONE,View.VISIBLE};*/


        FourTab_Sellingbook  fourTab_Sellingbook = (FourTab_Sellingbook)getItem(position);

        holder.txtTitle.setText(fourTab_Sellingbook.getName());
        //holder.txtTitle.setTextColor(color_title[0]);
        //holder.txtTitle.setBackgroundColor(color_back[1]);
        //holder.txtDetail.setText(fourTab_Sellingbook.getTime());
        holder.imaView.setImageResource(R.mipmap.sell);
        //holder.txtDetail.setTextColor(color_time[0]);
        //holder.txtDetail.setVisibility(time_vis[2]);





        return convertView;
    }




    //inner class  建構LISTVIEW的文字
    private class ViewHolder {
        TextView txtTitle;
        TextView txtDetail;
        ImageView imaView;
        public ViewHolder(TextView txtTitle, TextView txtDetail , ImageView imaView){
            this.txtTitle = txtTitle;
            this.txtDetail = txtDetail;
            this.imaView=imaView;
        }
    }



}


