package com.qg.taxi.enums;

/**
 * Created by FunriLy on 2017/7/10.
 * From small beginnings comes great things.
 */
public enum StatEnum {

    /**
     * 通用板块
     */
    VALCODE_WRONG(0, "验证码错误"),
    DEFAULT_WRONG(0, "其他错误"),
    CAUSE_TROUBLE(0, "你不要搞事"),
    ERROR_PARAM(0, "输入参数有误"),
    REQUEST_ERROR(0, "请求信息异常"),;

    private int state;
    private String stateInfo;

    StatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static StatEnum statOf(int index) {
        for (StatEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
