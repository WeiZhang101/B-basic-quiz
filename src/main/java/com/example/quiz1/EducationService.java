package com.example.quiz1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
@Service
public class EducationService {
    private Map<Integer, List<Education>> educationMap = new HashMap<>();

    public EducationService() {
        List<Education> educationList = new LinkedList<>();
        educationList.add(new Education(1, 2000, "title1", "dscp1"));
        educationList.add(new Education(1, 2001, "title2", "dscp2"));
        educationMap.put(1, educationList);
        educationList = new LinkedList<>();
        educationList.add(new Education(2, 2010, "title21", "dscp21"));
        educationList.add(new Education(2, 2011, "title22", "dscp22"));
        educationMap.put(2, educationList);
    }

    public List<Education> getEducationById(long id){
        for(List<Education> educationList: educationMap.values()){
            if(educationList.get(0).getUserId() == id){
                return educationList;
            }
        }
        return null;
    }

    public void createEducation(long id, Education educationAdd) {
        for(List<Education> educationList: educationMap.values()){
            if(educationList.get(0).getUserId() == id){
                educationAdd.setUserId(id);
                educationList.add(educationAdd);
//                educationMap.put((int) id, educationList);
            }
        }
    }
}
