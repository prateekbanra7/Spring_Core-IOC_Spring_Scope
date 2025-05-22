package in.abc.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.abc.bean.WishMessageGenerator;

public class ClientApp {

	public static void main(String[] args) {

		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		
		reader.loadBeanDefinitions("in/abc/cfg/applicationContext.xml");
		
		WishMessageGenerator generator1 = factory.getBean("wmg", WishMessageGenerator.class);

		//Searching will happen in cache, it is found so get it from cache only.
		WishMessageGenerator generator2 = factory.getBean("wmg", WishMessageGenerator.class);

		System.out.println("Generator1 class object reference :: " + generator1.hashCode());
		System.out.println("Generator2 class object reference :: " + generator2.hashCode());

		System.out.println();
		
		// using the target object performing the operation and printing the result
		String result = generator1.generateWishMessage("sachin");
		System.out.println(result);
	}
}
