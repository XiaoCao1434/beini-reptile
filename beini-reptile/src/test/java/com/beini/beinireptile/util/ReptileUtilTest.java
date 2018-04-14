package com.beini.beinireptile.util;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.beini.beinireptile.enums.LinkType;

public class ReptileUtilTest {
	
	private ReptileUtil reptileUtil= new ReptileUtil();
	@Test
	public void printWorkTest() {
		String url = "http://cioclass.com:8090/cioclass/";
		Set<LinkType> set = new HashSet<>();
		set.add(LinkType.LINKS);
		set.add(LinkType.IMPORTS);
		set.add(LinkType.MEDIA);
		reptileUtil.printWork(url, set);		
	}
}
