package com.akzia.googleapi.directions;

import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.annotations.SerializedName;

/**
 * Шаги
 * Каждый элемент в массиве steps определяет один шаг вычисляемого маршрута.
 * Шаг является наименьшей неделимой единицей измерения маршрута,
 * в которой в которой может содержаться одна инструкция, например,
 * "Повернуть налево на 4-й Вест-стрит".
 * Шаг включает в себя не только инструкцию, но и сведения о расстоянии и продолжительности,
 * показывающие соотношение данного шага со следующим.
 * Например, шаг "Повернуть на трассу I-80 на запад" может содержать указание на продолжительность в виде "37 миль"
 * и "40 минут". Это означает, что следующий шаг будет через 37 миль и 40 минут после текущего шага.
 */
public class Step {

    /**
     * html_instructions содержит форматированные инструкции для этого шага, представленные в виде текстовой строки HTML.
     */
    @SerializedName("html_instructions")
    private String htmlInstructions;

    /**
     * distance содержит расстояние, покрываемое в этом шаге до следующего шага.
     * Если расстояние неизвестно, то данное поле может быть не определено.
     */
    @SerializedName("distance")
    private Distance distance;

    /**
     * duration обозначает общую продолжительность прохождения этого отрезка
     */
    @SerializedName("duration")
    private Duration duration;

    /**
     * start_location содержит значения координат широты и долготы исходной точки этого отрезка.
     * API маршрутов для вычисления маршрута между пунктами использует ближайший к начальному и конечному пунктам путь
     * сообщения (обычно дорогу), поэтому исходный пункт start_location может отличаться от указанной исходной точки
     * отрезка (например, если дорога находится далеко от исходной точки).
     */
    @SerializedName("start_location")
    private GeoPoint startLocation;

    /**
     * end_location содержит значения координат широты и долготы заданного пункта назначения этого отрезка.
     * API маршрутов для вычисления маршрута между пунктами использует ближайший к начальному и конечному пунктам путь
     * сообщения (обычно дорогу), поэтому конечный пункт end_location может отличаться от указанного
     * пункта назначения этого отрезка (например, если дорога находится далеко от пункта назначения).
     */
    @SerializedName("end_location")
    private GeoPoint endLocation;

    public Step() {
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public GeoPoint getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(GeoPoint startLocation) {
        this.startLocation = startLocation;
    }

    public GeoPoint getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(GeoPoint endLocation) {
        this.endLocation = endLocation;
    }

    @Override
    public String toString() {
        return "Step{" +
                "htmlInstructions='" + htmlInstructions + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                '}';
    }
}
