package com.example.bakery_app;

public class VO_Item {
    String item_id;     // 제품 id
    String item_name;   //제품 이름
    String item_price;  //가격
    String item_spec;   // 설명
    String item_area;   // 재료원산지
    String item_nutri;  // 재료 영양정보
    String item_aller;  //알레르기

    public VO_Item(){}

    public VO_Item(String item_id, String item_name, String item_price, String item_spec, String item_area, String item_nutri, String item_aller) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_spec = item_spec;
        this.item_area = item_area;
        this.item_nutri = item_nutri;
        this.item_aller = item_aller;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public String getItem_spec() {
        return item_spec;
    }

    public String getItem_area() {
        return item_area;
    }

    public String getItem_nutri() {
        return item_nutri;
    }

    public String getItem_aller() {
        return item_aller;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public void setItem_spec(String item_spec) {
        this.item_spec = item_spec;
    }

    public void setItem_area(String item_area) {
        this.item_area = item_area;
    }

    public void setItem_nutri(String item_nutri) {
        this.item_nutri = item_nutri;
    }

    public void setItem_aller(String item_aller) {
        this.item_aller = item_aller;
    }
}
