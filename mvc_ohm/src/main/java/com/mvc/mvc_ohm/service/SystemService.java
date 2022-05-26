package com.mvc.mvc_ohm.service;


import com.mvc.mvc_ohm.dto.ResponseData;
import com.mvc.mvc_ohm.entity.DataCPUEntity;
import com.mvc.mvc_ohm.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SystemService {
    @Autowired
    DataRepository dataRepository;

    public ResponseData insertData(DataCPUEntity data){
        ResponseData responseData = new ResponseData();
        DataCPUEntity result = dataRepository.findFirstByOrderByTimeDesc();
        if(Objects.nonNull(data) && Objects.isNull(result)){
            double newTime =0;
            if(data.getTime() % 5 != 0){
                newTime = timeModify(data.getTime());
            }
            data.setTime(newTime);
            responseData.setCode("0000");
            responseData.setDetail("Add first data");
            responseData.setStatus("success");
            dataRepository.save(data);
            return responseData;
        }
        if(Objects.nonNull(data) || Objects.nonNull(result)){
            double newTime = 0;
            if(data.getCpuCore() > 0 && data.getTime() > result.getTime()){
                 newTime = timeModify(data.getTime());

                        data.setTime(newTime);
                        dataRepository.save(data);
                        responseData.setCode("0000");
                        responseData.setDetail("Add new Data");
                        responseData.setStatus("success");

                }else if(data.getCpuCore() > 0 && data.getTime() == result.getTime()){
                if(data.getCpuCore() > result.getCpuCore()){
                    result.setCpuCore(data.getCpuCore());
                    dataRepository.save(result);
                    responseData.setCode("0000");
                    responseData.setDetail("Update data because cpu is more than");
                    responseData.setStatus("success");
                }else{
                    responseData.setCode("4000");
                    responseData.setDetail("duplicate time and cpu ไม่มากกว่าตัวเก่า");
                    responseData.setStatus("success");
                }
                }else{
                responseData.setCode("4000");
                responseData.setDetail("Error validation data Cpu ต้องมากกว้า 0 หรือ time น้อยกว่าค่าล่าสุด");
                responseData.setStatus("Fail");
                }
            }else{
            responseData.setCode("4000");
            responseData.setDetail("Error data is null");
            responseData.setStatus("Fail");
        }

        return responseData;
    }

    public ResponseData getData() {
        ResponseData responseData = new ResponseData();
        List<DataCPUEntity> response  = dataRepository.findTop15ByOrderByTimeDesc();
        responseData.setData(response);
        if(response.isEmpty()){
            responseData.setCode("0000");
            responseData.setDetail("No Data");
            responseData.setStatus("Success");
        }else{
            responseData.setCode("0000");
            responseData.setDetail("Success to get Data");
            responseData.setStatus("Success");
        }
        return responseData;
    }

    private double timeModify(double oldtime){
        double newtime = oldtime;
        while(newtime % 5 != 0) {
            newtime = Math.ceil(newtime+0.1);
        }
        return newtime;
    }
}
