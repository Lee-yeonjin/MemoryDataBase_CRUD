package com.example.memorydb.db;


import com.example.memorydb.entity.Entity;
import com.example.memorydb.user.model.UserEntity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<>();

    private static long index = 0;

    public Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // create
    @Override
    public T save(T data){

        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        // db에 데이터가 있는가 ?
        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if(prevData.isPresent()){
            // 기존 데이터가 있는 경우 업데이트

            dataList.remove(prevData.get());
            dataList.add(data); // 삭제하고 다시 넣어서 update 처럼 동작함
        } else{
            index ++;
            data.setId(index);
            dataList.add(data);
        }
        return data;
    }

    // read
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll(){
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    // delete
    @Override
    public void delete(ID id){
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }

}
