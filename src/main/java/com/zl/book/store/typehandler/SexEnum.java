package com.zl.book.store.typehandler;

public enum SexEnum {
    FEMALE(1,"女"),MALE(2,"男");
    private Integer sexId;
    private String sexValue;

    SexEnum(int sexId, String sexValue) {
        this.sexId = sexId;
        this.sexValue = sexValue;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public String getSexValue() {
        return sexValue;
    }

    public void setSexValue(String sexValue) {
        this.sexValue = sexValue;
    }

    /**
     * 插入数据库：转换为String(男 or 女)
     * @param sexValue
     * @return sexId
     */
    public static int setSexEnumId(String sexValue){
        for (SexEnum sexEnum:SexEnum.values()){
            if (sexEnum.getSexValue().equals(sexValue))
                return sexEnum.getSexId();
        }
        return 0;
    }

    /**
     * 返回数据：转换为String(男 or 女)
     * @param sexId
     * @return sexValue
     */
    public static String getSexEnumId(int sexId) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getSexId() == sexId)
                return sexEnum.getSexValue();
        }
        return "无";
    }
}
