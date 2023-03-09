package com.renjc.contract.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@Component
@Slf4j
public class task {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private Controller controller;


    @Scheduled(cron = "0 * 0/1 * * ?")
    public void test3(){
        logger.error("定时任务启动");
        JSONObject jsonObject = controller.getContract();
        writeContract("/data/.data2/spring_boot/file","contract",jsonObject.toString());
//        logger.error("数据结果-contract" + jsonObject.toString());
        JSONObject jsonObject1 = controller.getDept();
        writeContract("/data/.data2/spring_boot/file","dept",jsonObject1.toString());
//        logger.error("数据结果-dept" + jsonObject1.toString());
        JSONObject jsonObject2 = controller.getPerson();
        writeContract("/data/.data2/spring_boot/file","person",jsonObject2.toString());
//        logger.error("数据结果-person" + jsonObject2.toString());
    }
    public void writeContract(String path,String title,String content){
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 写入Txt文件 */
            File writename = new File(path);// 相对路径，如果没有则要建立一个新的output。txt文件
            if(!writename.exists()){
                writename.mkdirs();
            }
            writename = new File(path+"/"+title+".txt");// 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(content); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
