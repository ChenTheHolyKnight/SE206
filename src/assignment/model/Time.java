package assignment.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {
    private Date _startTime;
    private Date _endTime;



    public void start(){
        _startTime=new Date();
    }

    public void end(){
        _endTime=new Date();
    }


    public String calculate(){
        long diff = _endTime.getTime() - _startTime.getTime();
        long sec= TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
        long minute=sec/60;
        long seconds=sec%60;
        String minuteStr=String.format("%02d",minute);
        String secondStr=String.format("%02d",seconds);
        //long sec=_endTime.getSeconds()-_startTime.getSeconds();
        //long minute=_endTime.getMinutes()-_startTime.getMinutes();
        String s=minuteStr+":"+secondStr;
        return s;
    }
}
