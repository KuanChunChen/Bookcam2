package five.project.bookcam.bookcam.mvc.controller;

/**
 * Created by user on 2018/1/31.
 */


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import five.project.bookcam.bookcam.R;
import five.project.bookcam.bookcam.mvc.controller.TabFragment.FifthFragment;
import five.project.bookcam.bookcam.mvc.controller.TabFragment.FirstFragment;
import five.project.bookcam.bookcam.mvc.controller.TabFragment.FourFragment;
import five.project.bookcam.bookcam.mvc.controller.TabFragment.SecondFragment;
import five.project.bookcam.bookcam.mvc.controller.TabFragment.ThreeFragment;
import five.project.bookcam.bookcam.mvc.model.MyFragmentAdapter;

public class MainFragment extends FragmentActivity implements
        ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    public FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentArray[] = { FirstFragment.class, SecondFragment.class,ThreeFragment.class, FourFragment.class,FifthFragment.class};
    private int imageViewArray[] = { R.drawable.tab_home_btn, R.drawable.tab_view_btn,R.drawable.tab_camera_btn,R.drawable.tab_hope_btn,R.drawable.tab_setting_btn};
    private String textViewArray[] = { "我的書櫃", "推薦 一書" ,"建立書櫃","願望清單","設定"};
    private List<Fragment> list = new ArrayList<Fragment>();
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);
        initView();//初始化控件
        initPage();//初始化页面
    }

    //    控件初始化控件
    private void initView() {
        vp = findViewById(R.id.pager);

        vp.addOnPageChangeListener(this);//设置页面切换时的监听器
        layoutInflater = LayoutInflater.from(this);//加载布局管理器

        mTabHost = findViewById(android.R.id.tabhost);//绑定tahost
        mTabHost.setup(this, getSupportFragmentManager(), R.id.pager);//绑定viewpager

        mTabHost.setOnTabChangedListener(this);

        //設置tabhost內容
        int count = textViewArray.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(textViewArray[i])
                    .setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.setTag(i);
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundResource(R.drawable.selector_tab_background);//设置Tab被选中的时候颜色改变
        }
    }

    //初始化fragment
    private void initPage() {


        FirstFragment  fragment1 = new FirstFragment();
        SecondFragment fragment2 = new SecondFragment();
        ThreeFragment  fragment3 = new  ThreeFragment();
        FourFragment fragment4 = new FourFragment();
        FifthFragment fragment5 = new FifthFragment();

        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);

        //绑定Fragment适配器

        vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));


        mTabHost.getTabWidget().setDividerDrawable(null);
    }

    private View getTabItemView(int i) {
        //將xml轉為成布局檔
        View view = layoutInflater.inflate(R.layout.tab_content, null);
        //利用view对象，找到布局中的组件,并设置内容，然后返回视图
        ImageView mImageView = (ImageView) view
                .findViewById(R.id.tab_imageview);
        TextView mTextView = (TextView) view.findViewById(R.id.tab_textview);
        mImageView.setBackgroundResource(imageViewArray[i]);
        mTextView.setText(textViewArray[i]);
        return view;
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }//arg0 ==1的时候表示正在滑动，arg0==2的时候表示滑动完毕了，arg0==0的时候表示什么都没做，就是停在那。

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }//表示在前一个页面滑动到后一个页面的时候，在前一个页面滑动前调用的方法

    @Override
    public void onPageSelected(int arg0) {//arg0是表示你当前选中的页面位置Postion，这事件是在你页面跳转完毕的时候调用的。
        TabWidget widget = mTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);//设置View覆盖子类控件而直接获得焦点
        mTabHost.setCurrentTab(arg0);//根据位置Postion设置当前的Tab
        widget.setDescendantFocusability(oldFocusability);//设置取消分割线

    }

    @Override
    public void onTabChanged(String tabId) {//Tab改变的时候调用
        int position = mTabHost.getCurrentTab();
        vp.setCurrentItem(position);//把选中的Tab的位置赋给适配器，让它控制页面切换
    }

}
