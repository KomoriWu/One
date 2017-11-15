package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017/9/16.
 */

public class OneListBean {
    private String id;
    private WeatherBean weather;
    private String date;
    private MenuBean menu;
    private List<ContentListBean> content_list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WeatherBean getWeather() {
        return weather;
    }

    public void setWeather(WeatherBean weather) {
        this.weather = weather;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
    }

    public List<ContentListBean> getContentList() {
        return content_list;
    }

    public void setContent_list(List<ContentListBean> content_list) {
        this.content_list = content_list;
    }

    public static class WeatherBean {
        /**
         * city_name : 地球
         * date : 2017-11-06
         * temperature : -275
         * humidity : 120
         * climate : 对流层
         * wind_direction : 一阵妖风
         * hurricane : 36级
         * icons : {"day":"weather_icon_unknown","night":"weather_icon_unknown_night"}
         */

        private String city_name;
        private String date;
        private String temperature;
        private String humidity;
        private String climate;
        private String wind_direction;
        private String hurricane;
        private IconsBean icons;

        public String getCityName() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getClimate() {
            return climate;
        }

        public void setClimate(String climate) {
            this.climate = climate;
        }

        public String getWind_direction() {
            return wind_direction;
        }

        public void setWind_direction(String wind_direction) {
            this.wind_direction = wind_direction;
        }

        public String getHurricane() {
            return hurricane;
        }

        public void setHurricane(String hurricane) {
            this.hurricane = hurricane;
        }

        public IconsBean getIcons() {
            return icons;
        }

        public void setIcons(IconsBean icons) {
            this.icons = icons;
        }

        public static class IconsBean {
            /**
             * day : weather_icon_unknown
             * night : weather_icon_unknown_night
             */

            private String day;
            private String night;

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getNight() {
                return night;
            }

            public void setNight(String night) {
                this.night = night;
            }
        }
    }

    public static class MenuBean {
        /**
         * vol : 1857
         * list : [{"content_type":"1","content_id":"2896","title":"黄记士多","tag":{"id":"7","title":"ONE STORY"}},{"content_type":"2","content_id":"465","serial_list":["428","429","433","436","440","442","448","449","450","452","458","459","460","461","462","463","464","465"],"title":"我在三十岁的第一年 II · 第十八话"},{"content_type":"3","content_id":"1905","title":"如何避免成为一名油腻的中年大妈？"},{"content_type":"4","content_id":"2449","title":"以为去喜欢你喜欢的一切，就能被你喜欢"},{"content_type":"5","content_id":"1215","title":"在落叶纷飞的晚秋，爱上一个最熟悉的陌生人"}]
         */

        private String vol;
        private List<ListBean> list;

        public String getVol() {
            return vol;
        }

        public void setVol(String vol) {
            this.vol = vol;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * content_type : 1
             * content_id : 2896
             * title : 黄记士多
             * tag : {"id":"7","title":"ONE STORY"}
             * serial_list : ["428","429","433","436","440","442","448","449","450","452","458","459","460","461","462","463","464","465"]
             */

            private String content_type;
            private String content_id;
            private String title;
            private TagBean tag;
            private List<String> serial_list;

            public String getContent_type() {
                return content_type;
            }

            public void setContent_type(String content_type) {
                this.content_type = content_type;
            }

            public String getContent_id() {
                return content_id;
            }

            public void setContent_id(String content_id) {
                this.content_id = content_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public TagBean getTag() {
                return tag;
            }

            public void setTag(TagBean tag) {
                this.tag = tag;
            }

            public List<String> getSerial_list() {
                return serial_list;
            }

            public void setSerial_list(List<String> serial_list) {
                this.serial_list = serial_list;
            }

            public static class TagBean {
                /**
                 * id : 7
                 * title : ONE STORY
                 */

                private String id;
                private String title;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
