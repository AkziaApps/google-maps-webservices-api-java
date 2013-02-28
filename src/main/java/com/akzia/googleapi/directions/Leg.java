package com.akzia.googleapi.directions;

import com.akzia.googleapi.common.GeoPoint;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Отрезки
 * Каждый элемент в массиве legs указывает на отдельный отрезок пути от исходного до конечного пункта в
 * вычисленном маршруте. Маршруты без путевых точек состоят из одного "отрезка", а маршруты с одной или
 * несколькими путевыми точками – из одного или нескольких отрезков, соответствующих конкретным участкам пути.
 * <p/>
 * Пропущены следующие ненужные для данной системы параметры:
 * <p/>
 * departure_time содержит планируемое время отправления для данного отрезка, указанное в виде объекта Time.
 * Параметр departure_time доступен только для маршрутов общественного транспорта.
 * <p/>
 * arrival_time содержит расчетное время прибытия для указанного отрезка.
 * Это свойство возвращается только для маршрутов общественного транспорта. :
 */
public class Leg {

    /**
     * steps[] содержит массив шагов с информацией о каждом шаге на отрезке пути.
     */
    @SerializedName("steps")
    private List<Step> steps;

    /**
     * distance обозначает общее расстояние, охватываемое этим отрезком
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

    /**
     * start_address содержит удобочитаемый адрес (обычно улицу и номер дома),
     * отражающий значение start_location для этого отрезка.
     */
    @SerializedName("start_address")
    private String startAddress;

    /**
     * end_address содержит удобочитаемый адрес (обычно улицу и номер дома),
     * отражающий значение end_location для этого отрезка.
     */
    @SerializedName("end_address")
    private String endAddress;

    public Leg() {
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
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

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "steps=" + steps +
                ", distance=" + distance +
                ", duration=" + duration +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", startAddress='" + startAddress + '\'' +
                ", endAddress='" + endAddress + '\'' +
                '}';
    }
}
