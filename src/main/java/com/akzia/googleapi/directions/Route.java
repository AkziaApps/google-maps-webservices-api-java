package com.akzia.googleapi.directions;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Route {

    /**
     * summary включает краткое текстовое описание маршрута, подходящее для присвоения имени и устранения неоднозначности.
     */
    @SerializedName("summary")
    private String summary;

    /**
     * copyrights содержит обязательный для отображения текст об авторских правах, относящийся к этому маршруту.
     * Вы должны самостоятельно обработать и отобразить эти сведения.
     */
    @SerializedName("copyrights")
    private String copyrights;

    /**
     * bounds – включает в себя ограничивающий прямоугольник области просмотра для маршрута.
     */
    @SerializedName("bounds")
    private Bounds bounds;

    /**
     * legs[] содержит массив с информацией об отрезке маршрута между двумя пунктами на заданном маршруте.
     * Для каждой указанной путевой точки или пункта назначения будет представлен отдельный отрезок.
     * (В массиве legs для маршрута без путевых точек будет содержаться только один отрезок.)
     * Каждый отрезок состоит из последовательности шагов (steps).
     */
    @SerializedName("legs")
    private List<Leg> legs;

    public Route() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Route{" +
                "summary='" + summary + '\'' +
                ", copyrights='" + copyrights + '\'' +
                ", bounds=" + bounds +
                ", legs=" + legs +
                '}';
    }
}
