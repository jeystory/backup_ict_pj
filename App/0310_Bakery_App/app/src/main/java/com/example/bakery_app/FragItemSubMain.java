package com.example.bakery_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragItemSubMain extends Fragment {
    ViewGroup vg ;
    Button btn_sub1, btn_sub2, btn_go_cart;
    TextView txt_item_detail_title, txt_item_detail_spec, txt_item_detail_price;    //구매겟수 생각해보기..어떻게 처리할지
    ImageView img_item_detail;
    Fragment frag_item_sub01, frag_item_sub02, frag_item_sub03;
    Bundle bundle_sub;
    int menu_no, item_no;   // 대분류, 소분류 인덱스
    Spinner spinner_item_amount;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    int[] imgArrCookie = {R.drawable.cookie01, R.drawable.cookie02,R.drawable.cookie03, R.drawable.cookie04,
            R.drawable.muffine01, R.drawable.muffine02, R.drawable.muffine03, R.drawable.muffine04};
    int[] imgArrBread = {R.drawable.bread01, R.drawable.bread02,R.drawable.bread03, R.drawable.bread04,
            R.drawable.bread05,R.drawable.bread06, R.drawable.bread07, R.drawable.bread08};
    int[] imgArrDessert = {R.drawable.cake01, R.drawable.cake02,R.drawable.cake03, R.drawable.cake04,
            R.drawable.cake05,R.drawable.cake06, R.drawable.cake07, R.drawable.cake08};
    int[] imgArrSand = {R.drawable.sand01, R.drawable.sand02,R.drawable.sand03, R.drawable.sand04,
            R.drawable.sand05,R.drawable.sand06, R.drawable.sand07, R.drawable.sand08};

    int[][] imgArr = {imgArrCookie, imgArrBread, imgArrDessert, imgArrSand};


    public FragItemSubMain() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vg = (RelativeLayout)inflater.inflate(R.layout.frag_item_sub_main, container, false);


        // sub item 관련 항목 초기화
        txt_item_detail_title = vg.findViewById(R.id.txt_item_detail_title);
        txt_item_detail_spec =  vg.findViewById(R.id.txt_item_detail_spec);
        txt_item_detail_price = vg.findViewById(R.id.txt_item_detail_price);

        img_item_detail = vg.findViewById(R.id.img_item_detail);
        spinner_item_amount = vg.findViewById(R.id.spinner_item_amount);

        btn_sub1 = vg.findViewById(R.id.btn_item_sub01);
        btn_sub2 = vg.findViewById(R.id.btn_item_sub02);

        btn_go_cart = vg.findViewById(R.id.btn_go_cart);


        frag_item_sub01 = new FragItemSub01();
        frag_item_sub02 = new FragItemSub02();

        bundle_sub = new Bundle();

        if(getArguments() != null){
            menu_no = getArguments().getInt("menu_no");
            item_no = getArguments().getInt("item_no");
        } else{
            menu_no = 0;
            item_no = 0;
        }

        String str = "menu : " + menu_no + " item : " + item_no;

        txt_item_detail_title.setText("단팥 빵");
        txt_item_detail_spec.setText("엄선된 단팥앙금이 함유된 정통 단팥빵으로 남녀노소 누구나 부담없이 즐길 수 있는 간식빵입니다.");
        txt_item_detail_price.setText("가격 : 1,000원");
        img_item_detail.setImageResource(imgArr[menu_no][item_no]);

        arrayList = new ArrayList<>();
        String strNo=null;
        for(int i=1;i<=10;i++){
            strNo = i + "개";
            arrayList.add(strNo);
        }
        spinner_item_amount = vg.findViewById(R.id.spinner_item_amount);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner_item_amount.setAdapter(arrayAdapter);

        spinner_item_amount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        getFragmentManager().beginTransaction().replace(R.id.layout_sub_item,frag_item_sub01).commit();

        //  메뉴 상세 설명 페이지로 이동
        btn_sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle_sub.putInt("menu_no", menu_no); // Key, Value
                bundle_sub.putInt("item_no", item_no); // Key, Value fragment.setArguments(bundle);
                frag_item_sub01.setArguments(bundle_sub);
              getFragmentManager().beginTransaction().replace(R.id.layout_sub_item,frag_item_sub01).commit();
            }
        });

        //  구매리뷰 페이지
        btn_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle_sub.putInt("menu_no", menu_no); // Key, Value
                bundle_sub.putInt("item_no", item_no); // Key, Value fragment.setArguments(bundle);
                frag_item_sub02.setArguments(bundle_sub);
                getFragmentManager().beginTransaction().replace(R.id.layout_sub_item,frag_item_sub02).commit();
            }
        });


        // 장바구니로 이동하기
        btn_go_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cart = new Intent(getActivity(), CartActivity.class);
                startActivity(intent_cart);
                //getActivity().finish();
            }
        });

        return vg;
    }
}
