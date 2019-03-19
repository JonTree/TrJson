package com.tree.trjson.tool;

public class JsonTest2 {


    /**
     * result : 0
     * res_info : ok
     * queryorder_info : {"order_num":"5","orderdetail":"ok"}
     */

    private String result;
    private String res_info;
    private QueryorderInfoBean queryorder_info;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRes_info() {
        return res_info;
    }

    public void setRes_info(String res_info) {
        this.res_info = res_info;
    }

    public QueryorderInfoBean getQueryorder_info() {
        return queryorder_info;
    }

    public void setQueryorder_info(QueryorderInfoBean queryorder_info) {
        this.queryorder_info = queryorder_info;
    }

    public static class QueryorderInfoBean {
        /**
         * order_num : 5
         * orderdetail : ok
         */

        private String order_num;
        private String orderdetail;

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getOrderdetail() {
            return orderdetail;
        }

        public void setOrderdetail(String orderdetail) {
            this.orderdetail = orderdetail;
        }
    }
}
