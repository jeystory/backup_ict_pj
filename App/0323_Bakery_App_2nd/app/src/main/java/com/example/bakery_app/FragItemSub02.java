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

public class FragItemSub02 extends Fragment {
    ViewGroup vg ;
    TextView txt_item_sub02_review;
    String[][] itemName = {
            {"쿠키01", "쿠키02", "쿠키03", "쿠키04", "머핀", "초코머핀","당근머핀", "오레오머핀"},
            {"식빵", "통밀빵", "크루아상", "베이글", "크림치즈빵", "바게뜨", "우유 프래쉬 번", "우유 프레쉬 번"},
            {"버터타르트","쉬폰", "초코딸기", "딸기무스", "타르트", "레드벨벗", "치즈케익", "초코케익"},
            {"BLT", "클럽", "쿠바샌드위치", "쿠바샌드위치", "카프레제 포카챠 샌드위치", "에그", "햄치즈", "와플"}
    };

    public FragItemSub02() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       vg =  (RelativeLayout)inflater.inflate(R.layout.frag_item_sub02,container, false);

       txt_item_sub02_review = vg.findViewById(R.id.txt_item_sub02_review);

        int menu_no=0, item_no=0;
        if(getArguments() != null){
            menu_no = getArguments().getInt("menu_no");
            item_no = getArguments().getInt("item_no");
        }

        String str_review = itemName[menu_no][item_no] + "의 구매리뷰 \n"
                + "구매자 : un*****" + "\n" + "구매날짜 : 2020년 1월 3일 \n"
                + " 빠른 배송으로 맛있게 잘 먹었습니다.";


        txt_item_sub02_review.setText(str_review.toString() );


        return vg;
    }
}
