package com.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class First extends AbstractFunction {
    private  Object[] values;
    private CompoundVariable first,second;
    /**
     * 执行方法
     * @param sampleResult
     * @param sampler
     * @return
     * @throws InvalidVariableException
     */
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        System.out.println("execute run");
        first= (CompoundVariable) values[0];
        System.out.println(first);
        second= (CompoundVariable) values[1];
        System.out.println(second);
        int count = new Integer(first.execute().trim())+new Integer((second.execute().trim()));
        System.out.println(count);
        return String.valueOf(count);
    }

    /**
     * 设置参数接受用户的参数
     * @param collection
     * @throws InvalidVariableException
     */
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        checkParameterCount(collection,2);
        values=collection.toArray();
        System.out.println("setParameters run");
    }

    /**
     * 功能名称
     * @return
     */
    public String getReferenceKey() {
        System.out.println("getReferenceKey run");
        return String.valueOf("__MyDemo");
    }

    /**
     * 功能描述，参数描述
     * @return
     */
    public List<String> getArgumentDesc() {
        System.out.println("getArgumentDesc run");
        List list=new ArrayList<String>();
        list.add("第一个数");
        list.add("第二个数");
        return list;
    }
}
