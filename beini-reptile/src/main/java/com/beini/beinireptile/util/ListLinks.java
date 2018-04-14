package com.beini.beinireptile.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

public class ListLinks {
	public static void main(String[] args) throws IOException {
		
		
		String url = "http://www.baidu.com";
		Validate.isTrue(!StringUtils.isEmpty(url), "usage: supply url to fetch");
		PrintUtil.print("Fetching %s...", url);

		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");
		Elements media = doc.select("[src]");
		Elements imports = doc.select("link[href]");

		PrintUtil.print("\nMedia: (%d)", media.size());
		for (Element src : media) {
			if (src.tagName().equals("img")) {
				PrintUtil.print(" * %s: <%s> %sx%s (%s)", src.tagName(), src.attr("abs:src"), src.attr("width"),
						src.attr("height"), PrintUtil.trim(src.attr("alt"), 20));
			}
			else {
				PrintUtil.print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
			}
		}

		
		PrintUtil.print("\nImports: (%d)", imports.size());
		for (Element link : imports) {
			PrintUtil.print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
		}

		PrintUtil.print("\nLinks: (%d)", links.size());
		for (Element link : links) {
			if(!StringUtils.isEmpty(link)&&!StringUtils.isEmpty(link.attr("abs:href"))) {
				PrintUtil.print(" * a: <%s>  (%s)", link.attr("abs:href"), PrintUtil.trim(link.text(), 35));
			}
		}
	}

	
}
