package com.kq.sentinel.demo;

import java.util.concurrent.TimeUnit;

/**
 * CalculateTimeIdxDemo
 *
 * @author kq
 * @date 2019-11-30
 */
public class CalculateTimeIdxDemo {

    protected static int windowLengthInMs = 500;

    private static int calculateTimeIdx(/*@Valid*/ long timeMillis) {
        long timeId = timeMillis / windowLengthInMs; /// time每增加一个windowLength的长度，timeId就会增加1，时间窗口就会往前滑动一个
        System.out.println("timeId="+timeId);
        // Calculate current index so we can map the timestamp to the leap array.
        return (int)(timeId % 2); // idx被分成[0,arrayLength-1]中的某一个数，作为array数组中的索引
    }


    /**
     * currentTimeMillis=1575095617070  pos=59 windowStart=1575095617000
     * currentTimeMillis=1575095620651  pos=2614 windowStart=1575095620500
     * @param timeMillis
     * @return
     */
    protected static long calculateWindowStart(/*@Valid*/ long timeMillis) {
        return timeMillis - timeMillis % windowLengthInMs;
    }

    public static void main(String[] args) {
        long count = 0;
        long currentTimeMillis = 0l;
        while (count<5000) {
            currentTimeMillis = System.currentTimeMillis();

            int idx = calculateTimeIdx(currentTimeMillis);
            long windowStart = calculateWindowStart(currentTimeMillis);

            System.out.println("inx="+idx+"  currentTimeMillis="+currentTimeMillis+"  pos="+count +" windowStart="+windowStart);

            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (Throwable e) {

            }
            count++;
        }

    }

}
