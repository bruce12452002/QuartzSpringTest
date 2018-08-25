package network;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("LoseClassQuartz")
public class LoseClassQuartz {
	private static Logger logger = LoggerFactory.getLogger(LoseClassQuartz.class);

    public void doJob(){
        SimpleDateFormat sdfyyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdfyyyyMMddHHmmss.format(new Date());
        System.out.println("time:"+now);
    }
}
