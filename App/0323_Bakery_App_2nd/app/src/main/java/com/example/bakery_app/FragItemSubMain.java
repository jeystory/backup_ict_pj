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


    int[][] itemPrice= {
            {1100, 2100, 3100, 4100, 5100, 6100, 7100,8100},
            {1200, 2200, 3200, 4200, 5200, 6200, 7200, 8200},
            {1300, 2300, 3300, 4300, 5300, 6300, 7300, 8300},
            {1400, 2400, 3400, 4400, 5400, 6400, 7400, 8400}
    };

    String[][] itemName = {
            {"쿠키01", "쿠키02", "쿠키03", "쿠키04", "머핀", "초코머핀","당근머핀", "오레오머핀"},
            {"식빵", "통밀빵", "크루아상", "베이글", "크림치즈빵", "바게뜨", "우유 프래쉬 번", "우유 프레쉬 번"},
            {"버터타르트","쉬폰", "초코딸기", "딸기무스", "타르트", "레드벨벗", "치즈케익", "초코케익"},
            {"BLT", "클럽", "쿠바샌드위치", "쿠바샌드위치", "카프레제 포카챠 샌드위치", "에그", "햄치즈", "와플"}
    };

    String[][] itemSpec = {
            {"쿠키01", "쿠키02", "쿠키03", "쿠키04", "머핀", "초코머핀","당근머핀", "오레오머핀"},
            {"신선하고 건강한 우유를 듬뿍 넣고 정제한 연수로 만들어 더욱 건강하게 즐길 수 있는 우유식빵",
                    "통밀로 만든 로만밀에 건강곡물 오트밀, 렌틸콩을 더해 더욱 고소하고 건강한 로만밀 슈퍼플러스",
                    "바삭한 쿠키볼에 달지 않고 고소한 호두통팥 앙금이 어우러진 간식볼",
                    "우유가 들어가 부드럽고 촉촉한 아침 식사대용 모닝롤",
                    "떡처럼 쫄깃한 쑥빵에 달콤한 팥앙금이 듬-뿍",
                    "겉은 바삭 속은 촉촉한 바게뜨",
                    "겹겹이 신선한 우유가 듬뿍 들어가 부드럽고 작고 귀여운 간식용 빵",
                    "상미종으로 느리게 발효하여 더욱 풍미 깊은 주종 고구마빵"},
            {"버터타르트",
                    "쉬폰",
                    "초코딸기",
                    "딸기무스",
                    "타르트",
                    "레드벨벗",
                    "치즈케익",
                    "초코케익"},
            {"토종효모 로만밀식빵에 베이컨, 에그, 야채, 토마토를 넣어 즐기는 건강 샌드위치",
                    "건강 통밀식빵과 부드러운 후레쉬식빵에 치킨, 베이컨, 신선한 야채를 두툼하게 올린 3단 샌드위치",
                    "쫄깃한 치아바타 빵에 BBQ소스로 버무린풀드포크와 햄 아메리칸 치즈를 넣은 따뜻하게 먹는 샌드위치",
                    "토종효모 로만밀식빵에 햄&치즈와 아삭하고 고소한 코올슬로가 더해진 가장 대중적인 사양의 샌드위치",
                    "올리브오일을 넣고 구운 포카챠에 모짜렐라치즈와 신선한 토마토, 야채가 어우러진 포카챠 샌드위치",
                    "구운 조리빵 사이에 아삭한 오이와 야채를 올리고 계란, 치킨야채샐러드, 양배추믹스를 듬뿍 넣어 케찹으로 마무리한 사라다빵 샌드위치", "햄치즈", "와플"}
    };



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

        txt_item_detail_title.setText(itemName[menu_no][item_no]);
        txt_item_detail_spec.setText(itemSpec[menu_no][item_no]);
        txt_item_detail_price.setText("가격 :" + itemPrice[menu_no][item_no]);
        img_item_detail.setImageResource(imgArr[menu_no][item_no]);

        //txt_item_sub01_spec = vg.findViewById(R.id.txt_item_sub01_spec);

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

        bundle_sub.putInt("menu_no", menu_no); // Key, Value
        bundle_sub.putInt("item_no", item_no); // Key, Value fragment.setArguments(bundle);
        frag_item_sub01.setArguments(bundle_sub);
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
                //Intent intent_cart = new Intent(getActivity(), CartActivity.class);
                //startActivity(intent_cart);
                if(SaveSharedPreference.getUserName(getActivity()).length() == 0){
                    Intent intent_user = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent_user);
                    getActivity().finish();
                }else {
                    Intent intent_cart = new Intent(getActivity(), CartActivity.class);
                    //intent_cart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent_cart);
                    getActivity().finish();
                }
            }
        });

        return vg;
    }
}
