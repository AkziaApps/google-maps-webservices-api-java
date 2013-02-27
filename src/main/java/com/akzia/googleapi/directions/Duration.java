package com.akzia.googleapi.directions;

import com.google.gson.annotations.SerializedName;

/**
 * duration обозначает общую продолжительность прохождения этого отрезка
 */
public class Duration {

    /**
     * text содержит удобочитаемое представление продолжительности.
     */
    @SerializedName("text")
    private String text;

    /**
     * value указывает продолжительность в секундах.
     */
    @SerializedName("value")
    private int value;

    public Duration() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "text='" + text + '\'' +
                ", value=" + value +
                '}';
    }
}
