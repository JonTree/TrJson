package com.tree.trjson.tool;

import java.util.List;

public class JsonTest2 {

    /**
     * feeds : [{"id":299080,"oid":288342,"category":"article","data":{"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}},{"id":299076,"oid":288340,"category":"article","data":{"subject":"荔枝新闻3.0：不止是阅读","summary":"江苏广电旗下资讯类手机应用\u201c荔枝新闻\u201d于近期推出全新升级换代的3.0版。","cover":"/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG","pic":"","format":"txt","changed":"2015-09-22 16:01:41"}}]
     * PageIndex : 1
     * PageSize : 20
     * TotalCount : 53521
     * TotalPage : 2677
     */

    private int PageIndex;
    private int PageSize;
    private int TotalCount;
    private int TotalPage;
    private List<FeedsBean> feeds;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public int getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(int TotalPage) {
        this.TotalPage = TotalPage;
    }

    public List<FeedsBean> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<FeedsBean> feeds) {
        this.feeds = feeds;
    }

    public static class FeedsBean {
        /**
         * id : 299080
         * oid : 288342
         * category : article
         * data : {"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}
         */

        private int id;
        private int oid;
        private String category;
        private DataBean data;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOid() {
            return oid;
        }

        public void setOid(int oid) {
            this.oid = oid;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * subject : 视频直播：习近平马英九会面
             * summary : 两岸领导人习近平、马英九在新加坡会面
             * cover : /Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG
             * pic :
             * format : video
             * changed : 2015-11-07 14:35:22
             */

            private String subject;
            private String summary;
            private String cover;
            private String pic;
            private String format;
            private String changed;

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getFormat() {
                return format;
            }

            public void setFormat(String format) {
                this.format = format;
            }

            public String getChanged() {
                return changed;
            }

            public void setChanged(String changed) {
                this.changed = changed;
            }
        }
    }
}
