package five.project.bookcam.bookcam.mvc.controller.TabFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import five.project.bookcam.bookcam.R;

/**
 * Created by user on 2018/2/26.
 */

public class FourFragment extends Fragment {

    TabHost tabHost;
    FragmentManager fragmentMgr = getFragmentManager();
    FragmentTransaction fragmentTrans = fragmentMgr.beginTransaction();
    FourFragment_tab01 tabSelling= new FourFragment_tab01();

    public static FourFragment instance() {
        FourFragment view = new FourFragment();
        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4 ,null);
        init(view);
        return view;
    }

    public void init(View w){

        tabHost = w.findViewById(R.id.tabHost2);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("賣書專區").setIndicator("賣書專區").setContent(R.id.tabSelling));  //輸出 LinearLayout內容
        tabHost.addTab(tabHost.newTabSpec("許願池").setIndicator("許願池").setContent(R.id.tabWishing));     //輸出 LinearLayout內容
        tabHost.setCurrentTab(0);//從第一頁開始


    }
}