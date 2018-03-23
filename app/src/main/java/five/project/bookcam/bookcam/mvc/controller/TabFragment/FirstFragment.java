package five.project.bookcam.bookcam.mvc.controller.TabFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import five.project.bookcam.bookcam.R;

/**
 * Created by Carson_Ho on 16/5/23.
 */
public class FirstFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, null);
        return view;
    }
}
