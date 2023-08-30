package org.springframework.beans.factory;


import org.junit.jupiter.api.Test;
import org.springframework.beans.entity.Children;
import org.springframework.beans.entity.Father;
import org.springframework.beans.factory.FactoryBeanTests;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.post.processor.MyPostProcessor;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanFactoryTest {

	@Test
	void testCircularReference() {
	    String path = "classpath:/org/springframework/beans/factory/bean-factory-test.xml";

		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(factory).loadBeanDefinitions(path);
		factory.addBeanPostProcessor(new MyPostProcessor());

		Father father = (Father) factory.getBean("father");
		System.out.println("father: " + father.getName());


		Children children = (Children) factory.getBean("children");
		System.out.println("children: " + children.getFather().getName());
	}
}
