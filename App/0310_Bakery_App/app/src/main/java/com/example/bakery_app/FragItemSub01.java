package com.example.bakery_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragItemSub01 extends Fragment {
    ViewGroup vg ;
    TextView txt_item_sub01_spec;
    public FragItemSub01() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vg = (RelativeLayout)inflater.inflate(R.layout.frag_item_sub01,container, false);

        txt_item_sub01_spec = vg.findViewById(R.id.txt_item_sub01_spec);
        int menu_no=0, item_no=0;
        if(getArguments() != null){
            menu_no = getArguments().getInt("menu_no");
            item_no = getArguments().getInt("item_no");
        }

        txt_item_sub01_spec.setText(menu_no + "," + item_no + "의 상세 설명 페이지" );


        return vg;
    }
}
