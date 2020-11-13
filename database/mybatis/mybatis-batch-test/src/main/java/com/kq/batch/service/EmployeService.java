package com.kq.batch.service;

import com.kq.batch.generateName.NameGenerateUtil;
import com.kq.batch.mapper.EmployeeMapper;
import com.kq.batch.util.PinYinUtil;
import com.kq.batch.util.RandomUtil;
import com.kq.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kq
 * @date 2020-11-11 13:36
 * @since 2020-0630
 */
@Service
public class EmployeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public void insertTen(){

        long id = 1;
        List<String> firstNames = NameGenerateUtil.getFirstNames();
        List<String> lastNames = NameGenerateUtil.getLastNames();

//        int index = 0;
//        for(String name : firstNames){
//            if(index>10)break;
//            String firstName = name;
//            String lastName = name;
//
//            insertNoIdAccount(firstName, lastName);
//
//            index++;
//        }

        generateName(firstNames,lastNames,lastNames);


    }

    private void insertNoIdAccount(String firstName, String lastName) {
        Employee employee = new Employee();
        employee.setFirstName(PinYinUtil.cn2Spell(firstName));
        employee.setLastName(PinYinUtil.cn2Spell(lastName));
        employee.setBirythDate(RandomUtil.getRandomDate());
        employee.setHireDate(RandomUtil.getRandomDate());
        employee.setGender(RandomUtil.getGender());

        employeeMapper.insertNoId(employee);
    }


    private void generateName(List<String> name0List,List<String> name1List,List<String> name2List){

        int name0Size = name0List.size();
        int name1Size = name1List.size();
        int name2Size = name2List.size();
        // 生成几条
        int max = 100000000;

        long size = 0;

        for(int i=0;i<name0Size;i++) {
            if(size>max) break;
            String name0 = name0List.get(i);

            //生成2个名字
            for(int j=0;j<name1Size;j++) {
                String name1 = name1List.get(j);
                System.out.println(size+":"+name0+name1);

                insertNoIdAccount(name0, name1);

                size++;
            }

            //生成3个名字
            for(int j=0;j<name1Size;j++) {
                String name1 = name1List.get(j);

                for(int k=0;k<name2Size;k++) {
                    String name2 = name2List.get(k);
                    System.out.println(size+":"+name0+name1+name2);
                    insertNoIdAccount(name0, name1+name2);
                    if(size>max) break;
                    size++;
                }

            }

        }


    }


}
