package org.springframework.util.unit;

import org.junit.Test;
import org.springframework.util.StopWatch;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

/**
 * StopWatchTest
 *
 * @author kq
 * @date 2019-08-15
 */
public class StopWatchTest {

    @Test
    public void testTime() throws Exception{
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        TimeUnit.SECONDS.sleep(3);
        // stop 后 会把taskInfo放到 taskList
        stopWatch.stop();

        System.out.println("allTime:"+stopWatch.getTotalTimeSeconds());
        System.out.println("taskTime"+stopWatch.getTaskInfo()[0].getTimeSeconds());

        assertEquals(1,stopWatch.getTaskInfo().length);

        stopWatch.start();

        TimeUnit.SECONDS.sleep(3);
        // stop 后 会把TaskInfo放到 taskList
        stopWatch.stop();

        //总时间  从第1次start开始算起
        System.out.println("allTime:"+stopWatch.getTotalTimeSeconds());
        //每个任务开始 算起
        System.out.println("taskTime"+stopWatch.getTaskInfo()[1].getTimeSeconds());

        assertEquals(2,stopWatch.getTaskInfo().length);


    }

}
