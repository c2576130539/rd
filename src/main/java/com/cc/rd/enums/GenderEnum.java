package com.cc.rd.enums;

/**
 * @program: GenderEnum
 * @description: 性别
 * @author: cchen
 * @create: 2019-03-05 16:26
 */
public enum GenderEnum {

    OTHER(0, "nothing", "无"),
    MAN(1, "man", "男人"),
    GIRL(2, "girl", "女生");

    private Integer code;
    private String eDesc;
    private String cDesc;

    GenderEnum(Integer code, String eDesc, String cDesc) {
        this.code = code;
        this.eDesc = eDesc;
        this.cDesc = cDesc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String geteDesc() {
        return eDesc;
    }

    public void seteDesc(String eDesc) {
        this.eDesc = eDesc;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public static GenderEnum findByCode(Integer code) {
        for (GenderEnum ld : values()) {
            if (ld.getCode().equals(code)) {
                return ld;
            }
        }
        return null;
    }

    public static GenderEnum findByEDesc(String eDesc) {
        for (GenderEnum ld : values()) {
            if (ld.geteDesc().equals(eDesc)) {
                return ld;
            }
        }
        return null;
    }
}