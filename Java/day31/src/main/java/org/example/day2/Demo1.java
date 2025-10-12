package org.example.day2;

public class Demo1 {
    public enum State{
        /* 新建 */
        NEW ,

        /* 可运行状态 */
        RUNNABLE ,

        /* 阻塞状态 */
        BLOCKED ,

        /* 无限等待状态 */
        WAITING ,

        /* 计时等待 */
        TIMED_WAITING ,

        /* 终止 */
        TERMINATED;
    }
    public State getState(){
        return State.NEW;
    }


}
