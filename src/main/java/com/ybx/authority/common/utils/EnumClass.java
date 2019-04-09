package com.ybx.authority.common.utils;

public class EnumClass {

    /**
     * 操作类型
     */
    public enum ActionType {
        /**
         * 查询按钮
         */
        查询("get"),
        /**
         * 新增按钮
         */
        新增("add"),
        /**
         * 编辑按钮
         */
        编辑("update"),
        /**
         * 删除按钮
         */
        删除("delete");

        private String value;

        private ActionType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static ActionType getActionType(String num) {
            switch (num) {
                case "get":
                    return ActionType.查询;
                case "add":
                    return ActionType.新增;
                case "update":
                    return ActionType.编辑;
                case "delete":
                    return ActionType.删除;
                default:
                    return ActionType.查询;
            }
        }
    }

}
