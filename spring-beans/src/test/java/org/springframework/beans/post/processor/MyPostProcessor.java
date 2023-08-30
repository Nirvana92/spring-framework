package org.springframework.beans.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.entity.Father;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ClassUtils;

public class MyPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInstantiation =========beanClass: " + beanClass.getName() + ", beanName: " + beanName);
		if(ClassUtils.isAssignable(Father.class, beanClass)) {
			System.out.println("给father 对象进行代理, beanClass: " + beanClass.getName());
			Father father = new Father();
			father.setName("代理对象");
			return father;
		}

		return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessAfterInstantiation =========bean: " + bean + ", beanName: " + beanName);
		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessProperties =========pvs: " + pvs + ", bean: " + bean + ", beanName: " + beanName);
		return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
	}
}
