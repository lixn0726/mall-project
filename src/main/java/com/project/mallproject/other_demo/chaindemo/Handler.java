package com.project.mallproject.other_demo.chaindemo;

/**
 * Description:
 * date: 2021/10/20 2:20 下午
 *
 * @author lixn
 */
public abstract class Handler {
    protected Handler successor;

    /*
     * 通用处理方法
     */
    public abstract String handleRequest(String user, double fee);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
