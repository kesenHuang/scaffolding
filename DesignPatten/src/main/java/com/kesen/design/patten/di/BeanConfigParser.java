package com.kesen.design.patten.di;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {
	/**
	 * 根据输入流解析所有对象
	 * @param inputStream
	 * @return
	 */
	List<BeanDefinition>  parse(InputStream inputStream);

	/**
	 * 根据输入字符创建对象
	 * @param configContent
	 * @return
	 */
	List<BeanDefinition>  parse(String configContent);
}
