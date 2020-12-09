package com.kesen.testLinkList;

import com.kesen.list.model.Node;
import org.junit.Test;

public class ReserseTest {
	static {

	}

	@Test
	public  void test1 () {
		//System.out.println(System.currentTimeMillis());
		Node<Integer> head = new Node<>();
		Node<Integer> p = new Node<>();
		Node<Integer> q = new Node<>();
		Node<Integer> v = new Node<>();
		head.setData(1);
		p.setData(2);
		q.setData(3);
		v.setData(4);
		head.setNext(p);
		p.setNext(q);
		q.setNext(v);
		v.setNext(null);




	}
}
