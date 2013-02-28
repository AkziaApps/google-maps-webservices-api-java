package com.akzia.googleapi.directions;

import com.akzia.googleapi.AbstractResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoogleDirectionsResponse extends AbstractResponse {

    /**
     * Поле "status", входящее в объект ответа службы маршрутов,
     * содержит статус запроса и может включать в себя отладочную информацию для отслеживания сбоев службы.
     */
    public enum Status {

        /**
         * OK указывает, что ответ содержит допустимый элемент result.
         */
        OK,

        /**
         * NOT_FOUND означает, что по крайней мере для одного указанного пункта
         * (исходный, пункт назначения или путевая точка) не удалось выполнить геокодирование.
         */
        NOT_FOUND,

        /**
         * ZERO_RESULTS – указывает, что между исходной точкой и пунктом назначения не найдено ни одного маршрута.
         */
        ZERO_RESULTS,

        /**
         * MAX_WAYPOINTS_EXCEEDED означает, что в запросе указано слишком много элементов массива waypoints.
         * Разрешено использовать массив waypoints, содержащий не более 8 элементов, плюс исходный и конечный пункты.
         * (Пользователи API Google Карт для организаций могут выполнять запросы, содержащие до 23 путевых точек.)
         */
        MAX_WAYPOINTS_EXCEEDED,

        /**
         * INVALID_REQUEST – указывает, что запрос является недопустимым.
         */
        INVALID_REQUEST,

        /**
         * OVER_QUERY_LIMIT – означает, что служба получила слишком много запросов от вашего приложения
         * в разрешенный период времени.
         */
        OVER_QUERY_LIMIT,

        /**
         * REQUEST_DENIED указывает, что служба отклонила запрос вашего приложения.
         */
        REQUEST_DENIED,

        /**
         * UNKNOWN_ERROR означает, что обработка запроса маршрута невозможна из-за ошибки сервера.
         * При повторной попытке запрос может быть успешно выполнен.
         */
        UNKNOWN_ERROR
    }

    /**
     * "status", содержит метаданные по запросу.
     *
     * @see Status
     */
    @SerializedName("status")
    private Status status;

    /**
     * "routes" содержит массив маршрутов из исходной точки к пункту назначения.
     *
     * @see Route
     */
    @SerializedName("routes")
    private List<Route> routes;

    public GoogleDirectionsResponse() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "GoogleDirectionsResponse{" +
                "status=" + status +
                ", routes=" + routes +
                '}';
    }
}
