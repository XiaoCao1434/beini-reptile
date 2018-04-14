package com.beini.beinireptile.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.beini.beinireptile.enums.LinkType;

public class ReptileUtil {

	public void printWork(String url, Set<LinkType> types) {
		print(getElements(url, types));
	}

	public Map<String, Elements> getElements(String url, Set<LinkType> types) {
		if (url == null || "".equals(url.trim())) {
			return null;
		}
		Map<String, Elements> map = new HashMap<String, Elements>();
		Document doc;
		try {
			PrintUtil.print("Fetching %s...", url);
			doc = Jsoup.connect(url).get();
			for (LinkType linkType : types) {
				switch (linkType) {
				case LINKS:
					Elements links = doc.select("a[href]");
					map.put("links", links);
					break;
				case MEDIA:
					Elements media = doc.select("[src]");
					map.put("media", media);
					break;
				case IMPORTS:
					Elements imports = doc.select("link[href]");
					map.put("imports", imports);
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public void print(Map<String, Elements> map) {
		if (map == null || map.size() < 1) {
			System.out.println("您的内容为空，暂时不需要打印！");
		}
		for (Entry<String, Elements> entry : map.entrySet()) {
			PrintUtil.print("\n%s : (%d)", entry.getKey(), entry.getValue().size());
			for (Element link : entry.getValue()) {
				PrintUtil.print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
			}
		}
	}
}
