package five.project.bookcam.bookcam.mvc.controller.TabFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import five.project.bookcam.bookcam.R;
import five.project.bookcam.bookcam.mvc.model.FourTab01Adapter;
import five.project.bookcam.bookcam.mvc.model.FourTab_Sellingbook;

/**
 * Created by user on 2018/3/19.
 */

public class FourFragment_tab01 extends Fragment {


    private ListView listV;
    private FourTab01Adapter adapter_sell;

    List listview_sell = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_frag_tab01, null);


        listV= view.findViewById(R.id.listview_sell);

        listview_sell.add(new FourTab_Sellingbook(1,"A",""));
        listview_sell.add(new FourTab_Sellingbook(1,"B","7:00"));
        listview_sell.add(new FourTab_Sellingbook(2,"C",""));
        listview_sell.add(new FourTab_Sellingbook(2,"D","9:00"));
        listview_sell.add(new FourTab_Sellingbook(0,"E",""));
        listview_sell.add(new FourTab_Sellingbook(0,"F","9:00"));

        adapter_sell= new FourTab01Adapter(view.getContext(),listview_sell);
        listV.setAdapter(adapter_sell);






        return view;
    }
}