package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class PushEntity extends BaseBean {
    private BodyBean body;
    private String display_type;
    private ExtraBean extra;
    private String msg_id;

    public static class BodyBean extends BaseBean {
        private String after_open;
        private String play_lights;
        private String play_sound;
        private String play_vibrate;
        private String text;
        private String ticker;
        private String title;

        public String getAfter_open() {
            return this.after_open;
        }

        public String getPlay_lights() {
            return this.play_lights;
        }

        public String getPlay_sound() {
            return this.play_sound;
        }

        public String getPlay_vibrate() {
            return this.play_vibrate;
        }

        public String getText() {
            return this.text;
        }

        public String getTicker() {
            return this.ticker;
        }

        public String getTitle() {
            return this.title;
        }

        public void setAfter_open(String str) {
            this.after_open = str;
        }

        public void setPlay_lights(String str) {
            this.play_lights = str;
        }

        public void setPlay_sound(String str) {
            this.play_sound = str;
        }

        public void setPlay_vibrate(String str) {
            this.play_vibrate = str;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setTicker(String str) {
            this.ticker = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public static class ExtraBean extends BaseBean {
        String id;
        String title;
        String type;
        String url;

        public String getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public String getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public BodyBean getBody() {
        return this.body;
    }

    public String getDisplay_type() {
        return this.display_type;
    }

    public ExtraBean getExtra() {
        return this.extra;
    }

    public String getMsg_id() {
        return this.msg_id;
    }

    public void setBody(BodyBean bodyBean) {
        this.body = bodyBean;
    }

    public void setDisplay_type(String str) {
        this.display_type = str;
    }

    public void setExtra(ExtraBean extraBean) {
        this.extra = extraBean;
    }

    public void setMsg_id(String str) {
        this.msg_id = str;
    }
}
