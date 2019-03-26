package com.cc.rd.enums;

/**
 * @program: SourceEnum
 * @description: 账号来源
 * @author: cchen
 * @create: 2019-03-05 16:26
 */
public enum SourceEnum {

    SYSTEM(0, "system", "本系统");

    private Integer code;
    private String eDesc;
    private String cDesc;

    SourceEnum(Integer code, String eDesc, String cDesc) {
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

    public static SourceEnum findByCode(Integer code) {
        for (SourceEnum ld : values()) {
            if (ld.getCode().equals(code)) {
                return ld;
            }
        }
        return null;
    }

    public static SourceEnum findByEDesc(String eDesc) {
        for (SourceEnum ld : values()) {
            if (ld.geteDesc().equals(eDesc)) {
                return ld;
            }
        }
        return null;
    }
}