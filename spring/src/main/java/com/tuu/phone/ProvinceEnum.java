package com.tuu.phone;

public enum ProvinceEnum {
    河北省("河北省","130000"),
    北京市("北京市","110000"),
    山西省("山西省","140000"),
    内蒙古自治区("内蒙古自治区","150000"),
    辽宁省("辽宁省","210000"),
    吉林省("吉林省","220000"),
    黑龙江省("黑龙江省","230000"),
    上海市("上海市","310000"),
    江苏省("江苏省","320000"),
    浙江省("浙江省","330000"),
    安徽省("安徽省","340000"),
    福建省("福建省","350000"),
    江西省("江西省","360000"),
    山东省("山东省","370000"),
    河南省("河南省","410000"),
    湖北省("湖北省","420000"),
    湖南省("湖南省","430000"),
    广东省("广东省","440000"),
    重庆市("重庆市","500000"),
    四川省("四川省","510000"),
    云南省("云南省","530000"),
    陕西省("陕西省","610000"),
    宁夏回族自治区("宁夏回族自治区","640000"),
    无("无","000000");
    private String name;
    private String code;

    ProvinceEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}