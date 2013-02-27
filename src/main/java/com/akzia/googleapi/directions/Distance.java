package com.akzia.googleapi.directions;

import com.google.gson.annotations.SerializedName;

/**
 * distance обозначает общее расстояние, охватываемое этим отрезком
 */
public class Distance {

    /**
     * text содержит удобочитаемое представление расстояния в единицах измерения,
     * принятых в исходном пункте (или переопределенных в параметре units запроса).
     * Например, для любого исходного пункта в США будут использоваться мили и футы.
     * Обратите внимание, что, независимо от единиц измерения, в выходном тексте поле distance.value
     * всегда содержит значение в метрах.
     */
    @SerializedName("text")
    private String text;

    /**
     * value указывает расстояние в метрах.
     */
    @SerializedName("value")
    private int value;

    public Distance() {
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
        return "Distance{" +
                "text='" + text + '\'' +
                ", value=" + value +
                '}';
    }
}
