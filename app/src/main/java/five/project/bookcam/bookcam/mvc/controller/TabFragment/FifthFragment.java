package five.project.bookcam.bookcam.mvc.controller.TabFragment;

import android.support.v4.app.Fragment;

/**
 * Created by user on 2018/2/27.
 */

public class FifthFragment  extends Fragment {

/*
    private List<SetList_fifthfragment> memberList = new ArrayList<>();
    private List<SetList_fifthfragment> notiList = new ArrayList<>();


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    //constrcour
    public static FifthFragment instance() {
        FifthFragment view = new FifthFragment();
        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_5, container, false);



        ListView listview3 = (ListView) v.findViewById(R.id.listView2);
        ListView listview = (ListView) v.findViewById(R.id.listView3);
        listview3.setAdapter(new MemberAdapter(v.getContext(), memberList));
        listview.setAdapter(new MemberAdapters(v.getContext(), notiList));
        Button logout = (Button)v.findViewById(R.id.button2);
        logout.setOnClickListener(buttonListener);
        // Toolbar toolbar = (Toolbar)v.findViewById(R.id.toolbar);
        //((TabActivity)getActivity()).setSupportActionBar(toolbar);

        return v;
    }

    private Button.OnClickListener buttonListener = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {

            final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("登出");
            dialog.setMessage("你確定要登出？");
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    // TODO Auto-generated method stub

                }

            });
            dialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    File file = new File("/data/data/com.example.user.loginandout/shared_prefs","LoginInfo.xml");
                    file.delete();
                    Intent i = new Intent();
                    i.setClass(getActivity(), LoginActivity.class);
                    startActivity(i);
                    getActivity().finish();
                }

            });
            dialog.show();
        }
    };


    private class MemberAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;

        public MemberAdapter(Context context, List<SetList_fifthfragment> memberList) {
            layoutInflater = LayoutInflater.from((Context) context);
            memberList.add(new SetList_fifthfragment(1,R.mipmap.f6, "帳號"));
            memberList.add(new SetList_fifthfragment(2, R.mipmap.f7, "佈景"));
            memberList.add(new SetList_fifthfragment(3, R.mipmap.f8, "通知"));



        }


        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
            }

            final SetList_fifthfragment member = memberList.get(position);


            ImageView ivImage = (ImageView) convertView
                    .findViewById(R.id.ivImage);
            ivImage.setImageResource(member.getImage());

            TextView tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            tvName.setText(member.getName());

            return convertView;
        }
    }

    private class MemberAdapters extends BaseAdapter {

        private LayoutInflater layoutInflater;

        public MemberAdapters(Context context, List<SetList_fifthfragment> notiList) {
            layoutInflater = LayoutInflater.from((Context) context);
            notiList.add(new SetList_fifthfragment(4, R.mipmap.f9, "關於我們"));
            notiList.add(new SetList_fifthfragment(5, R.mipmap.f10, "問題回報"));
            notiList.add(new SetList_fifthfragment(6, R.mipmap.f11, "評分BookCam"));
        }


        @Override
        public int getCount() {
            return notiList.size();
        }

        @Override
        public Object getItem(int position) {
            return notiList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return notiList.get(position).getId();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
            }

            final SetList_fifthfragment member = notiList.get(position);

            ImageView ivImage = (ImageView) convertView
                    .findViewById(R.id.ivImage);
            ivImage.setImageResource(member.getImage());

            TextView tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            tvName.setText(member.getName());

            return convertView;
        }
    }
*/

}


