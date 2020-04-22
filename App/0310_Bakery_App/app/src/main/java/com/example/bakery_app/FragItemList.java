package com.example.bakery_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragItemList extends Fragment {

    int selectedItem, selectedItemIdx;
    Fragment frag_item_detail;  // 메뉴 상세 설명 화면
    Bundle bundle;

    ViewGroup vg ;
    ImageView[] img_item_list = new ImageView[8];
    Integer[] id_img_item = {R.id.img_item_01, R.id.img_item_02, R.id.img_item_03, R.id.img_item_04,
            R.id.img_item_05, R.id.img_item_06, R.id.img_item_07, R.id.img_item_08};

    int[] imgArrCookie = {R.drawable.cookie01, R.drawable.cookie02,R.drawable.cookie03, R.drawable.cookie04,
            R.drawable.muffine01, R.drawable.muffine02, R.drawable.muffine03, R.drawable.muffine04};
    int[] imgArrBread = {R.drawable.bread01, R.drawable.bread02,R.drawable.bread03, R.drawable.bread04,
            R.drawable.bread05,R.drawable.bread06, R.drawable.bread07, R.drawable.bread08};
    int[] imgArrDessert = {R.drawable.cake01, R.drawable.cake02,R.drawable.cake03, R.drawable.cake04,
            R.drawable.cake05,R.drawable.cake06, R.drawable.cake07, R.drawable.cake08};
    int[] imgArrSand = {R.drawable.sand01, R.drawable.sand02,R.drawable.sand03, R.drawable.sand04,
            R.drawable.sand05,R.drawable.sand06, R.drawable.sand07, R.drawable.sand08};

    int[][] imgArr = {imgArrCookie, imgArrBread, imgArrDessert, imgArrSand};

    public FragItemList() { }

    public FragItemList(int selectedItem) {
        this.selectedItem = selectedItem;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       vg = (ViewGroup)inflater.inflate(R.layout.frag_item_list,container, false);


        // initialize id of imageview
       for(int i=0;i<8;i++){
           img_item_list[i] = vg.findViewById(id_img_item[i]);
           img_item_list[i].setImageResource(imgArr[selectedItem][i]);
       }

       frag_item_detail = new FragItemSubMain();
       bundle = new Bundle();

        img_item_list[0].setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               selectedItemIdx = 0;
               SelectedSubItem();
           }
       });

        img_item_list[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 1;
                SelectedSubItem();
            }
        });

        img_item_list[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 2;
                SelectedSubItem();
            }
        });

        img_item_list[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 3;
                SelectedSubItem();
            }
        });

        img_item_list[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 4;
                SelectedSubItem();
            }
        });

        img_item_list[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 5;
                SelectedSubItem();
            }
        });

        img_item_list[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 6;
                SelectedSubItem();
            }
        });

        img_item_list[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItemIdx = 7;
                SelectedSubItem();
            }
        });

        return vg;
    }


    public void SelectedSubItem(){
        bundle.putInt("menu_no", selectedItem); // Key, Value
        bundle.putInt("item_no", selectedItemIdx); // Key, Value fragment.setArguments(bundle);
        frag_item_detail.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.item_layout,frag_item_detail).commit();
    }
}
