package com.marmoush.javaexamples.ocejwcd.chp16;

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.io.Serializable;

/**
 * To override the default behavior of the introspector we implement the
 * beanInfo interface.
 * 
 * @author Ismail Marmoush
 * 
 */
public class Chp16 implements BeanInfo, Serializable {
    private static final long serialVersionUID = 4461426006081188051L;

    @Override
    public BeanInfo[] getAdditionalBeanInfo() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int getDefaultEventIndex() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getDefaultPropertyIndex() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Image getIcon(int arg0) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public MethodDescriptor[] getMethodDescriptors() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
	// TODO Auto-generated method stub
	return null;
    }

}
